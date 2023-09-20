package com.platzi.market.persistence.mapper;

import com.platzi.market.persistence.entity.Category;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;

@Mapper(componentModel = "spring")
public interface ICategoryMapper {

    @Mappings({
            @Mapping(source = "CategoryId", target = "categoryId"),
            @Mapping(source = "Description", target = "category"),
            @Mapping(source = "State", target = "active")
    })
    com.platzi.market.domain.Category toCategoryDomain(Category category);

    @InheritInverseConfiguration
    @Mapping(target = "productos", ignore = true)
    Category toCategoryEntity(com.platzi.market.domain.Category category);

}
