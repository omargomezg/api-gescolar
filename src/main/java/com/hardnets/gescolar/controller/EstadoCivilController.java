package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.dto.EstadoCivil;
import com.hardnets.gescolar.service.EstadoCivilService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping(value = "estado-civil", produces = "application/json")
public class EstadoCivilController {

    private EstadoCivilService estadoCivilService;

    public EstadoCivilController(EstadoCivilService estadoCivilService){
        this.estadoCivilService = estadoCivilService;
    }

    @GetMapping
    List<EstadoCivil> showAll() {
        return estadoCivilService.getAll();
    }
}
