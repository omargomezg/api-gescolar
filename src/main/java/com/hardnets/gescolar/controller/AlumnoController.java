package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.response.StudentList;
import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.*;
import com.hardnets.gescolar.service.AlumnoService;

import java.util.List;

import com.hardnets.gescolar.domain.dto.Alumno;
import com.hardnets.gescolar.domain.request.AlumnoCreateRequest;

@RestController
@RequestMapping(value = "/api/alumno", produces = "application/json")
public class AlumnoController {
    
    private AlumnoService alumnoService;

    public AlumnoController(AlumnoService alumnoService) {
        this.alumnoService = alumnoService;
    }

    @GetMapping("/{year}/{classroom}")
    List<StudentList> getAll(@PathVariable short year, @PathVariable int classroom) {
        return alumnoService.getAll();
    }

    @GetMapping("/{year}")
    @ApiOperation(value = "Return a list of students for specific year")
    List<StudentList> getAll(@PathVariable short year) {
        return alumnoService.getAll();
    }

    @GetMapping
    @ApiOperation(value = "Return a list of students in system")
    List<StudentList> getAll() {
        return alumnoService.getAll();
    }

    @PostMapping
    void insertData(@RequestBody AlumnoCreateRequest data){
        alumnoService.postData(data);
    }

}