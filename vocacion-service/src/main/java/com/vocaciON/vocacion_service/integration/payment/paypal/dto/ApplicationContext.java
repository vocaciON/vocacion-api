package com.vocaciON.vocacion_service.integration.payment.paypal.dto;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.Builder;
import lombok.Data;

@Builder
@Data

public class ApplicationContext {
    @JsonProperty("brand_name")
    private String brandName;

    @JsonProperty("retur_url")
    private String returUrl;

    @JsonProperty("cancel_url")
    private String cancelUrl;

}
