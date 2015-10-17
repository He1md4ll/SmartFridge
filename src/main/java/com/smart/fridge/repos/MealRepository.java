package com.smart.fridge.repos;


import com.smart.fridge.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    Meal findByName(String name);

    List<Meal> findByNameContaining(String name);
}
