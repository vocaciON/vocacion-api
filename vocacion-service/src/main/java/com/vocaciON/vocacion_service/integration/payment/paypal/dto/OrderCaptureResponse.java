package com.vocaciON.vocacion_service.integration.payment.paypal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderCaptureResponse {

    private String status;

    @JsonProperty("pago_units")
    private List<PagoUnit> pagoUnits;
}
