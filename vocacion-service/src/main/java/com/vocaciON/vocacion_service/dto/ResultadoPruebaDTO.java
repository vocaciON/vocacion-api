package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResultadoPruebaDTO {


    private String resultado;
    private String recomendaciones;
    private String feedback;
    //******* de la carrera como resultado*********
    private Integer nombre;
    private Integer descripcion;
}
