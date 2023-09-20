package com.platzi.market.web.controller;

import com.platzi.market.domain.DomainProduct;
import com.platzi.market.domain.service.ProductService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/products")
public class ProductController {
    @Autowired
    private ProductService productService;

    @GetMapping("/all")
    public ResponseEntity<List<DomainProduct>> getAll(){
        return new ResponseEntity<>(productService.getAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<DomainProduct> getProduct(@PathVariable("id") int productId){
        return productService.getProduct(productId)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @GetMapping("/category/{categoryId}")
    public ResponseEntity<List<DomainProduct>> getByCategory(@PathVariable("categoryId") int categoryId){
        return productService.getByCategory(categoryId)
                .map(x -> new ResponseEntity<>(x, HttpStatus.OK))
                .orElse(new ResponseEntity<>(HttpStatus.NOT_FOUND));
    }

    @PostMapping("/save")
    public ResponseEntity<DomainProduct> save(@RequestBody DomainProduct product){
        return new ResponseEntity<>(productService.save(product), HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}")
    public ResponseEntity delete(@PathVariable("id") int productId){
        return productService.delete(productId) ? new ResponseEntity(HttpStatus.OK) :
                                                  new ResponseEntity(HttpStatus.NOT_FOUND);
    }
}
