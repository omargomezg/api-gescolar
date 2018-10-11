package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.ErrorCode;
import com.hardnets.gescolar.domain.dto.Apoderado;
import com.hardnets.gescolar.domain.response.ListaApoderados;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.exception.ResourceNotFoundException;
import com.hardnets.gescolar.exception.StudentException;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.repository.TelefonoRepository;
import com.hardnets.gescolar.service.ApoderadoService;
import com.hardnets.gescolar.utils.RutUtils;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.core.convert.ConversionService;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import java.util.Calendar;
import java.util.Date;
import java.util.List;
import java.util.Optional;

@RequiredArgsConstructor
@Service
@Slf4j
public class ApoderadoServiceImpl implements ApoderadoService {
    private final FamiliaresRepository familiaresRepository;
    private ConversionService conversionService;
    private TelefonoRepository telefonoRepository;

    /*
     * public ApoderadoServiceImpl(FamiliaresRepository familiaresRepository,
     * TelefonoRepository telefonoRepository, ConversionService conversionService) {
     * this.familiaresRepository = familiaresRepository; this.telefonoRepository =
     * telefonoRepository; this.conversionService = conversionService; }
     */

    @Override
    @Transactional(readOnly = true)
    public List<ListaApoderados> getApoderados() {

        log.info("Consulta apoderados");
        List<ListaApoderados> apoderados = familiaresRepository.findAllApoderados();

        log.info("Obtuvo {} registros", apoderados.size());
        return apoderados;
    }

    @Override
    public Apoderado getApoderado(String rut) {
        Apoderado apoderado = new Apoderado();
        Optional<FamiliaresEntity> apo = familiaresRepository.findByRut(rut);
        if (apo.isPresent()) {
            apoderado.setRut(apo.get().getRut());
            apoderado.setNombres(apo.get().getNombres());
            apoderado.setApellidoPaterno(StringUtils.capitalize(apo.get().getApellidoPaterno().toLowerCase()));
            apoderado.setApellidoMaterno(apo.get().getApellidoMaterno());
            apoderado.setFechaNacimiento(apo.get().getFechaNacimiento());
            apoderado.setEstadoCivil(apo.get().getEstadoCivil());
            apoderado.setCorreo(apo.get().getCorreo());
            apoderado.setTelefonoFijo(apo.get().getTelefonoFijo());
            apoderado.setTelefonoMovil(apo.get().getTelefonoMovil());
        }
        return apoderado;
    }

    @Override
    @Transactional
    public void addNewAgent(Apoderado model) {
        String rut = model.getRut();
        if (RutUtils.Validar(model.getRut())) {
            FamiliaresEntity famEntity = new FamiliaresEntity();
            Optional<FamiliaresEntity> familiar = familiaresRepository.findByRut(rut);
            if (familiar.isPresent()) {
                throw new ResourceNotFoundException(ErrorCode.FamiliaresEntity_NOT_FOUND);
            } else {
                Date dataIn = new Date(model.getFechaNacimiento().getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(dataIn);
                c.add(Calendar.DATE, 1);

                famEntity.setRut(model.getRut());
                famEntity.setNombres(model.getNombres());
                famEntity.setApellidoPaterno(model.getApellidoPaterno());
                famEntity.setApellidoMaterno(model.getApellidoMaterno());
                famEntity.setFechaNacimiento(new java.sql.Date(c.getTime().getTime()));
                famEntity.setEstadoCivil(model.getEstadoCivil());
                famEntity.setGenero(model.getGenero().toUpperCase());
                familiaresRepository.save(famEntity);
            }
        } else {
            throw new StudentException(ErrorCode.INVALID_RUT);
        }
    }

    @Override
    @Transactional
    public void updApoderado(Apoderado apoderado, String rut) {
        Optional<FamiliaresEntity> apo = familiaresRepository.findByRut(rut);
        if (apo.isPresent()) {
            if (apoderado.getFechaNacimiento() != null) {
                Date dataIn = new Date(apoderado.getFechaNacimiento().getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(dataIn);
                c.add(Calendar.DATE, 1);
                apo.get().setFechaNacimiento(new java.sql.Date(c.getTime().getTime()));
            }
            apo.get().setEstadoCivil(apoderado.getEstadoCivil());
            apo.get().setNombres(apoderado.getNombres());
            apo.get().setApellidoPaterno(apoderado.getApellidoPaterno());
            apo.get().setCorreo(apoderado.getCorreo());
        } else {
            throw new StudentException(ErrorCode.FamiliaresEntity_NOT_FOUND);
        }
    }

    @Override
    public void delApoderado(String rut) {

    }

}
