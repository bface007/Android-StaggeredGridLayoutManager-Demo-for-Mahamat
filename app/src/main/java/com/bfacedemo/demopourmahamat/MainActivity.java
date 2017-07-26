package com.bfacedemo.demopourmahamat;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.StaggeredGridLayoutManager;
import android.widget.Toast;
import com.bfacedemo.demopourmahamat.faker.FakeRecipe;
import com.bfacedemo.demopourmahamat.models.Recipe;
import java.util.List;

public class MainActivity extends AppCompatActivity
    implements RecipesAdapter.RecipesEventsListener {
  private RecyclerView mRecyclerView;
  private RecipesAdapter mAdapter;
  private List<Recipe> mRecipes;

  @Override protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    mRecipes = FakeRecipe.getRecipes();

    mRecyclerView = findViewById(R.id.list);

    mAdapter = new RecipesAdapter(this, this);
    StaggeredGridLayoutManager layoutManager = new StaggeredGridLayoutManager(2, StaggeredGridLayoutManager.VERTICAL);

    mRecyclerView.setLayoutManager(layoutManager);
    mRecyclerView.setAdapter(mAdapter);
  }

  @Override protected void onResume() {
    super.onResume();
    mAdapter.swapItems(this.mRecipes);
  }

  @Override public void onRecipeClick(Recipe recipe, int position) {
    Toast.makeText(this, recipe.getName(), Toast.LENGTH_SHORT).show();
  }
}
