package org.abijij.springcloud.msvc.usuarios.models.entity;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;

@Entity
@Table(name = "usurarios")
public class Usuario {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @NotEmpty(message = "El campo 'nombre' no puede ir vacio")
    private String nombre;

    @NotEmpty(message = "El campo 'apellido' no puede ir vacio")
    private String apellido;

    @NotEmpty(message = "El campo 'email' no puede ir vacio")
    @Email
    @Column(unique = true)
    private String email;

    @NotNull(message = "El campo 'telefono' no puede ir vacio")
    @Column(unique = true)
    private Long telefono;

    @NotEmpty(message = "El campo 'password' no puede ir vacio")
    private String password;


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

    public String getApellido() {
        return apellido;
    }

    public void setApellido(String apellido) {
        this.apellido = apellido;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Long getTelefono() {
        return telefono;
    }

    public void setTelefono(Long telefono) {
        this.telefono = telefono;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
