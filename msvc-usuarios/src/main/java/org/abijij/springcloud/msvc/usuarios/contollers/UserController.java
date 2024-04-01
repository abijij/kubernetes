package org.abijij.springcloud.msvc.usuarios.contollers;
import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;
import org.abijij.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.List;
import java.util.Optional;

@RestController
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

//    @PostMapping("/CreateUser")
//    @ResponseStatus(HttpStatus.CREATED)
//    public Usuario create(@RequestBody  Usuario usuario){
//        return service.save(usuario);
//    }

    @PostMapping("/CreateUser")
    public ResponseEntity<?> create(@RequestBody  Usuario usuario){
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PutMapping("/UpdateById/{id}")
    public ResponseEntity<?> update(@RequestBody Usuario usuario, @PathVariable Long id){
        Optional<Usuario> o = service.findById(id);
        if (o.isPresent()){
            Usuario usuarioDb = o.get();
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setApellido(usuario.getApellido());
            usuarioDb.setTelefono(usuario.getTelefono());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/delteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> o = service.findById(id);
        if (o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }


}

