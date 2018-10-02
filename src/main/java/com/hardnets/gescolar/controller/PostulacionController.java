package com.hardnets.gescolar.controller;

import com.hardnets.gescolar.domain.dto.Postulacion;
import com.hardnets.gescolar.entity.PostulacionEntity;
import com.hardnets.gescolar.service.PostulacionService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "postulacion", produces = "application/json")
public class PostulacionController {
    private PostulacionService postulacionService;

    public PostulacionController(PostulacionService postulacionService){this.postulacionService = postulacionService;}

    @GetMapping("/{year}")
    List<Postulacion> getAll(@PathVariable Long year){
        return postulacionService.getAll(year);
    }

}
