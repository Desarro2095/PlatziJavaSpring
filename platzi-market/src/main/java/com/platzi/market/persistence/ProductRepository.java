package com.platzi.market.persistence;

import com.platzi.market.domain.DomainProduct;
import com.platzi.market.persistence.entity.EntityProduct;
import com.platzi.market.persistence.mapper.ProductMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ProductRepository implements com.platzi.market.domain.repository.ProductRepository {

    @Autowired
    private com.platzi.market.persistence.crud.ProductCrudRepository productCrudRepository;

    @Autowired
    private ProductMapper mapper;

    @Override
    public List<DomainProduct> getAll(){
        List<EntityProduct> products = (List<EntityProduct>) productCrudRepository.findAll();
        return mapper.toProductsDomain(products);
    }
    @Override
    public Optional<List<DomainProduct>> getByCategory(int CategoryId){
        List<EntityProduct> products = (List<EntityProduct>) productCrudRepository.findByCategoryIdOrderByNameAsc(CategoryId);
        return Optional.of(mapper.toProductsDomain(products));
    }

    @Override
    public Optional<List<DomainProduct>> getScarseProducts(int quantity) {
        Optional<List<EntityProduct>> products = productCrudRepository.findByQuantityStockLessThanAndState(quantity, true);
        return products.map(x -> mapper.toProductsDomain(x));
    }

    @Override
    public Optional<DomainProduct> getProduct(int ProductId){
        Optional<EntityProduct> product = productCrudRepository.findById(ProductId);
        return product.map(x -> mapper.toProductDomain(x));
    }

    @Override
    public DomainProduct save(DomainProduct product) {
        EntityProduct entityProduct = mapper.toProductEntity(product);
        return mapper.toProductDomain(productCrudRepository.save(entityProduct));
    }

    @Override
    public void delete(int ProductId){
        productCrudRepository.deleteById(ProductId);
    }
}
