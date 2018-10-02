package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.domain.dto.Postulacion;
import com.hardnets.gescolar.entity.PostulacionEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface PostulacionRepository extends JpaRepository<PostulacionEntity, Long> {
    // @Query("SELECT NEW com.hardnets.gescolar.domain.dto.Postulacion(p.id, p.year, p.tbSchpAlumnoByPostAlumno.rut, p.tbSchpAlumnoByPostAlumno.nombres, p.tbSchpAlumnoByPostAlumno.apellidoPaterno, p.tbSchpAlumnoByPostAlumno.apellidoMaterno) FROM PostulacionEntity p WHERE p.year = ?1")
    @Query("SELECT p FROM PostulacionEntity p WHERE p.year = ?1")
    List<PostulacionEntity> findAllByYear(Long year);

}
