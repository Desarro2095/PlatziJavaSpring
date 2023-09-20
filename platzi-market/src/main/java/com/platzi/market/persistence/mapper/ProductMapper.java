package com.platzi.market.persistence.mapper;

import com.platzi.market.domain.DomainProduct;
import com.platzi.market.persistence.entity.EntityProduct;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {CategoryMapper.class})
public interface ProductMapper {

    @Mappings({
            @Mapping(source = "productId", target = "productId"),
            @Mapping(source = "name", target = "name"),
            @Mapping(source = "categoryId", target = "categoryId"),
            @Mapping(source = "salePrice", target = "price"),
            @Mapping(source = "quantityStock", target = "stock"),
            @Mapping(source = "state", target = "active"),
            @Mapping(source = "category", target = "category"),
    })
    DomainProduct toProductDomain(EntityProduct product);
    List<DomainProduct> toProductsDomain(List<EntityProduct> products);

    @InheritInverseConfiguration
    @Mapping(target = "codeBar", ignore = true)
    EntityProduct toProductEntity(DomainProduct product);
}
