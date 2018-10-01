package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.domain.Telefono;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.entity.TelefonosEntity;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.repository.TelefonoRepository;
import com.hardnets.gescolar.service.ApoderadoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Slf4j
public class ApoderadoServiceImpl implements ApoderadoService {
    private static Logger logger = LoggerFactory.getLogger(ApoderadoServiceImpl.class);
    Apoderado apoderado = new Apoderado();
    private FamiliaresRepository familiaresRepository;
    private ConversionService conversionService;
    private TelefonoRepository telefonoRepository;

    public ApoderadoServiceImpl(FamiliaresRepository familiaresRepository,
                                TelefonoRepository telefonoRepository,
                                ConversionService conversionService) {
        this.familiaresRepository = familiaresRepository;
        this.telefonoRepository = telefonoRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<Apoderado> apoderadoList() {

        List<FamiliaresEntity> familiaresEntities = familiaresRepository.findAll();
        List<Apoderado> apoderados = new ArrayList<>();
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FamiliaresEntity.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Apoderado.class));

        for (FamiliaresEntity item : familiaresEntities) {
            apoderado.setRut(item.getRut());
            apoderado.setNombres(item.getNombres());
            apoderado.setApellidoPaterno(item.getApPaterno());
            apoderado.setApellidoMaterno(item.getApMaterno());
            apoderados.add(apoderado);
        }

        return apoderados;

    }

    @Override
    public Apoderado apoderadoRut(String rut) {
        FamiliaresEntity apo = familiaresRepository.findByRut(rut);
        apoderado.setRut(apo.getRut());
        apoderado.setNombres(apo.getNombres());
        apoderado.setApellidoPaterno(apo.getApPaterno());
        apoderado.setApellidoMaterno(apo.getApMaterno());
        apoderado.setFechaNacimiento(apo.getFamiNacimiento());

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
    public void apoderadoDelete(String rut) {

    }

}
