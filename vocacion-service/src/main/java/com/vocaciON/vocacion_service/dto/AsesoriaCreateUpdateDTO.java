package com.vocaciON.vocacion_service.dto;


import com.vocaciON.vocacion_service.model.enums.EstadoAsesoria;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.NonNull;

import java.util.Date;

@Data
public class AsesoriaCreateUpdateDTO {
    private Long id;

    @NotBlank(message = "El tema o titulo es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String temaTratar;

    @NotBlank(message = "La fecha de inicio de la asesoria es obligatoria")
    private Date fechaAsesoria;

    @NotBlank(message = "El link es obligatorio")
    @Size(max=50, message = "No puedes pasar los 30 Caracteres")
    private String linkAsesoria;

    private EstadoAsesoria estadoAsesoria;

    @NotNull(message ="El Experto es obligatoria")
    private Long expertoId;
    @NotNull(message="El estudiante es Obligatorio")
    private Long perfilId;
}
