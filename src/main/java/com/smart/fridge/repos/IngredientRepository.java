package com.smart.fridge.repos;

import com.smart.fridge.domain.Ingredient;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IngredientRepository extends CrudRepository<Ingredient, Long> {
    public Ingredient findByName(String name);
}
