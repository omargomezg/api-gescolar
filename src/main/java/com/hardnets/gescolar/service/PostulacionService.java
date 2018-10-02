package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.dto.Postulacion;
import com.hardnets.gescolar.entity.PostulacionEntity;

import java.util.List;

public interface PostulacionService {
    List<Postulacion> getAll(Long year);
}
