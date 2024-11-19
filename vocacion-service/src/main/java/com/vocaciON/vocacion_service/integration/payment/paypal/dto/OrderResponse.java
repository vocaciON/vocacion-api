package com.vocaciON.vocacion_service.integration.payment.paypal.dto;


import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Data;

import java.util.List;

@Data
public class OrderResponse {
    private String id;
    private String status;

    @JsonProperty("payment_source")
    private String paymentSource;

    private List<Link> links;
}
