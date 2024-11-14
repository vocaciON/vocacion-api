package com.vocaciON.vocacion_service.integration.payment.paypal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

@Data
public class PagoUnit {
    @JsonProperty("reference_id")
    private String referenceId;
    private Amount amount;
}
