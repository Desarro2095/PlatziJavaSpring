package com.platzi.market.persistence.entity;

import jakarta.persistence.*;

@Entity
@Table(name="compras_productos")
public class EntityProductSale {
    @EmbeddedId
    private EntityProductSalePK Id;

    @Column(name="cantidad")
    private Integer Quantity;

    @Column(name="total")
    private Double Total;

    @Column(name="estado")
    private Boolean State;

    @ManyToOne
    @JoinColumn(name = "id_compra", insertable = false, updatable = false)
    private EntitySale Sale;

    @ManyToOne
    @JoinColumn(name="id_producto", insertable = false, updatable = false)
    private EntityProduct Product;

    public EntityProductSalePK getId() {
        return Id;
    }

    public void setId(EntityProductSalePK id) {
        Id = id;
    }

    public Integer getQuantity() {
        return Quantity;
    }

    public void setQuantity(Integer quantity) {
        Quantity = quantity;
    }

    public Double getTotal() {
        return Total;
    }

    public void setTotal(Double total) {
        Total = total;
    }

    public Boolean getState() {
        return State;
    }

    public void setState(Boolean state) {
        State = state;
    }
}
