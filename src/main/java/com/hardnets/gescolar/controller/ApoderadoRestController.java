package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.domain.UserModel;
import com.hardnets.gescolar.service.ApoderadoService;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class ApoderadoRestController {

    private ApoderadoService apoderadoService;

    public ApoderadoRestController(ApoderadoService apoderadoService) {
        this.apoderadoService = apoderadoService;
    }

    @GetMapping(value = "/apoderado")
    List<Apoderado> showAll() {
        return apoderadoService.apoderadoList();
    }

    @GetMapping("/apoderado/{id}")
    UserModel showFiltered(@PathVariable int id) {
        UserModel userModel = new UserModel(23, "Descripcion de un solo registro");
        return userModel;
    }

    @PostMapping("/apoderado")
    UserModel newData(@RequestBody UserModel data) {
        data.id = data.id + 23;
        return data;
    }

    @PutMapping("apoderado/{id}")
    UserModel updateData(@RequestBody UserModel data, @PathVariable int id) {
        return data;
    }

    @DeleteMapping("apoderado/{id}")
    boolean deteleItem(@PathVariable String id) {
        apoderadoService.apoderadoDelete(id);
        return id.equals("140812269");
    }
}
