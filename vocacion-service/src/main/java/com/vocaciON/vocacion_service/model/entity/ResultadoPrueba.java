package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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



    @OneToOne
    @JoinColumn(name = "prueba_vocacion_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_resultado_prueba_prueba_vocacion"))
    private PruebaVocacion pruebaVocacion;

    @OneToOne
    @JoinColumn(name = "usuario_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_resultado_prueba_usuario"))
    private Usuario usuario;

    @OneToOne
    @JoinColumn(name = "perfil_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_resultado_prueba_perfil"))
    private Perfil perfil;
    @OneToOne
    @JoinColumn(name = "carrera_id",referencedColumnName = "id",
            foreignKey = @ForeignKey(name = "FK_resultado_prueba_carrera"))
    private Carrera carrera;



}
