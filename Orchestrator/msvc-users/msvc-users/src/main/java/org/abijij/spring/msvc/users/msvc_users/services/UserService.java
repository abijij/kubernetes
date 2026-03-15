package org.abijij.spring.msvc.users.msvc_users.services;

import org.abijij.spring.msvc.users.msvc_users.models.entity.User;

import java.util.List;
import java.util.Optional;

public interface UserService {

    List<User> findAll();

    Optional<User> findById(Long id);

    User save(User user);

    void delete(Long id);

}
