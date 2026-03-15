package org.abijij.spring.msvc.users.msvc_users.services;

import org.abijij.spring.msvc.users.msvc_users.models.entity.User;
import org.abijij.spring.msvc.users.msvc_users.repositories.UsersRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;



@Service
public class UserServiceImpl implements UserService{
    @Autowired
    private UsersRepository usersRepository;


    @Override
    @Transactional(readOnly = true)
    public List<User> findAll() {
        return (List<User>) usersRepository.findAll();
    }


    @Override
    @Transactional(readOnly = true)
    public Optional<User> findById(Long id) {
        return usersRepository.findById(id);
    }


    @Override
    @Transactional
    public User save(User user) {
        return usersRepository.save(user);
    }

    @Override
    @Transactional
    public void delete(Long id) {
        usersRepository.deleteById(id);
    }
}
