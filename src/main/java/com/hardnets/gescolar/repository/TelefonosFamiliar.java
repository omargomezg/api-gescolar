package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.entity.TelFamiliarEntity;
import org.springframework.data.jpa.repository.JpaRepository;

public interface TelefonosFamiliar extends JpaRepository<TelFamiliarEntity, Short> {

   /* @Query("SELECT f FROM TelFamiliaresEntity AS f" +
            " WHERE f.Familiar = :Familiar")
    TelFamiliarEntity findByRutApoderado(@Param("Familiar") String rutApoderado);*/
}
