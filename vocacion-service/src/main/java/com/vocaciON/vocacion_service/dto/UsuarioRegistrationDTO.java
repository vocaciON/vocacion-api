package com.vocaciON.vocacion_service.dto;

import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.util.Date;

@Data
public class UsuarioRegistrationDTO {
    @NotBlank(message = "EL nombre es obligatorio")
    private String nombre;
    @NotBlank(message = "EL apellido es obligatorio")
    private String apellido;

    @Email(message = "El correo electronico no es valido")
    @NotBlank(message = "EL correo es obligatorio usuarioRegistrationDTO")
    private String email;

    @NotBlank(message = "la contraseña es obligatorio")
    @Size(min = 4, message = "la contraseña debe tener al menos 4 caracteres")
    private String password;

    @NotBlank(message = "El telefono es obligatorio")
    @Size(max=9, message = "No puedes pasar los 50 Caracteres")
    private String telefono;

    private Date fechaNacimiento;



    // si es un (perfil)estudiante me pide esto adicional
    private String gradoAcademico;
    private String descripcion;



    // si es un experto , me pide esto adicional
    private String especialidad;
    private String informacionPersonal;

}
