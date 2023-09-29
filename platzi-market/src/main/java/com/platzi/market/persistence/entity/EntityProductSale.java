package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="compras_productos")
public class EntityProductSale {
    @EmbeddedId
    private EntityProductSalePK id;

    @Column(name="cantidad")
    private Integer quantity;

    @Column(name="total")
    private Double total;

    @Column(name="estado")
    private Boolean state;

    @ManyToOne
    @MapsId("saleId")
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private EntitySale sale;

    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false, updatable = false)
    private EntityProduct product;

    public EntityProductSalePK getId() {
        return id;
    }

    public void setId(EntityProductSalePK id) {
        this.id = id;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public Double getTotal() {
        return total;
    }

    public void setTotal(Double total) {
        this.total = total;
    }

    public Boolean getState() {
        return state;
    }

    public void setState(Boolean state) {
        this.state = state;
    }
    public EntitySale getSale() { return sale; }

    public void setSale(EntitySale sale) { this.sale = sale; }

    public EntityProduct getProduct() { return product; }

    public void setProduct(EntityProduct product) { this.product = product; }
}
