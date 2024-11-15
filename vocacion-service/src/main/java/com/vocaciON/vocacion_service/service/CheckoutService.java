package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PaymentCaptureResponse;
import com.vocaciON.vocacion_service.dto.PaymentOrderResponse;

public interface CheckoutService {

    PaymentOrderResponse createPayment(Long pagoId, String returnUrl, String cancelUrl);

    PaymentCaptureResponse capturePayment(String orderId);
}
