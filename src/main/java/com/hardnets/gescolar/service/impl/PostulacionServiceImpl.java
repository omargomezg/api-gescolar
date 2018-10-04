package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.dto.Alumno;
import com.hardnets.gescolar.domain.dto.ApoderadoPostulacion;
import com.hardnets.gescolar.domain.dto.Postulacion;
import com.hardnets.gescolar.entity.AlumnoEntity;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.entity.PostulacionEntity;
import com.hardnets.gescolar.repository.AlumnoRepository;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.repository.PostulacionRepository;
import com.hardnets.gescolar.service.PostulacionService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class PostulacionServiceImpl implements PostulacionService {
    private static final SimpleDateFormat sdf = new SimpleDateFormat("dd-MM-yyyy");
    private AlumnoRepository alumnoRepository;
    private PostulacionRepository postulacionRepository;
    private FamiliaresRepository familiaresRepository;

    public PostulacionServiceImpl(AlumnoRepository alumnoRepository, PostulacionRepository postulacionRepository, FamiliaresRepository familiaresRepository) {
        this.alumnoRepository = alumnoRepository;
        this.postulacionRepository = postulacionRepository;
        this.familiaresRepository = familiaresRepository;
    }

    @Override
    public List<Postulacion> getAll(Long year) {
        List<PostulacionEntity> postulacionEntities = postulacionRepository.findAllByYear(year);
        List<Postulacion> postulaciones = new ArrayList<>();
        for (PostulacionEntity item : postulacionEntities) {
            AlumnoEntity alumnoEntity = alumnoRepository.findByRut(item.getAlumno());
            FamiliaresEntity apoderadoEntity = familiaresRepository.findByRut(alumnoEntity.getAlmnApoderado());
            Alumno alumno = new Alumno(alumnoEntity.getRut(), alumnoEntity.getNombres(),
                    alumnoEntity.getApellidoPaterno(), alumnoEntity.getApellidoMaterno());
            ApoderadoPostulacion apoderado = new ApoderadoPostulacion(apoderadoEntity.getRut(),
                    apoderadoEntity.getNombres(), apoderadoEntity.getApellidoPaterno(),
                    apoderadoEntity.getApellidoMaterno());

            postulaciones.add(new Postulacion(item.getId(), item.getYear(),
                    item.getTbSchpClaseByPostCursoPostulado().getTbSchmCursosByClasCurso().getCursDescripcion(),
                    item.getTbSchmCursosByPostCursando().getCursDescripcion(), item.getPostColegio(),
                    item.getPostEstado(), sdf.format(item.getPostFechaPostulacion()),
                    item.getPostFechaResolucion() == null ? "" : sdf.format(item.getPostFechaResolucion()), alumno,
                    apoderado));
        }

        log.info("Obtiene {} registros", postulaciones.size());
        
        return postulaciones;
    }
}
