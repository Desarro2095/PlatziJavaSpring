package com.platzi.market.persistence.crud;

import com.platzi.market.persistence.entity.EntitySale;
import org.springframework.data.repository.CrudRepository;
import java.util.List;
import java.util.Optional;

public interface SaleCrudRepository extends CrudRepository<EntitySale, Integer> {
    Optional<List<EntitySale>> findByClientId(String clientId);
}
