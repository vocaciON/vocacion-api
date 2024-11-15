package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
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

    @PostMapping("/register")
    public ResponseEntity<Usuario> registrar(@RequestBody Usuario usuario){

        Usuario newUsuario = adminUsuarioService.registrarUsuario(usuario);
        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);

    }
}
