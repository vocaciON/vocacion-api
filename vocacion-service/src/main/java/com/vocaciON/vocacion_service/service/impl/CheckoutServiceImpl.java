package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.dto.PaymentCaptureResponse;
import com.vocaciON.vocacion_service.dto.PaymentOrderResponse;
import com.vocaciON.vocacion_service.integration.payment.paypal.dto.OrderCaptureResponse;
import com.vocaciON.vocacion_service.integration.payment.paypal.dto.OrderResponse;
import com.vocaciON.vocacion_service.integration.payment.paypal.service.PaypalService;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import com.vocaciON.vocacion_service.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final PaypalService paypalService;
    private final AdminPagoService adminPagoService;


    @Override
    public PaymentOrderResponse createPayment(Long pagoId, String returnUrl, String cancelUrl) {
        OrderResponse orderResponse = paypalService.createOrder(pagoId, returnUrl, cancelUrl);

        String paypalUrl = orderResponse
                .getLinks()
                .stream()
                .filter(link -> link.getRel().equals("approve"))
                .findFirst()
                .orElseThrow(RuntimeException::new)
                .getHref();
        return new PaymentOrderResponse(paypalUrl);
    }

    @Override
    public PaymentCaptureResponse capturePayment(String orderId) {
        OrderCaptureResponse orderCaptureResponse = paypalService.captureOrder(orderId);
        boolean completed = orderCaptureResponse.getStatus().equals("COMPLETED");

        PaymentCaptureResponse paypalCaptureResponse = new PaymentCaptureResponse();
        paypalCaptureResponse.setCompleted(completed);
        if (completed) {
            String pagoIdStr = orderCaptureResponse.getPagoUnits().get(0).getReferenceId();
            PagoDTO pagoDTO = adminPagoService.confirmPago(Long.parseLong(pagoIdStr));
            paypalCaptureResponse.setPagoId(pagoDTO.getId());
        }
        return paypalCaptureResponse;
    }
}
