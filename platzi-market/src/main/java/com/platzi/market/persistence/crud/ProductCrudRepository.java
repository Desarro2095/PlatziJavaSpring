package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.EntityProduct;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface ProductCrudRepository extends CrudRepository<EntityProduct, Integer> {

    List<EntityProduct> findByCategoryIdOrderByNameAsc(int CategotyId);

    Optional<List<EntityProduct>> findByQuantityStockLessThanAndState(int quantityStock, Boolean state);
}
