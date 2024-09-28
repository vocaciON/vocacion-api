package com.vocaciON.vocacion_service.model.entity;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

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

    @Column(name = "datos_personales", nullable = false)
    private String datosPersonales;


    @OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL)
    private List<ContenidoEducativo> contenidoEducativo;






}
