package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.dto.Apoderado;
import com.hardnets.gescolar.domain.UserModel;
import com.hardnets.gescolar.service.ApoderadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "apoderado", produces = "application/json")
public class ApoderadoController {

    private ApoderadoService apoderadoService;

    public ApoderadoController(ApoderadoService apoderadoService) {
        this.apoderadoService = apoderadoService;
    }

    ///
    @GetMapping
    List<Apoderado> showAll() {
        return apoderadoService.getApoderados();
    }

    @GetMapping("/{rut}")
    Apoderado showFiltered(@PathVariable String rut) {
        return 

   apoderadoService.getApoderado(rut);
    }

    @PostMapping
    UserModel newData(@RequestBody UserModel data) {
        data.id = data.id + 23;
        return data;
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
