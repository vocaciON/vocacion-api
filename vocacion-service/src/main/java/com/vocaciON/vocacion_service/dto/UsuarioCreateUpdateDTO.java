package com.vocaciON.vocacion_service.dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

import java.util.Date;

public class UsuarioCreateUpdateDTO {

    @NotBlank(message = "El email es obligatorio createupdateDTO")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String email;

    @NotBlank(message = "La contraseña obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String password;

    @NotBlank(message = " nombre es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String nombre;

    @NotBlank(message = "Apellido es obligatorio")
    @Size(max=50, message = "No puedes pasar los 50 Caracteres")
    private String apellido;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(max=9, message = "No puedes pasar los 50 Caracteres")
    private String telefono;

    private Date fechaNacimiento;
}
