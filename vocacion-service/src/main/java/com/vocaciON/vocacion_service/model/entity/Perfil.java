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
    @Column(name = "edad_estudiante")
    private int edadEstudiante;
    @Column(name = "grado_academico")
    private String gradoAcademico;
    @Column(name = "institucion_estudio")
    private String institucionEstudio;
    @Column(name = "carrer_interes")
    private String carrerasInteres;



    @OneToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_usuario"))
    private Usuario usuario;

    @OneToMany
    @JoinColumn(name = "asesoria_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_asesoria"))
    private List<Asesoria> asesoria;

    @OneToOne
    @JoinColumn(name = "pago_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_pago"))
    private Pago pago;

    @OneToMany
    @JoinColumn(name = "prueba_vocacion_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_prueba_vocacion"))
    private List<PruebaVocacion> pruebaVocacion;

    @OneToMany
    @JoinColumn(name = "contenido_educativo_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_perfil_contenido_educativo"))
    private List<ContenidoEducativo> contenidoEducativo;

    public void setCreatedAt(LocalDateTime now) {
    }






}
