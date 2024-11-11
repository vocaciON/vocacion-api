package com.vocaciON.vocacion_service.dto;


import lombok.Data;

@Data
public class AuthResponseDTO {
    private String token; // el token jw t
    private String nombre; // el primer nombre de usuario
    private String apellido; // el apel lido del ususario
    private String role; // el rol del usuario

}
