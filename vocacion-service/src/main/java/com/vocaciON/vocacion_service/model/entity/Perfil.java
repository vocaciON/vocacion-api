package com.vocaciON.vocacion_service.model.entity;

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
@Table(name = "perfiles")

public class Perfil {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "grado_academico")
    private String gradoAcademico;
    @Column(name = "institucion_estudio")
    private String institucionEstudio;
    @Column(name = "carrer_interes")
    private String carrerasInteres;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;
    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;


    @OneToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id")
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "contenido_educativo_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_contenido_educativo"))
    private ContenidoEducativo contenidoEducativo;

}
