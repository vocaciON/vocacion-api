package com.vocaciON.vocacion_service.dto;


import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class PagoCreateDTO {

    @NotBlank(message = "Monto a pagar es obligatorio")
    private Float monto;

    private Long usuarioId;
    private Long compraPlanId;


}
