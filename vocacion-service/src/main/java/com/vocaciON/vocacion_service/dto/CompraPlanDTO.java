package com.vocaciON.vocacion_service.dto;

import lombok.Data;

@Data

public class CompraPlanDTO {
    private Long id;
    private Float total;
    private String nombrePlan;
    private String descripcionPlan;
}
