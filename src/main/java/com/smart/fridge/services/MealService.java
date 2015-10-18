package com.smart.fridge.services;

import com.google.common.collect.Lists;
import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.domain.MealPerformance;
import com.smart.fridge.domain.enums.Unit;
import com.smart.fridge.repos.IngredientRepository;
import com.smart.fridge.repos.MealAdditionRepository;
import com.smart.fridge.repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

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
        Ingredient ingredient = new Ingredient("TestIngredient", Unit.KG, "http://www.boettgergruppe.com/fileadmin/boettgergruppe/img/zucker.jpg");
        ingredientRepository.save(ingredient);

        MealAddition mealAddition = new MealAddition(1, ingredient);
        mealAdditionRepository.save(mealAddition);

        List<MealAddition> mealAdditionList = new ArrayList<>();
        mealAdditionList.add(mealAddition);
        Meal meal = new Meal("TestMeal", mealAdditionList, "http://3yis471nsv3u3cfv9924fumi.wpengine.netdna-cdn.com/wp-content/uploads/2013/11/Half-a-BBQ-Chicken-Meal-Deal.jpg");
        mealRepository.save(meal);
        return "Success!";
    }

    @Transactional
    public Meal getMealByName(String mealName) {
        return mealRepository.findByName(mealName);
    }

    @Transactional
    public List<Meal> getMealByNameLike(String mealName) {
        return mealRepository.findByNameContaining(mealName);
    }

    /**
     * Finds all meals in database
     *
     * @return all meals without MealAddition to improve performance
     */
    @Transactional
    public List<MealPerformance> getMeals() {
        List<Meal> mealList = Lists.newArrayList(mealRepository.findAll());
        List<MealPerformance> mealPerformanceList = new ArrayList<>();
        // Remove mapping to MealAddition to improve performance for transfer to client
        mealPerformanceList.addAll(mealList.stream().map(MealPerformance::fromMeal).collect(Collectors.toList()));
        return mealPerformanceList;
    }

    /**
     * Finds all MealAdditions for one MealID
     *
     * @param mealID ID of Meal
     * @return List of MealAdditions
     */
    @Transactional
    public List<MealAddition> getMealAdditionsOfMeal(long mealID) {
        Meal meal = mealRepository.findOne(mealID);
        return meal.getMealAdditions();
    }
}
