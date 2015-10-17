package com.smart.fridge.services;

import com.google.common.collect.Lists;
import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.repos.IngredientRepository;
import com.smart.fridge.repos.MealAdditionRepository;
import com.smart.fridge.repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;

@Service
public class MealService {

    @Autowired
    private MealRepository mealRepository;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MealAdditionRepository mealAdditionRepository;

    @Transactional
    public String createMeal() {
        Ingredient ingredient = new Ingredient("TestIngredient");
        ingredientRepository.save(ingredient);

        MealAddition mealAddition = new MealAddition(1, ingredient);
        mealAdditionRepository.save(mealAddition);

        List<MealAddition> mealAdditionList = new ArrayList<MealAddition>();
        mealAdditionList.add(mealAddition);
        Meal meal = new Meal("TestMeal", mealAdditionList);
        mealRepository.save(meal);
        return "Success!";
    }

    @Transactional
    public Meal findMealByName(String mealName) {
        return mealRepository.findMealByName(mealName);
    }

    @Transactional
    public List<Meal> findAllMeals() {
        List<Meal> mealList = Lists.newArrayList(mealRepository.findAll());
        return mealList;
    }

    public List<MealAddition> getMealAdditionsOfMeal(long mealID) {
        Meal meal = mealRepository.findOne(mealID);
        return meal.getMealAdditions();
    }
}
