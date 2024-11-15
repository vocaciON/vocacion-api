package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.util.List;
@Data
@NoArgsConstructor
@AllArgsConstructor

@Entity
@Table(name = "prueba_vocacions")

public class PruebaVocacion {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "limite_tiempo")
    private Integer limiteTiempo;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;
    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    @ManyToOne
    @JoinColumn(name = "perfil_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_prueba_vocacion_perfil"))
    private Perfil perfil;


    @OneToOne
    @JoinColumn(name = "resultadoPrueba_id", referencedColumnName = "id"
    , foreignKey = @ForeignKey(name = "FK_pruebaVocacion_resultadoPrueba"))
    private ResultadoPrueba resultadoPrueba;

    public static void setCreatedAd(LocalDateTime now) {

    }
    @OneToMany
    @JoinColumn(name = "preguntas_id",referencedColumnName = "id",
     foreignKey = @ForeignKey(name = "FK_pruebaVocacion_pregunta"))
    private List<Pregunta> preguntas;

}
