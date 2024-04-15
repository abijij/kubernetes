package org.abijij.springcloud.msvc.factura.msvcfactura.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.abijij.springcloud.msvc.factura.msvcfactura.models.Producto;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;

@Entity
@Table(name = "facturas")
public class Factura {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotNull
    @Column( nullable = false)
    private LocalDateTime fechaEmision;

    @NotNull
    @Column
    private LocalDateTime updatedAt;

    @NotNull
    @Column(nullable = false)
    private Long usuarioId;

    @NotEmpty
    @Column( nullable = false)
    private String payment_methods;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    @JoinColumn(name = "productos_id")
    private List<FacturaProducto> facturaProductos;

    @Transient
    private List<Producto> productos;

    @NotEmpty
    @Column( nullable = false)
    private String total;

    @NotEmpty
    @Column( nullable = false)
    private String address;


    public Factura() {
        facturaProductos = new ArrayList<>();
        productos = new ArrayList<>();
    }

    public List<FacturaProducto> getFacturaProductos() {
        return facturaProductos;
    }

    public void setFacturaProductos(List<FacturaProducto> facturaProductos) {
        this.facturaProductos = facturaProductos;
    }

    public void addFacturaProducto(FacturaProducto facturaUsuarioProducto){
        facturaProductos.add(facturaUsuarioProducto);
    }

    public void removeFacturaProducto(FacturaProducto facturaUsuarioProducto){
        facturaProductos.remove(facturaUsuarioProducto);
    }

    public List<Producto> getProductos() {
        return productos;
    }

    public void setProductos(List<Producto> productos) {
        this.productos = productos;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public LocalDateTime getFechaEmision() {
        return fechaEmision;
    }

    public void setFechaEmision(LocalDateTime fechaEmision) {
        this.fechaEmision = fechaEmision;
    }

    public LocalDateTime getUpdatedAt() {
        return updatedAt;
    }

    public void setUpdatedAt(LocalDateTime updatedAt) {
        this.updatedAt = updatedAt;
    }

    public Long getUsuarioId() {
        return usuarioId;
    }

    public void setUsuarioId(Long usuarioId) {
        this.usuarioId = usuarioId;
    }

    public String getPayment_methods() {
        return payment_methods;
    }

    public void setPayment_methods(String payment_methods) {
        this.payment_methods = payment_methods;
    }

    public String getTotal() {
        return total;
    }

    public void setTotal(String total) {
        this.total = total;
    }

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }
}
