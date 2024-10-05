package com.vocaciON.vocacion_service.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@NoArgsConstructor
@AllArgsConstructor
@Entity
@Table(name = "respuestas")
public class Respuesta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;
    @Column(name = "es_correcto")
    private boolean esCorrecto;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;


    @OneToOne
    @JoinColumn(name = "pregunta_id", referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_respuesta_pregunta"))
    private Pregunta pregunta;

    public void setCreatedAt(LocalDateTime now) {

    }
}
