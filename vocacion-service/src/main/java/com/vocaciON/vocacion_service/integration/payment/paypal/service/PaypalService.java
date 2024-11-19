package com.vocaciON.vocacion_service.integration.payment.paypal.service;


import com.vocaciON.vocacion_service.exception.ResourceNotFoundException;
import com.vocaciON.vocacion_service.integration.payment.paypal.dto.*;
import com.vocaciON.vocacion_service.model.entity.Pago;
import com.vocaciON.vocacion_service.repository.PagoRepository;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Base64;
import java.util.Collections;
import java.util.List;
import java.util.Objects;

@RequiredArgsConstructor
@Service
public class PaypalService {
    @Value("${paypal.client-id}")
    private String clientId;

    @Value("${paypal.client-secret}")
    private String clientSecret;

    @Value("${paypal.api-base}")
    private String apiBase;

    @NonNull
    private PagoRepository pagoRepository;

    private RestClient paypalClient;

    @PostConstruct
    public void init(){
        paypalClient=RestClient
                .builder()
                .baseUrl(apiBase)
                .build();
    }

    public String getAccessToken(){
        MultiValueMap<String, String> body = new LinkedMultiValueMap<>();
        body.add("grant_type", "client_credentials");

        //Realizar el envio de una solicitud


        return Objects.requireNonNull(
                paypalClient.post()
                        .uri("v1/oauth2/token")
                        .contentType(MediaType.APPLICATION_FORM_URLENCODED)
                        .header(HttpHeaders.AUTHORIZATION, "Basic" + Base64.getEncoder()
                                .encodeToString((clientId+":"+clientSecret).getBytes()))
                         .body(body)
                         .retrieve()
                         .toEntity(TokenResponse.class).getBody())
                        .getAccessToken();


    }

    public OrderResponse createOrder (Long PagoId, String returnUrl, String cancelUrl){
        Pago pago = pagoRepository.findById(PagoId).orElseThrow(ResourceNotFoundException::new);

        //Contruir la solicitud de pedido de pago
        OrderRequest orderRequest = new OrderRequest();
        orderRequest.setIntent("CAPTURE");

        Amount amount = new Amount();
        amount.setCurrencyCode("USD");
        amount.setValue(pago.getMonto().toString());

        PagoUnit pagoUnit = new PagoUnit();
        pagoUnit.setReferenceId(pago.getId().toString());
        pagoUnit.setAmount(amount);

        orderRequest.setPagoUnits(Collections.singletonList(pagoUnit));


        ApplicationContext applicationContext = ApplicationContext.builder()
                .brandName("vocaciON")
                .returUrl(returnUrl)
                .cancelUrl(cancelUrl)
                .build();

        orderRequest.setApplicationContext(applicationContext);


        return paypalClient.post()
                .uri("/v2/checkout/orders")
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer"+getAccessToken())
                .body(orderRequest)
                .retrieve()
                .toEntity(OrderResponse.class)
                .getBody();



    }

    public OrderCaptureResponse captureOrder (String orderId){
        return paypalClient.post()
                .uri("/v2/checkout/orders/{order_id}/capture",orderId)
                .contentType(MediaType.APPLICATION_JSON)
                .header(HttpHeaders.AUTHORIZATION,"Bearer"+getAccessToken())
                .retrieve()
                .toEntity(OrderCaptureResponse.class)
                .getBody();

    }


}

