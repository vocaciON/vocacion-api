package com.vocaciON.vocacion_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PreguntaDTO {

    @NotBlank(message = "La pregunta es obligatoria")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String descripcion;
}
