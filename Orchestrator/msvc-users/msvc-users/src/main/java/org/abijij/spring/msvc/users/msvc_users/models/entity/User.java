package org.abijij.spring.msvc.users.msvc_users.models.entity;


import jakarta.persistence.*;

import java.io.Serializable;
import java.security.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name="users")
public class User implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(unique = true)
    private String email;

    private String name;

    @Column(unique = true)
    private String phone;

    private String password;

    @Column(unique = true)
    private String tax_id;

    private Timestamp created_at;

    private List<Addresses> addresses;

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", email='" + email + '\'' +
                ", name='" + name + '\'' +
                ", phone='" + phone + '\'' +
                ", password='" + password + '\'' +
                ", tax_id='" + tax_id + '\'' +
                ", created_at=" + created_at +
                ", addresses=" + addresses +
                '}';
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        User user = (User) o;
        return Objects.equals(id, user.id) && Objects.equals(email, user.email) && Objects.equals(name, user.name) && Objects.equals(phone, user.phone) && Objects.equals(password, user.password) && Objects.equals(tax_id, user.tax_id) && Objects.equals(created_at, user.created_at) && Objects.equals(addresses, user.addresses);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, email, name, phone, password, tax_id, created_at, addresses);
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTax_id() {
        return tax_id;
    }

    public void setTax_id(String tax_id) {
        this.tax_id = tax_id;
    }

    public Timestamp getCreated_at() {
        return created_at;
    }

    public void setCreated_at(Timestamp created_at) {
        this.created_at = created_at;
    }

    public List<Addresses> getAddresses() {
        return addresses;
    }

    public void setAddresses(List<Addresses> addresses) {
        this.addresses = addresses;
    }
}
