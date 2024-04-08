package org.abijij.springcloud.msvc.productos.services;

import org.abijij.springcloud.msvc.productos.entity.Producto;

import java.util.List;
import java.util.Optional;

public interface ProductoService  {



    List<Producto> findAll();

    Optional<Producto>findById(Long id);

    Producto save(Producto producto);

    void delete(Long id);
}
