package com.platzi.market.persistence.mapper;

import com.platzi.market.persistence.entity.Product;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

import java.util.List;

@Mapper(componentModel = "spring", uses = {ICategoryMapper.class})
public interface IProductMapper {

    @Mappings({
            @Mapping(source = "ProductId", target = "productId"),
            @Mapping(source = "Name", target = "name"),
            @Mapping(source = "CategotyId", target = "categoryId"),
            @Mapping(source = "SalePrice", target = "price"),
            @Mapping(source = "QuantityStock", target = "stock"),
            @Mapping(source = "State", target = "active"),
            @Mapping(source = "Category", target = "category"),
    })
    com.platzi.market.domain.Product toProductDomain(Product product);
    List<com.platzi.market.domain.Product> toProductsDomain(List<Product> products);

    @InheritInverseConfiguration
    @Mapping(target = "CodeBar", ignore = true)
    Product toProductEntity(com.platzi.market.domain.Product product);
}
