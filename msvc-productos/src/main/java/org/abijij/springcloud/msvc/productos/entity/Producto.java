package org.abijij.springcloud.msvc.productos.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "productos")
public class Producto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo 'nombre' no puede ir vacio")
    @Column(unique = true)
    private String nombre;

    @NotEmpty(message = "El campo 'descripcion' no puede ir vacio")
    private String descripcion;

    @NotEmpty(message = "El campo 'departamento' no puede ir vacio")
    private String departamento;

    @NotNull(message = "El campo 'stock' no puede ir vacio")
    private Integer stock;

    @NotNull(message = "El campo 'price' no puede ir vacio")
    private Integer price;



    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getDepartamento() {
        return departamento;
    }

    public void setDepartamento(String departamento) {
        this.departamento = departamento;
    }

    public Integer getStock() {
        return stock;
    }

    public void setStock(Integer stock) {
        this.stock = stock;
    }

    public Integer getPrice() {
        return price;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }
}
