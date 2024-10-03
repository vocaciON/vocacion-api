package com.vocaciON.vocacion_service.api;

import com.vocaciON.vocacion_service.model.entity.RespuestaUsuario;
import com.vocaciON.vocacion_service.service.AdminRespuestaUsuarioService;
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
    public ResponseEntity<List<RespuestaUsuario>> getListaRespuestaUsuarios() {
        List<RespuestaUsuario> respuestaUsuarios = adminRespuestaUsuarioService.getAll();
        return new ResponseEntity<List<RespuestaUsuario>>(respuestaUsuarios, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> getRespuestaUsuarioById(@PathVariable("id") Long id){
        RespuestaUsuario respuestaUsuario = adminRespuestaUsuarioService.findById(id);
        return new ResponseEntity<RespuestaUsuario>(respuestaUsuario, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<RespuestaUsuario> createRespuestaUsuario(@RequestBody RespuestaUsuario respuestaUsuario){

        RespuestaUsuario newRespuestaUsuario = adminRespuestaUsuarioService.create(respuestaUsuario);
        return new ResponseEntity<RespuestaUsuario>(newRespuestaUsuario, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> updateRespuestaUsuario(@PathVariable("id") Long id,
                                                   @RequestBody RespuestaUsuario respuestaUsuario){

        RespuestaUsuario updateRespuestaUsuario = adminRespuestaUsuarioService.update(id,respuestaUsuario);
        return new ResponseEntity<RespuestaUsuario>(updateRespuestaUsuario, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<RespuestaUsuario> deleteRespuestaUsuario(@PathVariable("id") Long id,
                                                   @RequestBody RespuestaUsuario respuestaUsuario){

        adminRespuestaUsuarioService.delete(id);
        return new ResponseEntity<RespuestaUsuario>(HttpStatus.NO_CONTENT);

    }
}
