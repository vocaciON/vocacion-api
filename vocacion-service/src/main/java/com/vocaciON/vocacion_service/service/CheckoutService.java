package com.vocaciON.vocacion_service.service;

import com.vocaciON.vocacion_service.dto.PaymentCaptureResponse;
import com.vocaciON.vocacion_service.dto.PaymentOrderResponse;
import jakarta.mail.MessagingException;

public interface CheckoutService {

    PaymentOrderResponse createPayment(Long pagoId, String returnUrl, String cancelUrl)throws MessagingException;

    PaymentCaptureResponse capturePayment(String orderId) throws Exception;
}
