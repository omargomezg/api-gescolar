package com.hardnets.gescolar.impl;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.domain.Telefono;
import com.hardnets.gescolar.service.ApoderadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import javax.inject.Named;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

// @Named("apoderadoService")
@Service
public class ApoderadoServiceImpl implements ApoderadoService {
    private static Logger logger = LoggerFactory.getLogger(ApoderadoServiceImpl.class);

    public List<Apoderado> apoderadoList() {
        List<Apoderado> list = new ArrayList<>();

        List<Telefono> listTel = new ArrayList<Telefono>();
        listTel.add(new Telefono(1, "+56 9 5629 6195", "M"));
        listTel.add(new Telefono(2, "+56 2 632 341550", "F"));

        Date Nacimiento = new Date();
        list.add(new Apoderado("2345678-9", "Juan Andrés", "Alvarado", "Soto", Nacimiento, "omar.fdo.gomezmail.com", listTel));
        list.add(new Apoderado("2345678-9", "Juan Andrés", "Alvarado", "Soto", Nacimiento, "omar.fdo.gomez@gmail.com", listTel));

        return list;

    }

}
