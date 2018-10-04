package com.hardnets.gescolar.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import com.hardnets.gescolar.service.AlumnoService;

import java.util.List;

import com.hardnets.gescolar.domain.dto.Alumno;
import com.hardnets.gescolar.domain.request.AlumnoCreateRequest;

@RestController
@RequestMapping(value = "alumno", produces = "application/json")
public class AlumnoController {
    
    private AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping
    List<Alumno> getAll() {
        return alumnoService.getAll();
    }

    @PostMapping
    void insertData(@RequestBody AlumnoCreateRequest data){
        alumnoService.postData(data);
    }

}