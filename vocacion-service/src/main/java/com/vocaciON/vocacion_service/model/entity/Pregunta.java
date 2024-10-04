package com.vocaciON.vocacion_service.model.entity;


import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Entity
@Table(name = "preguntas")

public class Pregunta {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "descripcion")
    private String descripcion;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;
    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;

    @ManyToOne
    @JoinColumn(name = "prueba_vocacion_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_pregunta_prueba_vocacion"))
    private PruebaVocacion pruebaVocacion;

    public void setCreatedAt(LocalDateTime now) {
    }
}
