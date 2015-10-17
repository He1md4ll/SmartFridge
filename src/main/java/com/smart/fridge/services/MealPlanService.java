package com.smart.fridge.services;

import com.smart.fridge.domain.Day;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealPlan;
import com.smart.fridge.domain.MealTime;
import com.smart.fridge.repos.MealPlanRepository;
import com.smart.fridge.repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.List;

@Service
public class MealPlanService {

    @Autowired
    private MealPlanRepository mealPlanRepository;

    @Autowired
    private MealRepository mealRepository;

    @Transactional
    public List<MealPlan> getMealsOfDay(Day day) {
        return mealPlanRepository.findByDay(day);
    }

    @Transactional
    public MealPlan createMealPlan(long mealID, MealTime mealTime, Day day) {
        Meal meal = mealRepository.findOne(mealID);
        MealPlan mealPlan = new MealPlan(meal, mealTime, day);
        return mealPlanRepository.save(mealPlan);
    }

    @Transactional
    public boolean removeMealPlan(long mealPlanID) {
        mealPlanRepository.delete(mealPlanID);
        return (mealPlanRepository.findOne(mealPlanID) == null);
    }
}
