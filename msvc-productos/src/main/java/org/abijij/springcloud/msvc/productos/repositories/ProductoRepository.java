package org.abijij.springcloud.msvc.productos.repositories;

import org.abijij.springcloud.msvc.productos.entity.Producto;
import org.springframework.data.repository.CrudRepository;

import java.util.Optional;

public interface ProductoRepository extends CrudRepository<Producto, Long > {

    Optional<Producto>findByNombre(String nombre);



}
