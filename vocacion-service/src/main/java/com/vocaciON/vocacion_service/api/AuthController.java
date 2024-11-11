package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.UsuarioProfileDTO;
import com.vocaciON.vocacion_service.dto.UsuarioRegistrationDTO;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RequiredArgsConstructor
@RestController
@RequestMapping("/auth")
public class AuthController {

    private final AdminUsuarioService adminUsuarioService;


    // metodo para registrar estudiantes Perfil

    @PostMapping("/register/perfil")
    public ResponseEntity<UsuarioProfileDTO> registrarPerfil(@Valid @RequestBody UsuarioRegistrationDTO usuarioRegistrationDTO){

        UsuarioProfileDTO usuarioProfile = adminUsuarioService.registerPerfil(usuarioRegistrationDTO);
        return new ResponseEntity<>(usuarioProfile, HttpStatus.CREATED);

    }

    //metoos para registrar expertos Experto
    @PostMapping("/register/experto")
    public ResponseEntity<UsuarioProfileDTO> registrarExperto(@Valid @RequestBody UsuarioRegistrationDTO usuarioRegistrationDTO){

        UsuarioProfileDTO usuarioProfile = adminUsuarioService.registerExperto(usuarioRegistrationDTO);
        return new ResponseEntity<>(usuarioProfile, HttpStatus.CREATED);

    }
}
