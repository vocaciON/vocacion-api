package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

public class PerfilDTO {

    @NotBlank(message = "lA Descripcion es  obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String descripcion;


    @NotBlank(message = "Grado academico es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String gradoAcademico;
    @NotBlank(message = "Institucion donde estudiaste o estudias es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String institucionEstudio;

    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String carrerasInteres;
}
