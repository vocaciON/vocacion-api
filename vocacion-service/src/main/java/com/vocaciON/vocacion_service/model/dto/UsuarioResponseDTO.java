package com.vocaciON.vocacion_service.model.dto;

import jakarta.persistence.Column;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;
@Data
@NoArgsConstructor
@AllArgsConstructor

public class UsuarioResponseDTO {

    private Long id_usuario;

    private String nombre;

    private String apellido;

    private String email;

    private String contraseña;

    private String telefono;

    private Date fecha_registro;

    private String tipo_usuario;
}
