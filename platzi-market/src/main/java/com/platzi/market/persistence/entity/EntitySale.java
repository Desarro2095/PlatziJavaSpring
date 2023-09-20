package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "compras")
public class EntitySale {
    @Id
    @Column(name = "id_compra")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Integer SaleId;

    @Column(name="id_cliente")
    private Integer ClientId;

    @Column(name="fecha")
    private LocalDateTime Date;

    @Column(name="medio_pago")
    private Character PayForm;

    @Column(name="comentario")
    private String Comment;

    @Column(name="estado")
    private Character State;

    @ManyToOne
    @JoinColumn(name="id_cliente", insertable = false, updatable = false)
    private EntityClient Client;

    @OneToMany(mappedBy = "Sale")
    private List<EntityProductSale> ProductSales;

    public Integer getSaleId() {
        return SaleId;
    }

    public void setSaleId(Integer saleId) {
        SaleId = saleId;
    }

    public Integer getClientId() {
        return ClientId;
    }

    public void setClientId(Integer clientId) {
        ClientId = clientId;
    }

    public LocalDateTime getDate() {
        return Date;
    }

    public void setDate(LocalDateTime date) {
        Date = date;
    }

    public Character getPayForm() {
        return PayForm;
    }

    public void setPayForm(Character payForm) {
        PayForm = payForm;
    }

    public String getComment() {
        return Comment;
    }

    public void setComment(String comment) {
        Comment = comment;
    }

    public Character getState() {
        return State;
    }

    public void setState(Character state) {
        State = state;
    }
}
