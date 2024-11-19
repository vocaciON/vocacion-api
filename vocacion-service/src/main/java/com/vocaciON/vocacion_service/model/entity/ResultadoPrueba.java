package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;

@Entity
@Table(name = "resultado_pruebas")
@Data
@NoArgsConstructor
@AllArgsConstructor


public class ResultadoPrueba {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "resultado")
    private String resultado;

    @Column(name = "recomendaciones")
    private String recomendaciones;

    @Column(name = "feedback")
    private String feedback;

    @Column(name = "fecha_create")
    private LocalDateTime fechaCreate;
    @Column(name = "fecha_update")
    private LocalDateTime fechaUpdate;




    @OneToOne
    @JoinColumn(name = "carrera_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_resultado_prueba_carrera"))
    private Carrera carrera;



}
