package org.abijij.springcloud.msvc.productos.repositories;

import org.abijij.springcloud.msvc.productos.entity.Producto;
import org.springframework.data.repository.CrudRepository;

public interface ProductoRepository extends CrudRepository<Producto, Long > {

}
