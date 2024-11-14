package com.vocaciON.vocacion_service.integration.payment.paypal.service;


import com.vocaciON.vocacion_service.integration.payment.paypal.dto.TokenResponse;
import com.vocaciON.vocacion_service.repository.PagoRepository;
import jakarta.annotation.PostConstruct;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClient;

import java.util.Base64;
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


}

