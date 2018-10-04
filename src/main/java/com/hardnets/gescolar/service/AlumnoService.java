package com.hardnets.gescolar.service;

import java.util.List;

import com.hardnets.gescolar.domain.request.AlumnoCreateRequest;
import com.hardnets.gescolar.domain.dto.Alumno;


public interface AlumnoService {
    List<Alumno> getAll();
    void postData(AlumnoCreateRequest data);
}