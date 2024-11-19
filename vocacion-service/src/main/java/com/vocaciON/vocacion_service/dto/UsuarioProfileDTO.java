package com.vocaciON.vocacion_service.dto;

import com.vocaciON.vocacion_service.model.enums.ERole;
import lombok.Data;

import java.util.Date;

@Data

public class UsuarioProfileDTO {
// campos que se van a mostrar
    private Long id;
    private ERole role;
    private String nombre;
    private String apellido;
    private String email;
    private String telefono;

    private Date fechaNacimiento;

    //En caso sea estudiante
    private String gradoAcademico;
    private String descripcion;

    //En caso sea experto
    private String especialidad;
    private String informacionPersonal;

}
