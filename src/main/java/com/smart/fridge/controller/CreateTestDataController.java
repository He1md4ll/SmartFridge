package com.smart.fridge.controller;

import com.smart.fridge.domain.Ingredient;
import com.smart.fridge.domain.Meal;
import com.smart.fridge.domain.MealAddition;
import com.smart.fridge.domain.enums.Unit;
import com.smart.fridge.repos.IngredientRepository;
import com.smart.fridge.repos.MealAdditionRepository;
import com.smart.fridge.repos.MealRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.transaction.Transactional;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import java.util.ArrayList;
import java.util.List;

@Path("/rest")
@Component
public class CreateTestDataController {

    private List<Ingredient> ingredients;

    @Autowired
    private IngredientRepository ingredientRepository;

    @Autowired
    private MealAdditionRepository mealAdditionRepository;

    @Autowired
    private MealRepository mealRepository;

    @GET
    @Path("/createTestData")
    @Produces("application/json")
    @Transactional
    public String createMeals() {
        createIngredients();
        Meal meal = new Meal("Pancakes", "https://marialivingandlearning.files.wordpress.com/2014/12/american-pancakes.jpg");
        mealRepository.save(meal);
        Ingredient ingredient = ingredients.get(0);
        mealAdditionRepository.save(new MealAddition(80, ingredient, meal));
        mealAdditionRepository.save(new MealAddition(500, ingredients.get(1), meal));
        mealAdditionRepository.save(new MealAddition(130, ingredients.get(2), meal));
        mealAdditionRepository.save(new MealAddition(5, ingredients.get(3), meal));
        mealAdditionRepository.save(new MealAddition(5, ingredients.get(4), meal));

        meal = new Meal("Rice Broccoli Chicken Meal", "http://www.campbellskitchen.com/recipeimages/15-minute-chicken-rice-dinner-large-32.jpg");
        mealRepository.save(meal);
        mealAdditionRepository.save(new MealAddition(100, ingredients.get(5), meal));
        mealAdditionRepository.save(new MealAddition(300, ingredients.get(6), meal));
        mealAdditionRepository.save(new MealAddition(200, ingredients.get(7), meal));

        meal = new Meal("Honey bread", "https://36.media.tumblr.com/tumblr_me216nNugu1ru2lrco1_500.jpg");
        mealRepository.save(meal);
        mealAdditionRepository.save(new MealAddition(2, ingredients.get(8), meal));
        mealAdditionRepository.save(new MealAddition(300, ingredients.get(9), meal));

        meal = new Meal("Cheese bread", "http://www.kiamichi-poteau.tec.ok.us/users/t/tmccool/www/images/cheesebread.jpg");
        mealRepository.save(meal);
        mealAdditionRepository.save(new MealAddition(2, ingredients.get(8), meal));
        mealAdditionRepository.save(new MealAddition(2, ingredients.get(10), meal));

        meal = new Meal("Sweet Cake", "http://ohjoy.blogs.com/.a/6a00d8341c6a0853ef0133f44a9e64970b-pi");
        mealRepository.save(meal);
        mealAdditionRepository.save(new MealAddition(0, ingredients.get(1), meal));
        mealAdditionRepository.save(new MealAddition(40, ingredients.get(2), meal));
        mealAdditionRepository.save(new MealAddition(1, ingredients.get(10), meal));
        mealAdditionRepository.save(new MealAddition(400, ingredients.get(4), meal));
        mealAdditionRepository.save(new MealAddition(21, ingredients.get(5), meal));
        mealAdditionRepository.save(new MealAddition(1, ingredients.get(3), meal));

        meal = new Meal("Chicken chickens", "http://images.all-free-download.com/images/graphiclarge/chicken_picture_2_167118.jpg");
        mealRepository.save(meal);
        mealAdditionRepository.save(new MealAddition(2000, ingredients.get(7), meal));
        return "Success!";
    }

    private void createIngredients() {
        ingredients = new ArrayList<>();
        ingredients.add(ingredientRepository.save(new Ingredient("Sugar", Unit.G, "http://a.abcnews.com/images/Health/gty_sugar_jtm_130918_16x9_608.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Flour", Unit.G, "https://www.dovesfarm.co.uk/uploads/images/large/1632.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Milk", Unit.KG, "http://www.healthline.com/hlcmsresource/images/topic_centers/Food-Nutrition/642x361-2-Dairy_Milk-Almond_Milk_vs_Cow_Milk_vs_Soy_Milk_0.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Egg", Unit.PIECE, "http://www.anaphylaxis.org.uk/userfiles/images/allergens/eggs.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Vanilla Sugar", Unit.G, "http://media.mnn.com/assets/images/2012/12/vanilla%20sugar%20large.jpg.560x0_q80_crop-smart.jpg")));

        ingredients.add(ingredientRepository.save(new Ingredient("Rice", Unit.G, "http://hibloderoxremedy.net/wp-content/uploads/2014/05/Rice-Hibloderox-Remedy.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Broccoli", Unit.G, "http://healthimpactnews.com/wp-content/uploads/sites/2/2013/08/broccoli-2.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Chicken", Unit.G, "https://lh6.ggpht.com/vZB-ga094LB4e1kVv_LxZoqUoq9kcQ0W8sbj6f-8mK06tWHi5VBTyvWfL-zTyCHBD38=w300")));

        ingredients.add(ingredientRepository.save(new Ingredient("Bread", Unit.PIECE, "http://files.recipetips.com/kitchen/images/refimages/bread/types/Italian_bread_500.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Honey", Unit.G, "http://fairtradeusa.org/sites/default/files/imagecache/feature_image/products/photo_carousel/honey.jpg")));
        ingredients.add(ingredientRepository.save(new Ingredient("Cheese", Unit.PIECE, "http://www.natures-health-foods.com/images/cheese.jpg")));

    }
}
