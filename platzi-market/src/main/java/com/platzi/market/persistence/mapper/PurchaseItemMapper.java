package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DomainPurchaseItem;
import com.platzi.market.persistence.entity.EntityProductSale;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mappings;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring", uses = {ProductMapper.class})
public interface PurchaseItemMapper {
    @Mappings({
        @Mapping(source = "id.productId", target = "productId"),
        @Mapping(source = "quantity", target = "quantity"),
        @Mapping(source = "total", target = "total"),
        @Mapping(source = "state", target = "active")
    })
    DomainPurchaseItem toPurchaseItem(EntityProductSale productSale);

    @InheritInverseConfiguration
    @Mappings({
            @Mapping(target = "sale", ignore = true),
            @Mapping(target = "product", ignore = true),
            @Mapping(target = "id.saleId", ignore = true)
    })
    EntityProductSale toEntityProductSale(DomainPurchaseItem purchaseItem);
}
