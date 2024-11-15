package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Role;
import com.vocaciON.vocacion_service.model.enums.ERole;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface RoleRepository extends JpaRepository<Role, Long> {
    // crear un metodo que me permita buscar el Rol por su nombre (usando ENUM(ERol))
    Optional<Role> findByName(ERole name);
}
