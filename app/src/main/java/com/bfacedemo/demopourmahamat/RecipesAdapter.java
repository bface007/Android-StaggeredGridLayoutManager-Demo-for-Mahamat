package com.bfacedemo.demopourmahamat;

import android.content.Context;
import android.support.v7.widget.CardView;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import com.bfacedemo.demopourmahamat.models.Recipe;
import com.bfacedemo.demopourmahamat.utils.TimeUtils;
import com.bumptech.glide.Glide;
import com.bumptech.glide.load.engine.DiskCacheStrategy;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by bface007 on 26/07/2017.
 */

public class RecipesAdapter extends RecyclerView.Adapter<RecipesAdapter.RecipesViewHolder> {
  private List<Recipe> mRecipes;
  private Context mContext;
  private RecipesEventsListener mListener;

  public RecipesAdapter(Context context) {
    this.mContext = context;
    this.mRecipes = new ArrayList<>();
  }

  public RecipesAdapter(Context context, RecipesEventsListener listener) {
    this.mContext = context;
    this.mListener = listener;
    this.mRecipes = new ArrayList<>();
  }

  public void swapItems(List<Recipe> recipes) {
    if(recipes != null && recipes.size() > 0) {
      mRecipes.clear();
      mRecipes.addAll(recipes);
      notifyDataSetChanged();
    }
  }

  @Override public RecipesViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
    return new RecipesViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.recipe_item, parent, false));
  }

  @Override public void onBindViewHolder(final RecipesViewHolder holder, int position) {
    final Recipe recipe = this.mRecipes.get(position);

    holder.recipeName.setText(recipe.getName());
    holder.recipeCover.setImageResource(recipe.getCover());
    holder.recipeDescription.setText(recipe.getDescription());
    holder.recipeTime.setText(TimeUtils.getFormattedTime(recipe.getTime()));

    Glide.with(this.mContext)
        .load(recipe.getCover())
        .centerCrop()
        .diskCacheStrategy(DiskCacheStrategy.ALL)
        .into(holder.recipeCover);

    if(mListener != null) {
      holder.recipe.setOnClickListener(new View.OnClickListener() {
        @Override public void onClick(View view) {
          mListener.onRecipeClick(recipe, holder.getAdapterPosition());
        }
      });
    }
  }

  @Override public int getItemCount() {
    return this.mRecipes.size();
  }

  class RecipesViewHolder extends RecyclerView.ViewHolder {
    TextView recipeName;
    TextView recipeDescription;
    TextView recipeTime;
    ImageView recipeCover;
    CardView recipe;

    public RecipesViewHolder(View itemView) {
      super(itemView);

      recipe = (CardView) itemView;
      recipeName = recipe.findViewById(R.id.recipe_name);
      recipeDescription = recipe.findViewById(R.id.recipe_description);
      recipeTime = recipe.findViewById(R.id.recipe_time);
      recipeCover = recipe.findViewById(R.id.recipe_cover);
    }
  }

  interface RecipesEventsListener {
    public void onRecipeClick(Recipe recipe, int position);
  }
}
