package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.Apoderado;

import java.util.List;

public interface ApoderadoService {
    List<Apoderado> apoderadoList();
    void apoderadoDelete(String Rut);
}
