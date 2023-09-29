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
    private Integer saleId;

    @Column(name="id_cliente")
    private String clientId;

    @Column(name="fecha")
    private LocalDateTime date;

    @Column(name="medio_pago")
    private Character payForm;

    @Column(name="comentario")
    private String comment;

    @Column(name="estado")
    private Character state;

    @ManyToOne
    @JoinColumn(name="id_cliente", insertable = false, updatable = false)
    private EntityClient client;

    @OneToMany(mappedBy = "sale", cascade = {CascadeType.ALL})
    private List<EntityProductSale> productSales;

    public Integer getSaleId() {
        return saleId;
    }

    public void setSaleId(Integer saleId) {
        this.saleId = saleId;
    }

    public String getClientId() {
        return clientId;
    }

    public void setClientId(String clientId) {
        this.clientId = clientId;
    }

    public LocalDateTime getDate() {
        return date;
    }

    public void setDate(LocalDateTime date) {
        this.date = date;
    }

    public Character getPayForm() {
        return payForm;
    }

    public void setPayForm(Character payForm) {
        this.payForm = payForm;
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comment) {
        this.comment = comment;
    }

    public Character getState() {
        return state;
    }

    public void setState(Character state) {
        this.state = state;
    }
    public EntityClient getClient() { return client; }

    public void setClient(EntityClient client) { this.client = client; }

    public List<EntityProductSale> getProductSales() { return productSales; }

    public void setProductSales(List<EntityProductSale> productSales) { this.productSales = productSales; }
}
