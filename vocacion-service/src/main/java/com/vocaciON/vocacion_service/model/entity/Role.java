package com.vocaciON.vocacion_service.model.entity;

import com.vocaciON.vocacion_service.model.enums.ERole;
import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name = "roles")
public class Role {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Enumerated(EnumType.STRING)
    @Column(name = "name", nullable = false,unique = true)
    private ERole name;
}
