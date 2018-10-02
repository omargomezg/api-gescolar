package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.entity.ParametrosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface ParametrosRepository extends JpaRepository<ParametrosEntity, Long> {
    @Query("SELECT p FROM ParametrosEntity p WHERE p.idGrupo = ?1 AND p.idDetalle != 0")
    List<ParametrosEntity> getByIdGrupo(short idGrupo);
}
