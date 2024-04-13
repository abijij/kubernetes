package org.abijij.springcloud.msvc.usuarios.repositories;

import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface UserRepository extends CrudRepository<Usuario, Long> {

    Optional<Usuario>findByEmail(String email);

}
