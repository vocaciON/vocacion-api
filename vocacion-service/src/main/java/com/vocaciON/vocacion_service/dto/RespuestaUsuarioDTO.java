package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class RespuestaUsuarioDTO {

    @NotBlank(message = "La respuesta es olbigatoria")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String descripcion;

    private boolean esCorrecto;






}
