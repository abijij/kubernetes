package org.abijij.spring.msvc.users.msvc_users.models.entity;

import jakarta.persistence.*;

import java.io.Serializable;
import java.util.Objects;

@Entity
@Table
public class Addresses implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true)
    private String id;

    private String name;

    private String street;

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Addresses addresses = (Addresses) o;
        return Objects.equals(id, addresses.id) && Objects.equals(name, addresses.name) && Objects.equals(street, addresses.street) && Objects.equals(countryCode, addresses.countryCode) && Objects.equals(idUser, addresses.idUser);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, street, countryCode, idUser);
    }


    @Override
    public String toString() {
        return "Addresses{" +
                "id='" + id + '\'' +
                ", name='" + name + '\'' +
                ", street='" + street + '\'' +
                ", countryCode='" + countryCode + '\'' +
                ", idUser='" + idUser + '\'' +
                '}';
    }

    private String countryCode;

    private String idUser;

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getCountryCode() {
        return countryCode;
    }

    public void setCountryCode(String countryCode) {
        this.countryCode = countryCode;
    }

    public String getIdUser() {
        return idUser;
    }

    public void setIdUser(String idUser) {
        this.idUser = idUser;
    }
}
