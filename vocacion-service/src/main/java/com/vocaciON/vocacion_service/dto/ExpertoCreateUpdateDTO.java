package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class ExpertoCreateUpdateDTO {



    //Adaptando a la nueva diagrama de clases

    @NotBlank(message = "La especialidad es obligatoria obligatorio")
    private String especialidad;
    @NotBlank(message = "La informacion personal es obligatorio")
    private String informacionPersonal;
}
