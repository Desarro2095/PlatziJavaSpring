package com.platzi.market.persistence.entity;

import jakarta.persistence.Column;
import jakarta.persistence.Embeddable;

import java.io.Serializable;

@Embeddable
public class EntityProductSalePK implements Serializable {

    @Column(name="id_compra")
    private Integer SaleId;

    @Column(name="id_producto")
    private Integer ProductId;

    public Integer getSaleId() {
        return SaleId;
    }

    public void setSaleId(Integer saleId) {
        SaleId = saleId;
    }

    public Integer getProductId() {
        return ProductId;
    }

    public void setProductId(Integer productId) {
        ProductId = productId;
    }
}
