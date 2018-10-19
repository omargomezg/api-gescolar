package com.hardnets.gescolar.repository;

import com.hardnets.gescolar.domain.response.StudentList;
import com.hardnets.gescolar.entity.AlumnoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import java.util.List;

public interface AlumnoRepository extends JpaRepository<AlumnoEntity, String> {
    @Query("SELECT a FROM AlumnoEntity a WHERE a.rut = ?1")
    AlumnoEntity findByRut(String rut);
    @Query("SELECT new com.hardnets.gescolar.domain.response.StudentList(a.rut, a.nombres, a.apellidoPaterno, a.apellidoMaterno, a.fechaNacimiento,ap.rut, ap.nombres + ' ' + ap.apellidoPaterno + ' ' + ap.apellidoMaterno) FROM AlumnoEntity a "
            + "JOIN a.tbSchpFamiliaresByAlmnApoderado ap")
    List<StudentList> findAllStudents();
}
