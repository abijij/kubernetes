package org.abijij.springcloud.msvc.productos.controllers;

import org.abijij.springcloud.msvc.productos.entity.Producto;
import org.abijij.springcloud.msvc.productos.services.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.util.*;

@RestController
public class ProductController {

    @Autowired
    private ProductoService service;

    @GetMapping("/findAllProduct")
    public ResponseEntity<List<Producto>> finAll() {
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<Producto> productOptional = service.findById(id);
        if(productOptional.isPresent()){
            return ResponseEntity.ok(productOptional.get());
        }
        return ResponseEntity.notFound().build();
    }

    @PostMapping("/createProduct")
    public ResponseEntity<?> create(@RequestBody Producto producto, BindingResult result){
        if (service.findByNombre(producto.getNombre()).isPresent()){
            return ResponseEntity.badRequest().body(Collections
                    .singletonMap("mensaje", "Existe ya un producto registrado con ese nombre"));
        }
        if (result.hasErrors()){
            return validate(result);
        }
        Producto productDb = service.save(producto);
        return ResponseEntity.status(HttpStatus.CREATED).body(productDb);
    }

    @PutMapping("/updateProduct/{id}")
    public ResponseEntity<?> update(@RequestBody Producto product, BindingResult result, @PathVariable Long id){
        if (result.hasErrors()){
            return validate(result);
        }
        Optional<Producto> p = service.findById(id);
        if (p.isPresent()){
            Producto productDb = p.get();
            if (!product.getNombre().equalsIgnoreCase(productDb.getNombre()) && service.findByNombre(product.getNombre()).isPresent()){
                return ResponseEntity.badRequest()
                        .body(Collections
                                .singletonMap("mensaje", "Existe ya un producto registrado con ese nombre"));
            }
            productDb.setNombre(product.getNombre());
            productDb.setDescripcion(product.getDescripcion());
            productDb.setDepartamento(product.getDepartamento());
            productDb.setStock(product.getStock());
            productDb.setPrice(product.getPrice());
            return ResponseEntity.status(HttpStatus.CREATED).body(service.save(productDb));
        }

        return ResponseEntity.notFound().build();

    }


    @DeleteMapping("/deleteById/{id}")
    public  ResponseEntity<?> delete(@PathVariable Long id){
        Optional <Producto> p = service.findById(id);
        if (p.isPresent()){
            service.delete(id);
           return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }

    private static ResponseEntity<Map<String, String>> validate(BindingResult result) {
        Map<String, String> errors = new HashMap<>();
        result.getFieldErrors().forEach(err -> {
            errors.put(err.getField(), "El campo " + err.getField() + " " + err.getDefaultMessage());
        });
        return ResponseEntity.badRequest().body(errors);
    }
}
