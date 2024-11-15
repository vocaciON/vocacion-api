package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import com.vocaciON.vocacion_service.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;

@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "usuarios")

public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "email", nullable = false)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido_usuario", nullable = false)
    private String apellido;

    @Column(name = "telefono", nullable = false)
    private String telefono;

    //ADAPTANDO AL NUEVO DIAGRAMA DE CLASES
    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;

    @Column(name = "fecha_update")
    private Date fechaUpdate;
    @Column(name= "fecha_nacimiento")
    private Date fechaNacimiento;


// Agregando como se relacionan con las tablas

//Clase usuario se asocia con perfil , pago, resultadoprueba,asesoria

//Agregando los roles del enum a usuario
    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_rol")
    private Role role;



}
