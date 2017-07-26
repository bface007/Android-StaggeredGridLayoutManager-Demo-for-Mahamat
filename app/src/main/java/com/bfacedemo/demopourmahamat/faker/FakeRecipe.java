package com.bfacedemo.demopourmahamat.faker;

import com.bfacedemo.demopourmahamat.R;
import com.bfacedemo.demopourmahamat.models.Recipe;
import com.github.javafaker.Faker;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bface007 on 26/07/2017.
 */

public class FakeRecipe {
  private static final int[] imageResIds = new int[]{
      R.drawable.i100,
      R.drawable.i101,
      R.drawable.i103,
      R.drawable.i104,
      R.drawable.i105,
      R.drawable.i106,
      R.drawable.i107,
      R.drawable.i108,
      R.drawable.i109,
      R.drawable.i110,
  };

  public static List<Recipe> getRecipes() {
    Faker faker = new Faker();

    List<Recipe> recipes = new ArrayList<>();

    for(int i = 0; i < imageResIds.length; i++) {
      Recipe recipe = new Recipe();

      recipe.setName(faker.commerce().productName());
      recipe.setDescription(faker.lorem().paragraph());
      recipe.setCover(imageResIds[i]);
      recipe.setTime(i % 2 == 0 ? 15 * 60 * 1000 : i % 3 == 0 ? 45 * 60 * 1000 : 30 * 60 * 1000);

      recipes.add(recipe);
    }

    return recipes;
  }
}
