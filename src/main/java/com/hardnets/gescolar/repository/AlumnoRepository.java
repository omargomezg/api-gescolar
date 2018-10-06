package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, String> {
    @Query("SELECT a FROM AlumnoEntity a WHERE a.rut = ?1")
    AlumnoEntity findByRut(String rut);
}
