package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.Product;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;

import java.util.List;
import java.util.Optional;

public interface IProductCrudRepository extends CrudRepository<Product, Integer> {

    List<Product> findByCategoryIdOrderByNameAsc(int CategotyId);

    Optional<List<Product>> findByQuantityStockLessThanAndState(int QuantityStock, Boolean State);
}
