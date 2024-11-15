package com.vocaciON.vocacion_service.integration.payment.paypal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderRequest {
    private String intent;

    @JsonProperty("pago_units")
    private List<PagoUnit> pagoUnits;

    @JsonProperty("application_context")
    private ApplicationContext applicationContext;
}
