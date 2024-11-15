package com.vocaciON.vocacion_service.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data

public class PaymentCaptureResponse {
    private boolean completed;
    private Long pagoId;
}
