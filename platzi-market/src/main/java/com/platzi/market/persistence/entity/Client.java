package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.util.List;

@Entity
@Table(name="clientes")
public class Client {

    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    private Integer ClientId;

    @Column(name="nombre")
    private String FirstName;

    @Column(name="apellidos")
    private String LastName;

    @Column(name="celular")
    private Integer CellPhone;

    @Column(name="direccion")
    private String Address;

    @Column(name="correo_electronico")
    private String Email;

    @OneToMany(mappedBy="Client")
    private List<Sale> Sales;

    public Integer getClientId() {
        return ClientId;
    }

    public void setClientId(Integer clientId) {
        ClientId = clientId;
    }

    public String getFirstName() {
        return FirstName;
    }

    public void setFirstName(String firstName) {
        FirstName = firstName;
    }

    public String getLastName() {
        return LastName;
    }

    public void setLastName(String lastName) {
        LastName = lastName;
    }

    public Integer getCellPhone() {
        return CellPhone;
    }

    public void setCellPhone(Integer cellPhone) {
        CellPhone = cellPhone;
    }

    public String getAddress() {
        return Address;
    }

    public void setAddress(String address) {
        Address = address;
    }

    public String getEmail() {
        return Email;
    }

    public void setEmail(String email) {
        Email = email;
    }
}
