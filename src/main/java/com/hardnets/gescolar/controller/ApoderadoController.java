package com.hardnets.gescolar.controller;

import java.util.List;

import com.hardnets.gescolar.domain.UserModel;
import com.hardnets.gescolar.domain.dto.Apoderado;
import com.hardnets.gescolar.domain.response.ListaApoderados;
import com.hardnets.gescolar.service.ApoderadoService;

import io.swagger.annotations.ApiOperation;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/apoderado", produces = "application/json")
public class ApoderadoController {

    private ApoderadoService apoderadoService;

    public ApoderadoController(ApoderadoService apoderadoService) {
        this.apoderadoService = apoderadoService;
    }

    @ApiOperation(value = "Return list of agents")
    @GetMapping
    List<ListaApoderados> showAll() {
        return apoderadoService.getApoderados();
    }

    @GetMapping("/{rut}")
    Apoderado showFiltered(@PathVariable String rut) {
        return apoderadoService.getApoderado(rut);
    }

    @PostMapping
    void addNewAgent(@RequestBody Apoderado data) {
        apoderadoService.addNewAgent(data);
    }

    @PutMapping("/{rut}")
    void updateData(@RequestBody Apoderado data, @PathVariable String rut) {
        apoderadoService.updApoderado(data, rut);
    }

    @DeleteMapping("/{rut}")
    void deteleItem(@PathVariable String rut) {
        apoderadoService.delApoderado(rut);
    }
}
