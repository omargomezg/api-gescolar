package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.dto.Postulacion;

import java.util.List;

public interface PostulacionService {
    List<Postulacion> getAll(Long year);
}
