package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.service.ApoderadoService;
import lombok.extern.slf4j.Slf4j;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class ApoderadoServiceImpl implements ApoderadoService {
    private static Logger logger = LoggerFactory.getLogger(ApoderadoServiceImpl.class);
    private FamiliaresRepository familiaresRepository;
    private ConversionService conversionService;

    public ApoderadoServiceImpl(FamiliaresRepository familiaresRepository,
                                ConversionService conversionService) {
        this.familiaresRepository = familiaresRepository;
        this.conversionService = conversionService;
    }

    @Override
    public List<Apoderado> apoderadoList() {

        List<FamiliaresEntity> apoderados = familiaresRepository.findAll();
        TypeDescriptor sourceType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(FamiliaresEntity.class));
        TypeDescriptor targetType = TypeDescriptor.collection(List.class, TypeDescriptor.valueOf(Apoderado.class));
        return (List<Apoderado>) conversionService.convert(apoderados, sourceType, targetType);

    }

    @Override
    public void apoderadoDelete(String Rut) {

    }

}
