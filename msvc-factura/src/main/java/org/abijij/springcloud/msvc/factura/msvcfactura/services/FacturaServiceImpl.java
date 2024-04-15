package org.abijij.springcloud.msvc.factura.msvcfactura.services;

import org.abijij.springcloud.msvc.factura.msvcfactura.models.Producto;
import org.abijij.springcloud.msvc.factura.msvcfactura.models.entity.Factura;
import org.abijij.springcloud.msvc.factura.msvcfactura.repositories.FacturaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.Optional;

@Service
public class FacturaServiceImpl implements  FacturaService{

    @Autowired
    private FacturaRepository repository;

    @Override
    @Transactional(readOnly = true)
    public List<Factura> findAll() {
       return (List<Factura>) repository.findAll();
    }

    @Override
    @Transactional(readOnly = true)
    public Optional<Factura> findById(Long id) {
        return repository.findById(id);
    }

    @Override
    @Transactional
    public Factura save(Factura producto) {
        return repository.save(producto);
    }

    @Override
    @Transactional
    public void delete(Long id) {
            repository.deleteById(id);
    }

    @Override
    public Optional<Producto> asignarProducto(Producto producto, Long productoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> crearProducto(Producto producto, Long productoId) {
        return Optional.empty();
    }

    @Override
    public Optional<Producto> eliminarProducto(Producto producto, Long productoId) {
        return Optional.empty();
    }
}
