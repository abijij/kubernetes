package org.abijij.springcloud.msvc.factura.msvcfactura.services;

import org.abijij.springcloud.msvc.factura.msvcfactura.models.Producto;
import org.abijij.springcloud.msvc.factura.msvcfactura.models.entity.Factura;

import java.util.List;
import java.util.Optional;

public interface FacturaService {
    List<Factura> findAll();
    Optional<Factura> findById(Long id);
    Factura save(Factura producto);
    void delete(Long id);

    Optional<Producto> asignarProducto(Producto producto, Long productoId );
    Optional<Producto> crearProducto(Producto producto, Long productoId);
    Optional<Producto> eliminarProducto(Producto producto, Long productoId);
}
