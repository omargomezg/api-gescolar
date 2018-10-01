package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.entity.TelefonosEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.util.List;

public interface TelefonoRepository extends JpaRepository<TelefonosEntity, Short> {
    @Query("SELECT t FROM TelefonosEntity t JOIN TelFamiliarEntity tf ON t.id = tf.telefono" +
            " WHERE tf.familiar = :rut")
    List<TelefonosEntity> findByRut(@Param("rut") String rut);
}
