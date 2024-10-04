package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;
@Data

public class ExpertoDTO {

    @NotBlank(message = "Los estudios del experto es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String estudios;



    @NotBlank(message = "Especialidad es obligatorio")
    @Size(max=60, message = "No puedes pasar los 50 Caracteres")
    private String especialidad;
    @NotBlank(message = "Tu informacion Personal es obligatoria")
    @Size(max=60, message = "No puedes pasar los 50 Caracteres")
    private String informacionPersonal;


    private boolean disponibilidad;
}
