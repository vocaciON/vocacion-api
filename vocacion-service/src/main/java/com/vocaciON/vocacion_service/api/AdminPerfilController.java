package com.vocaciON.vocacion_service.api;


import com.vocaciON.vocacion_service.model.entity.Perfil;
import com.vocaciON.vocacion_service.service.AdminPerfilService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RequiredArgsConstructor
@RestController
@RequestMapping("/admin/perfiles")

public class AdminPerfilController {

    private final AdminPerfilService adminPerfilService;


    //vamos con los metodos
    // Responder las listas
    @GetMapping
    public ResponseEntity<List<Perfil>> getListaPerfiles(){
        List<Perfil> perfiles = adminPerfilService.getAll();
        return new ResponseEntity<List<Perfil>>(perfiles, HttpStatus.OK); //ok = 200
    }

    //Metodo para obtener por medio del id
    @GetMapping("/{id}")
    public ResponseEntity<Perfil> getPerfilById(@PathVariable("id") Long id){
        Perfil perfil = adminPerfilService.findById(id);
        return new ResponseEntity<Perfil>(perfil, HttpStatus.OK);
    }


    //Ahora haremos el regististro, Postmappin

    @PostMapping
    public ResponseEntity<Perfil> createPerfil(@RequestBody Perfil perfil){

        Perfil newPerfil = adminPerfilService.create(perfil);
        return new ResponseEntity<Perfil>(newPerfil, HttpStatus.CREATED);

    }

    //Put metodo para la actualizacion
    @PutMapping("/{id}")
    public ResponseEntity<Perfil> updatePerfil(@PathVariable("id") Long id,
                                                 @RequestBody Perfil perfil){

        Perfil updatePerfil = adminPerfilService.update(id,perfil);
        return new ResponseEntity<Perfil>(updatePerfil, HttpStatus.OK);

    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Perfil> deletePerfil(@PathVariable("id") Long id,
                                                 @RequestBody Perfil perfil){

        adminPerfilService.delete(id);
        return new ResponseEntity<Perfil>(HttpStatus.NO_CONTENT);

    }


}
