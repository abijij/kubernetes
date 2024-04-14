package org.abijij.springcloud.msvc.factura.msvcfactura.controllers;

import jakarta.validation.Valid;
import org.abijij.springcloud.msvc.factura.msvcfactura.models.entity.Factura;
import org.abijij.springcloud.msvc.factura.msvcfactura.services.FacturaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Optional;

@RestController
public class FacturaController {

    @Autowired
    private FacturaService service;

    @GetMapping("/findAllBills")
    public ResponseEntity<List<Factura>> findAll(){
        return ResponseEntity.ok(service.findAll());
    }

    @GetMapping("/findById/{id}")
    public ResponseEntity<?> detail(@PathVariable Long id){
        Optional<Factura> facturaOptional = service.findById(id);
        if (facturaOptional.isPresent()){
            return ResponseEntity.ok(facturaOptional.get());
        }
        return  ResponseEntity.notFound().build();
    }

    @PostMapping("/createBill")
    public ResponseEntity<?> create(@Valid @RequestBody Factura factura, BindingResult result){
        if (result.hasErrors()){
            return  validate(result);
        }
        Factura facturaDB = service.save(factura);
        return  ResponseEntity.status(HttpStatus.CREATED).body(facturaDB);
    }

    @PutMapping("/updateBill/{id}")
    public ResponseEntity<?>update(@Valid @PathVariable Long id, BindingResult result, @RequestBody Factura factura){
        if (result.hasErrors()){
            return  validate(result);
        }
        Optional<Factura> f = service.findById(id);
        if (f.isPresent()){
            Factura facturaDb = f.get();

            facturaDb.setFechaEmision(factura.getFechaEmision());
            facturaDb.setUpdatedAt(LocalDateTime.now());
            facturaDb.setUsuarioId(factura.getUsuarioId());
            facturaDb.setPayment_methods(facturaDb.getPayment_methods());
            facturaDb.setProductosIds(facturaDb.getProductosIds());
            facturaDb.setTotal(factura.getTotal());
            facturaDb.setAddress(factura.getAddress());
            return  ResponseEntity.status(HttpStatus.CREATED).body(service.save(facturaDb));
        }
        return ResponseEntity.notFound().build();

    }

    @DeleteMapping("/DeleteBillById/{id}")
    public ResponseEntity<?> delete(@PathVariable Long id){
        Optional<Factura> f = service.findById(id);
        if (f.isPresent()){
            service.delete(id);
            return  ResponseEntity.noContent().build();
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
