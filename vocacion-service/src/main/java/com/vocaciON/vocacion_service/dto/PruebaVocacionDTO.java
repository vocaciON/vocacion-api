package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PruebaVocacionDTO {

    @NotBlank(message = "El Nombre o titulo es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String nombre;

    @NotBlank(message = "El Descripcion es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String descripcion;

}
