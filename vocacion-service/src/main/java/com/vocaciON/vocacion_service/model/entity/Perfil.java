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
    @Column(name = "edadEstudiante")
    private int edadEstudiante;
    @Column(name = "gradoAcademico")
    private String gradoAcademico;
    @Column(name = "intitucionEstudio")
    private String institucionEstudio;
    @Column(name = "carrerInteres")
    private String carrerasInteres;





    @OneToMany(mappedBy = "perfil",cascade = CascadeType.ALL)
    private List<ContenidoEducativo> contenidoEducativo;

    public void setCreatedAt(LocalDateTime now) {
    }






}
