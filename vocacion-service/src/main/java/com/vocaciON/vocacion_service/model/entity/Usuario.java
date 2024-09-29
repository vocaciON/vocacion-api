package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.EstadoPago;
import com.vocaciON.vocacion_service.model.enums.Role;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "email", nullable = false, unique = true)
    private String email;

    @Column(name = "password", nullable = false)
    private String password;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "apellido", nullable = false)
    private String apellido;

    @Column(name = "telefono")
    private String telefono;



// Agregando como se relacionan con las tablas

//Clase usuario se asocia con perfil , pago, resultadoprueba,asesoria
    @OneToOne
    @JoinColumn(name = "perfil_id", referencedColumnName = "id"
    , foreignKey = @ForeignKey(name = "FK_usuario_perfil"))
    private Perfil perfil;

    @OneToOne
    @JoinColumn(name="pago_id", referencedColumnName = "id"
    , foreignKey = @ForeignKey(name = "FK_usuario_pago"))
    private Pago pago;

    @OneToMany
    @JoinColumn(name = "pruebaVocacion_id", referencedColumnName = "id",
    foreignKey = @ForeignKey (name = "FK_pruebaVocacion_Usuario"))
    private List<PruebaVocacion> pruebaVocacion;

    @OneToMany
    @JoinColumn(name = "asesoria_id", referencedColumnName = "id"
    ,foreignKey = @ForeignKey(name = "FK_usuario_asesoria"))
    private List<Asesoria> asesoria;

//Agregando los roles del enum a usuario
    @Enumerated(EnumType.STRING)
    @Column(name = "usuario_Rol")
    private Role role;



}
