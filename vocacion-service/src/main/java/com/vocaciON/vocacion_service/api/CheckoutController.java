package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.PaymentCaptureResponse;
import com.vocaciON.vocacion_service.dto.PaymentOrderResponse;
import com.vocaciON.vocacion_service.service.CheckoutService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/checkout")
//@PreAuthorize("hasRole('USER')")
public class CheckoutController {
    private final CheckoutService checkoutService;


    @PostMapping("/create")
    public ResponseEntity<PaymentOrderResponse> createPaymentOrder(
            @RequestParam Long pagoId,
            @RequestParam String returnUrl,
            @RequestParam String cancelUrl,
            @RequestParam(required = false,defaultValue = "paypal") String paymentProvider
    ){
        PaymentOrderResponse response = checkoutService.createPayment(pagoId, returnUrl, cancelUrl);
        return new ResponseEntity<>(response, HttpStatus.CREATED);
    }

    @PostMapping("/capture")
    public ResponseEntity<PaymentCaptureResponse> capturePaymentOrder(
            @RequestParam String orderId,
            @RequestParam(required = false,defaultValue = "paypal")String paymentProvider
    ){
        PaymentCaptureResponse response = checkoutService.capturePayment(orderId);

        if (response.isCompleted()){
            return new ResponseEntity<>(response, HttpStatus.OK);
        }else {
            return new ResponseEntity<>(response, HttpStatus.BAD_REQUEST);
        }
    }

}
