package models.recipeList;

import java.util.ArrayList;

public class Recipe {
    private String name;
    private ArrayList<Ingredient> ingredients;
    private boolean chosen;
    public Recipe(String name, ArrayList<Ingredient> ingredients){
        this.name = name;
        this.ingredients = ingredients;
        chosen = false;
    }
    public String getName(){
        return name;
    }
    public void setName(String name){
        this.name = name;
    }
    public ArrayList<Ingredient> getIngredients(){
        return ingredients;
    }
    public void setIngredients(ArrayList<Ingredient> ingredients){
        this.ingredients = ingredients;
    }
    public boolean getChosen(){
        return chosen;
    }
    public void setChosen(boolean value){
        chosen = value;
    }
}
