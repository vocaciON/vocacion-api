package com.vocaciON.vocacion_service.service.impl;

import com.vocaciON.vocacion_service.mapper.UsuarioMapper;
import com.vocaciON.vocacion_service.model.entity.Usuario;
import com.vocaciON.vocacion_service.repository.UsuarioRepository;
import com.vocaciON.vocacion_service.service.AdminUsuarioService;
import lombok.Data;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.time.LocalDateTime;
import java.util.List;

@Service
@RequiredArgsConstructor
@Data

public class AdminUsuarioServiceImpl implements AdminUsuarioService {

    private final UsuarioRepository usuarioRepository;
    private final UsuarioMapper usuarioMapper;

    @Transactional
    @Override
    public Usuario registrarUsuario(Usuario usuario) {
        if(usuarioRepository.existsByEmail(usuario.getEmail())) {
            throw new RuntimeException("El email ya existe");
        }
        usuario.setFechaCreate(LocalDateTime.now());
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public List<Usuario> getAll() {
        return usuarioRepository.findAll(); // Obtener toda la lista
    }

    @Transactional
    @Override
    public Usuario create(Usuario usuario) {
        return usuarioRepository.save(usuario);
    }

    @Transactional(readOnly = true)
    @Override
    public Usuario findById(Long id) {
        return usuarioRepository.findById(id).orElseThrow(
                () -> new RuntimeException("Usuario no encontrado"));
    }

    @Transactional
    @Override
    public Usuario update(Long id, Usuario usuarioUpdate) {
        Usuario usuarioFromDB = findById(id);
        usuarioFromDB.setNombre(usuarioUpdate.getNombre());
        usuarioFromDB.setApellido(usuarioUpdate.getApellido());
        usuarioFromDB.setTelefono(usuarioUpdate.getTelefono());
        usuarioFromDB.setPassword(usuarioUpdate.getPassword());
        usuarioFromDB.setEmail(usuarioUpdate.getEmail());
        usuarioFromDB.setRole(usuarioUpdate.getRole());
        usuarioFromDB.setFechaNacimiento(usuarioUpdate.getFechaNacimiento());
        usuarioFromDB.setFechaUpdate(usuarioUpdate.getFechaUpdate());
        usuarioFromDB.setFechaCreate(usuarioUpdate.getFechaCreate());


        return usuarioRepository.save(usuarioFromDB);
    }
    @Transactional
    @Override
    public void delete(Long id) {
        Usuario usuario = findById(id);
        usuarioRepository.delete(usuario);

    }
}
