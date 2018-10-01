package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.entity.FamiliaresEntity;

import java.util.List;

public interface ApoderadoService {
    List<Apoderado> apoderadoList();
    Apoderado apoderadoRut(String rut);
    void apoderadoDelete(String rut);
}
