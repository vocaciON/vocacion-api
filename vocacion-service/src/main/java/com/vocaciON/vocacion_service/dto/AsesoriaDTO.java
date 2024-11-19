package com.vocaciON.vocacion_service.dto;


import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class AsesoriaDTO {


    private String temaTratar;


    private Date fechaAsesoria;

    private String linkAsesoria;

    private EstadoAsesoria estadoAsesoria;

    private String perfilName;
    private String expertoName;


}
