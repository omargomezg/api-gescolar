package com.hardnets.gescolar.repository;

import java.util.List;
import java.util.Optional;

import com.hardnets.gescolar.domain.response.AgentList;
import com.hardnets.gescolar.entity.FamiliaresEntity;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface FamiliaresRepository extends JpaRepository<FamiliaresEntity, String> {
    @Query("SELECT new com.hardnets.gescolar.domain.response.AgentList(f.rut, CONCAT(f.nombres, ' ' , f.apellidoPaterno, ' ' , f.apellidoMaterno), f.correo, f.telefonoFijo, f.telefonoMovil) FROM FamiliaresEntity f")
    List<AgentList> findAllAgents();
    Optional<FamiliaresEntity> findByRut(String rut);
}
