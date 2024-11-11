package com.vocaciON.vocacion_service.repository;

import com.vocaciON.vocacion_service.model.entity.Usuario;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

public interface UsuarioRepository extends JpaRepository<Usuario, Long> {

    //verificar que si hay un usuario usando ese correo
    boolean existsByEmail(String email);
    //metodo para buscar al usuario por email en el proceso de autenticacion
    Optional<Usuario> findByEmail(String email);

    // Verificar si hay algun usuario con el mismo nombre o apellido y telefono al registrar
    boolean existsByNombreAndApellidoAndTelefono(String nombre, String apellido, String telefono);

    // al momento de actualizar el usuario con sus datos , no se vuelva a registrar otro  ID como nuevo
    boolean existsByNombreAndApellidoAndTelefonoAndIdNot(String nombre, String apellido,String telefono,  Long id);






}
