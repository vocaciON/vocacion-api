package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Table(name = "resultadoPruebas")
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

    /*@ManyToOne
    @JoinColumn(name = "prueba_id", referencedColumnName = "id", nullable = false)
    private PruebaVocacion pruebaVocacion;

    @ManyToOne
    @JoinColumn(name = "usuario_id", referencedColumnName = "idUsuario", nullable = false)
    private Usuario usuario;*/

    @OneToOne(mappedBy = "resultadoPrueba", cascade = CascadeType.ALL)
    private PruebaVocacion pruebaVocacion;



}
