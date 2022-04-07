package models.recipeList;

import models.IngredientUnit;

public class Ingredient {
    protected String item;
    protected int amount;
    protected IngredientUnit unit;
    public Ingredient(){

    }
    public Ingredient(String item, int amount, IngredientUnit unit){
        this.item = item;
        this.amount = amount;
        this.unit = unit;
    }
    public String getItem(){
        return item;
    }
    public void setItem(String item){
        this.item = item;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int amount){
        this.amount = amount;
    }
    public IngredientUnit getUnit(){
        return unit;
    }
    public void setUnit(IngredientUnit unit){
        this.unit = unit;
    }

}
