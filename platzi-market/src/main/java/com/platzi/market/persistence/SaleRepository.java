package com.platzi.market.persistence;

import com.platzi.market.domain.DomainPurchase;
import com.platzi.market.domain.repository.PurchaseRepository;
import com.platzi.market.persistence.crud.SaleCrudRepository;
import com.platzi.market.persistence.entity.EntitySale;
import com.platzi.market.persistence.mapper.PurchaseMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class SaleRepository implements PurchaseRepository {

    @Autowired
    private SaleCrudRepository saleCrudRepository;
    @Autowired
    private PurchaseMapper mapper;

    @Override
    public List<DomainPurchase> getAll() {
        return  mapper.toPurchases((List<EntitySale>) saleCrudRepository.findAll());
    }

    @Override
    public Optional<List<DomainPurchase>> getByClient(String clientId) {
        return saleCrudRepository.findByClientId(clientId)
               .map(sales -> mapper.toPurchases(sales));
    }

    @Override
    public DomainPurchase save(DomainPurchase purchase) {
        EntitySale sale = mapper.toSale(purchase);
        sale.getProductSales().forEach(product -> product.setSale(sale));
        return mapper.toPurchase(saleCrudRepository.save(sale));
    }
}
