package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.UsuarioProfileDTO;
import com.vocaciON.vocacion_service.dto.UsuarioRegistrationDTO;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

@RestController
@RequiredArgsConstructor
@PreAuthorize("hastRole('USER','EXPERTO')")
@RequestMapping("/usuario/profile")

public class UsuarioProfileController {

    private final AdminUsuarioService adminUsuarioService;

    //Actualizar el perfil del usuario

    @PutMapping("/{id}")
    public ResponseEntity<UsuarioProfileDTO> updateProfile(@PathVariable Long id, @RequestBody UsuarioProfileDTO usuarioProfileDTO) {
        UsuarioProfileDTO updateProfile = adminUsuarioService.updateUsuarioProfile(id, usuarioProfileDTO);
        return new ResponseEntity<>(updateProfile, HttpStatus.OK);
    }

    //Obtener el perfil de un usuario por Id

    @GetMapping("/{id}")
    public ResponseEntity<UsuarioProfileDTO> getProfile(@PathVariable Long id) {
        UsuarioProfileDTO usuarioProfile = adminUsuarioService.getUsuarioProfileById(id);
        return new ResponseEntity<>(usuarioProfile, HttpStatus.OK);
    }
}
