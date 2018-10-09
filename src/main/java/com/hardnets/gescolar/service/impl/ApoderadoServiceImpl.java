package com.hardnets.gescolar.service.impl;

import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import com.hardnets.gescolar.domain.dto.Apoderado;
import com.hardnets.gescolar.domain.dto.Telefono;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.entity.TelefonosEntity;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.repository.TelefonoRepository;
import com.hardnets.gescolar.service.ApoderadoService;

import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.util.StringUtils;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;

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
    @SuppressWarnings("unchecked")
    @Transactional(readOnly = true)
    public List<Apoderado> getApoderados() {

        log.info("Consulta apoderados");
        List<FamiliaresEntity> familiaresEntities = familiaresRepository.findAll();
        // List<Apoderado> apoderados = new ArrayList<>();
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class,
                TypeDescriptor.valueOf(FamiliaresEntity.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Apoderado.class));

        log.info("Obtuvo {} registros", familiaresEntities.size());
        return (List<Apoderado>) conversionService.convert(familiaresEntities, sourceType, targetType);

        /*
         * for (FamiliaresEntity item : familiaresEntities) {
         * apoderado.setRut(item.getRut()); apoderado.setNombres(item.getNombres());
         * apoderado.setApellidoPaterno(item.getApellidoPaterno());
         * apoderado.setApellidoMaterno(item.getApellidoMaterno());
         * apoderados.add(apoderado); }
         */
        // log.info("Se han encontrado {} registros", apoderados.size());

        // return apoderados;

    }

    @Override
    public Apoderado getApoderado(String rut) {
        Apoderado apoderado = new Apoderado();
        FamiliaresEntity apo = familiaresRepository.findByRut(rut);
        apoderado.setRut(apo.getRut());
        apoderado.setNombres(apo.getNombres());
        apoderado.setApellidoPaterno(StringUtils.capitalize(apo.getApellidoPaterno().toLowerCase()));
        apoderado.setApellidoMaterno(apo.getApellidoMaterno());
        apoderado.setFechaNacimiento(apo.getFechaNacimiento());
        apoderado.setEstadoCivil(apo.getEstadoCivil());

        List<TelefonosEntity> telefonosEntity = telefonoRepository.findByRut(rut);

        List<Telefono> telefonos = new ArrayList<>();
        for (TelefonosEntity item : telefonosEntity) {
            Telefono telefono = new Telefono();
            telefono.setId(item.getId());
            telefono.setNumero(item.getNumero());
            telefono.setTipo(item.getTipo());
            telefonos.add(telefono);
        }
        apoderado.setTelefonos(telefonos);

        return apoderado;
    }

    @Override
    @Transactional
    public void updApoderado(Apoderado apoderado, String rut) {
        FamiliaresEntity apo = familiaresRepository.findByRut(rut);
        if (apo != null) {
            if (apoderado.getFechaNacimiento() != null) {
                Date dataIn = new Date(apoderado.getFechaNacimiento().getTime());
                Calendar c = Calendar.getInstance();
                c.setTime(dataIn);
                c.add(Calendar.DATE, 1);
                apo.setFechaNacimiento(new java.sql.Date(c.getTime().getTime()));
            }
            apo.setEstadoCivil(apoderado.getEstadoCivil());
            apo.setNombres(apoderado.getNombres());
            apo.setApellidoPaterno(apoderado.getApellidoPaterno());
            apo.setCorreo(apoderado.getCorreo());
        }
    }

    @Override
    public void delApoderado(String rut) {

    }

}
