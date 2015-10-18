package com.smart.fridge.repos;

import com.smart.fridge.domain.MealAddition;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface MealAdditionRepository extends CrudRepository<MealAddition, Long> {
    List<MealAddition> findAllByMealId(long mealId);
}
