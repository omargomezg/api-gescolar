package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.domain.Telefono;
import com.hardnets.gescolar.entity.FamiliaresEntity;
import com.hardnets.gescolar.entity.UsuariosEntity;
import com.hardnets.gescolar.repository.FamiliaresRepository;
import com.hardnets.gescolar.service.ApoderadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.convert.ConversionService;
import org.springframework.core.convert.TypeDescriptor;
import org.springframework.stereotype.Service;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
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
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlserver://216.155.90.149",
                    "sa",
                    "Kumple22*zu+"
            );
            logger.info("[API Gescolar] => OK Succesfull");
        } catch (Exception e) {
            logger.error("[API Gescolar] => {}", e.getMessage());
        }
    }

}
