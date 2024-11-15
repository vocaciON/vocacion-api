package com.vocaciON.vocacion_service.exception;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor

public class CustomErrorResponse {

    private LocalDateTime dataTime;
    private String message;
    private String detail;
}
