package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Entity
@Table(name = "ContenidoEducativos")
@Data
@NoArgsConstructor
@AllArgsConstructor

public class ContenidoEducativo {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nombre", nullable = false)
    private String nombre;

    @Column(name = "tipo", nullable = false)
    private String tipo;

    @Column(name = "contenido", nullable = false)
    private String contenido;

    @Column(name = "favorito")
    private Boolean favorito;

    @ManyToOne
    @JoinColumn(name = "perfil_id",referencedColumnName = "id",
    foreignKey = @ForeignKey(name = "FK_contenidoEducativo_perfil"))
    private Perfil perfil;


}
