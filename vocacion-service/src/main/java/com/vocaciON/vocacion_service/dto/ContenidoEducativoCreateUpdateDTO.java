package com.vocaciON.vocacion_service.dto;

import lombok.Data;

import java.time.LocalDateTime;

@Data
public class ContenidoEducativoCreateUpdateDTO {

    private String tituloContenido;
    private String contenido;
    private String link;
}
