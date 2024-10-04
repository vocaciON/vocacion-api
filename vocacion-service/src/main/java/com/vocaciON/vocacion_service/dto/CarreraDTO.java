package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class CarreraDTO {

    @NotBlank(message = "El nombre es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String nombre;

    @NotBlank(message = "La descripcion es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String descripcion;
}
