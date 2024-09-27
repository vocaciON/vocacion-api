package com.vocaciON.vocacion_service.model.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioRequestDTO {
    @NotBlank(message = "El Nombre no puede estar vacio")
    private String nombre;
    @NotBlank(message = "El Apellido no puede estar vacio")
    private String apellido;
    @Email
    private String email;
    @NotBlank(message = "La Contraseña no puede estar vacia")
    @Size(min = 5, max = 20, message = "Minimo de caracteres 5 y maximo 20")
    private String contraseña;
    @NotBlank(message = "El Telefono no puede estar vacio")
    @Size(min = 9, max = 12, message = "Ingrese Telefono 9 digitos")
    private String telefono;
    @NotBlank(message = "Elija tipo de usuario: user/admin/experto")
    private String tipo_usuario;
}
