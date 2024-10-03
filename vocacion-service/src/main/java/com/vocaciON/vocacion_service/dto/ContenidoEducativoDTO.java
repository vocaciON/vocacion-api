package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class ContenidoEducativoDTO {

    @NotBlank(message = "El tema o titulo es obligatorio")
    @Size(max=60, message = "No puedes pasar los 50 Caracteres")
    private String tituloContenido;



    @NotBlank(message = "Contenido es obligatorio")
    @Size(max=60, message = "No puedes pasar los 50 Caracteres")
    private String contenido;


    private Boolean favorito;
}
