package org.abijij.springcloud.msvc.usuarios.contollers;
import jakarta.validation.Valid;
import org.abijij.springcloud.msvc.usuarios.models.entity.Usuario;
import org.abijij.springcloud.msvc.usuarios.services.UsuarioService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import javax.print.DocFlavor;
import java.util.*;

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


    @PostMapping("/CreateUser")
    public ResponseEntity<?> create(@Valid @RequestBody  Usuario usuario, BindingResult result){
        if (service.findByEmail(usuario.getEmail()).isPresent()){
            return ResponseEntity.badRequest().body(Collections
                    .singletonMap("mensaje", "Existe ya un usuario registrado con ese correo"));
        }
        if (result.hasErrors()){
            return validate(result);
        }
        return ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuario));
    }

    @PutMapping("/UpdateById/{id}")
    public ResponseEntity<?> update(@Valid @RequestBody Usuario usuario, BindingResult result, @PathVariable Long id){
        if (result.hasErrors()){
            return validate(result);
        }
        Optional<Usuario> o = service.findById(id);
        if (o.isPresent()){
            Usuario usuarioDb = o.get();
            if (!usuario.getEmail().equalsIgnoreCase(usuarioDb.getEmail()) && service.findByEmail(usuario.getEmail()).isPresent()){
                return ResponseEntity.badRequest()
                        .body(Collections
                        .singletonMap("mensaje", "Existe ya un usuario registrado con ese correo"));
            }
            usuarioDb.setNombre(usuario.getNombre());
            usuarioDb.setApellido(usuario.getApellido());
            usuarioDb.setTelefono(usuario.getTelefono());
            usuarioDb.setEmail(usuario.getEmail());
            usuarioDb.setPassword(usuario.getPassword());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(usuarioDb));
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/deleteById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Usuario> o = service.findById(id);
        if (o.isPresent()){
            service.delete(id);
            return ResponseEntity.noContent().build();
        }
        return  ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }


}

