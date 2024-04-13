package org.abijij.springcloud.msvc.usuarios.services;

import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;

import java.util.List;
import java.util.Optional;

public interface UsuarioService {

    List<Usuario>  findAll();
    Optional<Usuario> findById(Long id);
    Usuario save (Usuario usuario);
    void delete(Long id);

    Optional<Usuario> findByEmail(String Email);

    boolean existsByEmail(String email);



}
