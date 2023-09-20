package com.platzi.market.domain.service;

import com.platzi.market.domain.DomainProduct;
import com.platzi.market.persistence.ProductRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ProductService {
    @Autowired
    private ProductRepository productRepository;

    public List<DomainProduct> getAll(){
       return productRepository.getAll();
    }

    public Optional<DomainProduct> getProduct(int productId){
        return productRepository.getProduct(productId);
    }

    public Optional<List<DomainProduct>> getByCategory(int categoryId){
        return productRepository.getByCategory(categoryId);
    }

    public DomainProduct save(DomainProduct product){
        return productRepository.save(product);
    }

    public boolean delete(int productId){
        return getProduct(productId).map(x -> {
            productRepository.delete(productId);
            return true;
        }).orElse(false);
    }
}
