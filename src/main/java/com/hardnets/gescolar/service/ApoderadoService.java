package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.dto.Apoderado;

import java.util.List;

public interface ApoderadoService {
    List<Apoderado> getApoderados();
    Apoderado getApoderado(String rut);
    void updApoderado(Apoderado apoderado, String rut);
    void delApoderado(String rut);
}
