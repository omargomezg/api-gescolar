package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.entity.FamiliaresEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

public interface FamiliaresRepository extends JpaRepository<FamiliaresEntity, Long> {
    @Query("SELECT f FROM FamiliaresEntity AS f" +
            " WHERE f.rut = :rut")
    FamiliaresEntity findByRut(@Param("rut") String rut);
}
