package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.ErrorCode;
import com.hardnets.gescolar.domain.request.AlumnoCreateRequest;
import com.hardnets.gescolar.domain.response.StudentList;
import com.hardnets.gescolar.entity.AlumnoEntity;
import com.hardnets.gescolar.exception.StudentException;
import com.hardnets.gescolar.repository.AlumnoRepository;
import com.hardnets.gescolar.service.AlumnoService;
import com.hardnets.gescolar.utils.RutUtils;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.*;

@Service
@Slf4j
public class AlumnoServiceImpl implements AlumnoService {

    private AlumnoRepository alumnoRepository;

    public AlumnoServiceImpl(AlumnoRepository alumnoRepository) {
        this.alumnoRepository = alumnoRepository;
    }

    @Override
    public List<StudentList> getAll() {
        List<StudentList> alumnosEntity = alumnoRepository.findAllStudents();

        log.info("Se han encontrado {} registros", alumnosEntity.size());
        return alumnosEntity;
    }

    @Override
    @Transactional
    public void postData(AlumnoCreateRequest data) {
        String rut = data.getRut();
        if (RutUtils.Validar(data.getRut())) {
            Optional<AlumnoEntity> arAE = alumnoRepository.findById(rut);
            if (arAE.isPresent()) {
                updateStudent(data, arAE);
            } else {
                AlumnoEntity alumno = new AlumnoEntity();

                Date dataIn = new Date(data.getFechaNacimiento().getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(dataIn);
                c.add(Calendar.DATE, 1);

                alumno.setRut(data.getRut());
                alumno.setNombres(data.getNombres());
                alumno.setApellidoMaterno(data.getApellidoMaterno());
                alumno.setApellidoPaterno(data.getApellidoPaterno());
                alumno.setFechaNacimiento(new java.sql.Date(c.getTime().getTime()));
                alumno.setAlmnEstado(data.getEstado());
                alumno.setAlmnGenero(data.getGenero());
                alumnoRepository.save(alumno);
            }
        } else {
            throw new StudentException(ErrorCode.INVALID_RUT);
        }
    }

    private void updateStudent(AlumnoCreateRequest student, Optional<AlumnoEntity> opData) {
        opData.get().setNombres(student.getNombres());
        opData.get().setApellidoPaterno(student.getApellidoPaterno());
        opData.get().setApellidoMaterno(student.getApellidoMaterno());

    }
}