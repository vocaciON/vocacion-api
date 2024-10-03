package com.vocaciON.vocacion_service.dto;

import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;

import java.time.LocalDateTime;

public class PagoDTO {
    @NotBlank(message = "Monto a pagar es obligatorio")
    private Float monto;

    private EstadoPago estadoPago;

    private LocalDateTime fechaCreate;
}
