package com.hardnets.gescolar.service.impl;

import com.hardnets.gescolar.domain.Apoderado;
import com.hardnets.gescolar.domain.Telefono;
import com.hardnets.gescolar.service.ApoderadoService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;

import java.sql.Connection;
import java.sql.DriverManager;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class ApoderadoServiceImpl implements ApoderadoService {
    private static Logger logger = LoggerFactory.getLogger(ApoderadoServiceImpl.class);

    @Override
    public List<Apoderado> apoderadoList() {

        List<Apoderado> list = new ArrayList<>();

        List<Telefono> listTel = new ArrayList<Telefono>();
        listTel.add(new Telefono(1, "+56 9 5629 6195", "M"));
        listTel.add(new Telefono(2, "+56 2 632 341550", "F"));

        Date Nacimiento = new Date();
        list.add(new Apoderado("2345678-9", "Juan Andrés", "Alvarado", "Soto", Nacimiento, "omar.gomez@mail.com", listTel));
        list.add(new Apoderado("2345678-9", "Juan Andrés", "Alvarado", "Soto", Nacimiento, "omar.fdo.gomez@gmail.com", listTel));
        logger.info("[API Gescolar] => Recupera lista de apoderados");
        return list;

    }

    @Override
    public void apoderadoDelete(String Rut) {
        try {
            Connection conn = DriverManager.getConnection(
                    "jdbc:sqlserver://216.155.90.149",
                    "sa",
                    "Kumple22*zu+"
            );
            logger.info("[API Gescolar] => OK Succesfull");
        } catch (Exception e) {
            logger.error("[API Gescolar] => {}", e.getMessage());
        }
    }

}
