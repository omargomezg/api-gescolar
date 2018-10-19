package com.hardnets.gescolar.service;

import com.hardnets.gescolar.domain.dto.Apoderado;
import com.hardnets.gescolar.domain.response.AgentList;

import java.util.List;

public interface ApoderadoService {
    List<AgentList> getApoderados();
    Apoderado getApoderado(String rut);
    void addNewAgent(Apoderado model);
    void updApoderado(Apoderado apoderado, String rut);
    void delApoderado(String rut);
}
