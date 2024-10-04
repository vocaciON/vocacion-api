package com.vocaciON.vocacion_service.dto;

import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

@Data
public class ResultadoPruebaDTO {

    @NotBlank(message = "El Resultado es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String resultado;

    @NotBlank(message = "Recomendacion es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String recomendaciones;

    @NotBlank(message = "La FeedBack es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String feedback;
}
