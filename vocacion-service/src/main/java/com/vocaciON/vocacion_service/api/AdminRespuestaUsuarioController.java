package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.dto.AsesoriaDTO;
import com.vocaciON.vocacion_service.dto.RespuestaUsuarioDTO;
import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;
import com.vocaciON.vocacion_service.service.AdminRespuestaUsuarioService;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequiredArgsConstructor
@RequestMapping("/admin/respuestaUsuarios")

public class AdminRespuestaUsuarioController {

    private final AdminRespuestaUsuarioService adminRespuestaUsuarioService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<RespuestaUsuarioDTO>> getListaRespuestaUsuario() {
        List<RespuestaUsuarioDTO> respuestaUsuarios = AdminRespuestaUsuarioService.getAll();
        return new ResponseEntity<>(respuestaUsuarios, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaUsuarioDTO> getRespuestaUsuarioById(@PathVariable("id") Long id){
        RespuestaUsuarioDTO asesoria = adminRespuestaUsuarioService.findById(id);
        return new ResponseEntity<>(asesoria, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<RespuestaUsuarioDTO> create(@Valid @RequestBody RespuestaUsuarioDTO respuestaUsuarioDTO){

        RespuestaUsuarioDTO createRespuestaUsuario = adminRespuestaUsuarioService.create(respuestaUsuarioDTO);
        return new ResponseEntity<>(createRespuestaUsuario, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<RespuestaUsuarioDTO> update(@PathVariable("id") Long id,@Valid@RequestBody RespuestaUsuarioDTO respuestaUsuarioDTO){

        RespuestaUsuarioDTO updateRespuestaUsuario = adminRespuestaUsuarioService.update(id,respuestaUsuarioDTO);
        return new ResponseEntity<>(updateRespuestaUsuario, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> delete(@PathVariable Long id){

        adminRespuestaUsuarioService.delete(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);

    }
}
