package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.model.entity.Experto;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/usuarios")
public class AdminUsuarioController {

// inyectando las interfaces
    private final AdminUsuarioService adminUsuarioService;

    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<Usuario>>getListaUsuarios(){
        List<Usuario> usuarios = adminUsuarioService.getAll();
        return new ResponseEntity<List<Usuario>>(usuarios, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Usuario> getUsuarioById(@PathVariable("id") Long id){
        Usuario usuario = adminUsuarioService.findById(id);
        return new ResponseEntity<Usuario>(usuario, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Usuario> createUsuario(@RequestBody Usuario usuario){

        Usuario newUsuario = adminUsuarioService.create(usuario);
        return new ResponseEntity<Usuario>(newUsuario, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Usuario> updateUsuario(@PathVariable("id") Long id,
                                                 @RequestBody Usuario usuario){

        Usuario updateUsuario = adminUsuarioService.update(id,usuario);
        return new ResponseEntity<Usuario>(updateUsuario, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Usuario> deleteUsuario(@PathVariable("id") Long id,
                                                 @RequestBody Usuario usuario){

        adminUsuarioService.delete(id);
        return new ResponseEntity<Usuario>(HttpStatus.NO_CONTENT);

    }
}
