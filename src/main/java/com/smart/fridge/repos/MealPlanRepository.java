package com.smart.fridge.repos;

import com.smart.fridge.domain.Day;
import com.smart.fridge.domain.MealPlan;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

public interface MealPlanRepository extends CrudRepository<MealPlan, Long> {
    List<MealPlan> findByDay(Day day);
}
