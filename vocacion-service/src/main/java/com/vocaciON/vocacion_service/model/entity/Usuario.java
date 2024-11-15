package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.ERole;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.Date;

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


// asociar la entidad role a usuario
    @ManyToOne(fetch = FetchType.EAGER)
    @JoinColumn(name = "role_id", referencedColumnName = "id")
    private Role role;

    // llamando al estudiante para su registro
    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Perfil perfil;
    // llamando al experto para su registro
    @OneToOne(mappedBy = "usuario",cascade = CascadeType.ALL, fetch = FetchType.LAZY)
    private Experto experto;





}
