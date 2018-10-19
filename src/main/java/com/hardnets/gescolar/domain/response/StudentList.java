package com.hardnets.gescolar.domain.response;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import org.apache.commons.text.WordUtils;

import java.util.Date;

@NoArgsConstructor
@Getter
@Setter
public class StudentList {
    private String rutAlumno;
    private String nombreAlumno;
    private String paternoAlumno;
    private String maternoAlumno;
    private Date fechaNacimiento;
    private String rutApoderado;
    private String nombreApoderado;

    public StudentList(String rutAlumno, String nombreAlumno, String paternoAlumno, String maternoAlumno, Date fechaNacimiento, String rutApoderado, String nombreApoderado){
        this.rutAlumno = rutAlumno;
        this.nombreAlumno = WordUtils.capitalizeFully(nombreAlumno);
        this.paternoAlumno = WordUtils.capitalizeFully(paternoAlumno);
        this.maternoAlumno = WordUtils.capitalizeFully(maternoAlumno);
        this.fechaNacimiento = fechaNacimiento;
        this.rutApoderado = rutApoderado;
        this.nombreApoderado = WordUtils.capitalizeFully(nombreApoderado);
    }

}
