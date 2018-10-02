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
public class EstadoCivilImpl implements EstadoCivilService {

    private final ParametrosRepository parametrosRepository;
    private final short idGrupo = 1;

    public List<EstadoCivil> getAll() {

        List<ParametrosEntity> estados = parametrosRepository.getByIdGrupo((short)1);
        List<EstadoCivil> estadosCivil = new ArrayList<>();
        for (ParametrosEntity item : estados) {
            estadosCivil.add(new EstadoCivil(item.getParaId(), item.getParaDescripcion()));
        }
        return estadosCivil;
    }
}
