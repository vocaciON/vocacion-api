package com.vocaciON.vocacion_service.model.dto;

import com.vocaciON.vocacion_service.model.entity.PruebaVocacion;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class ResultadoPruebaRequestDTO {

    private Long id_resultado;
    private String puntaje;
    private String sugerencias_carreras;
    private Usuario usuario;
    private PruebaVocacion pruebaVocacion;
}
