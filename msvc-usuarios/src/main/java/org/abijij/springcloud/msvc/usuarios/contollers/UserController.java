package org.abijij.springcloud.msvc.usuarios.contollers;
import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;
import org.abijij.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@RestController("/api")
public class UserController {
    @Autowired
    private UsuarioService service;

    @GetMapping("/findAllUser")
    public List<Usuario> findAll(){
        return  service.findAll();
    }

    @GetMapping("/findUserById/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
         Optional<Usuario> userOptional = service.findById(id);
            if (userOptional.isPresent()){
                return ResponseEntity.ok(userOptional.get());
            }
            return ResponseEntity.notFound().build();
    }
}

