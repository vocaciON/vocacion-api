package com.vocaciON.vocacion_service.dto;

import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import jakarta.persistence.Column;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

import java.time.LocalDateTime;
@Data

public class PagoDTO {

    private Long id;
    @NotBlank(message = "Monto a pagar es obligatorio")
    private Float monto;
    private EstadoPago estadoPago;
    private LocalDateTime fechaCreate;

    private String usuarioName;
    private String planDetalles;
}
