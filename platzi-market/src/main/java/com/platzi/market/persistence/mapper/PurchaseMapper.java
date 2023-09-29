package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DomainPurchase;
import com.platzi.market.persistence.entity.EntitySale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {PurchaseItemMapper.class})
public interface PurchaseMapper {

    @Mappings({
            @Mapping(source = "saleId", target = "purchaseId"),
            @Mapping(source = "clientId", target = "clientId"),
            @Mapping(source = "date", target = "date"),
            @Mapping(source = "payForm", target = "paymentMethod"),
            @Mapping(source = "comment", target = "comment"),
            @Mapping(source = "state", target = "state"),
            @Mapping(source = "productSales", target = "item"),
    })
    DomainPurchase toPurchase(EntitySale sale);
    List<DomainPurchase> toPurchases(List<EntitySale> sales);

    @InheritInverseConfiguration
    @Mapping(target = "client", ignore = true)
    EntitySale toSale(DomainPurchase purchase);
}
