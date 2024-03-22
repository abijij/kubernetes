package org.abijij.springcloud.msvc.usuarios.repositories;

import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<Usuario, Long> {

}
