package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.dto.EstadoCivil;
import com.hardnets.gescolar.entity.ParametrosEntity;
import com.hardnets.gescolar.repository.ParametrosRepository;
import com.hardnets.gescolar.service.EstadoCivilService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@RequiredArgsConstructor
@Service
@Slf4j
public class EstadoCivilServiceImpl implements EstadoCivilService {

    private ParametrosRepository parametrosRepository;

    public EstadoCivilServiceImpl(ParametrosRepository parametrosRepository) {
        this.parametrosRepository = parametrosRepository;
    }

    public List<EstadoCivil> getAll() {

        List<ParametrosEntity> estados = parametrosRepository.getByIdGrupo((short) 1);
        List<EstadoCivil> estadosCivil = new ArrayList<>();
        for (ParametrosEntity item : estados) {
            estadosCivil.add(new EstadoCivil(item.getParaId(), item.getParaDescripcion()));
        }
        log.info("Encuentra {} registros", estadosCivil.size());
        return estadosCivil;
    }
}
