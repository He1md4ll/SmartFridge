package com.smart.fridge.repos;


import com.smart.fridge.domain.Meal;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface MealRepository extends CrudRepository<Meal, Long> {
    public Meal findMealByName(String name);
}
