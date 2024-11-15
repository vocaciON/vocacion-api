package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.dto.PagoDTO;
import com.vocaciON.vocacion_service.dto.PaymentCaptureResponse;
import com.vocaciON.vocacion_service.dto.PaymentOrderResponse;
import com.vocaciON.vocacion_service.integration.notificacion.email.dto.Mail;
import com.vocaciON.vocacion_service.integration.notificacion.email.service.EmailService;
import com.vocaciON.vocacion_service.integration.payment.paypal.dto.OrderCaptureResponse;
import com.vocaciON.vocacion_service.integration.payment.paypal.dto.OrderResponse;
import com.vocaciON.vocacion_service.integration.payment.paypal.service.PaypalService;
import com.vocaciON.vocacion_service.service.AdminPagoService;
import com.vocaciON.vocacion_service.service.CheckoutService;
import jakarta.mail.MessagingException;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.Map;

@Service
@RequiredArgsConstructor
public class CheckoutServiceImpl implements CheckoutService {

    private final PaypalService paypalService;
    private final AdminPagoService adminPagoService;
    private final EmailService emailService;

    @Value(("$spring.mail.username"))
    private String mailFrom;


    @Override
    public PaymentOrderResponse createPayment(Long pagoId, String returnUrl, String cancelUrl) throws MessagingException  {
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
    public PaymentCaptureResponse capturePayment(String orderId) throws Exception {
        OrderCaptureResponse orderCaptureResponse = paypalService.captureOrder(orderId);
        boolean completed = orderCaptureResponse.getStatus().equals("COMPLETED");

        PaymentCaptureResponse paypalCaptureResponse = new PaymentCaptureResponse();
        paypalCaptureResponse.setCompleted(completed);
        if (completed) {
            String pagoIdStr = orderCaptureResponse.getPagoUnits().get(0).getReferenceId();
            PagoDTO pagoDTO = adminPagoService.confirmPago(Long.parseLong(pagoIdStr));
            paypalCaptureResponse.setPagoId(pagoDTO.getId());


            sendPagoConfirmationEmail(pagoDTO);

        }
        return paypalCaptureResponse;
    }


    private void sendPagoConfirmationEmail(PagoDTO pagoDTO) throws Exception {

        Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
        String usuarioEmail = authentication.getName();

        Map<String, Object> model = new HashMap<>();
        model.put("usuario", usuarioEmail);
        model.put("pago", pagoDTO.getMonto());
        model.put("orderUrl","Http://localhost:4200/order/"+pagoDTO.getId());


        Mail mail = emailService.createMail(
                usuarioEmail,
                "Confirmacion de la compra",
                model,
                mailFrom
        );
        emailService.sendEmail(mail, "email/confirmation-template");

    }

}
