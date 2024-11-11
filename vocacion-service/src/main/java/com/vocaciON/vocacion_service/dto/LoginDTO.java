package com.vocaciON.vocacion_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import lombok.Data;

@Data

public class LoginDTO {

    @Email(message = "El correo electronico no es valido")
    @NotBlank(message = "El correo electronico es obligatorio")
    private String correo;

    @NotBlank(message = "La contraseña es obligatoria")
    private String password;
}
