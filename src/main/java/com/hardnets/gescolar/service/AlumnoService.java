package com.hardnets.gescolar.service;

import java.util.List;

import com.hardnets.gescolar.domain.request.AlumnoCreateRequest;
import com.hardnets.gescolar.domain.response.StudentList;


public interface AlumnoService {
    List<StudentList> getAll();
    void postData(AlumnoCreateRequest data);
}