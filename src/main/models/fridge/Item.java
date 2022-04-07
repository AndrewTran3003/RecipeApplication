package models.fridge;

import models.IngredientUnit;
import models.recipeList.Ingredient;

import java.time.LocalDate;

public class Item extends Ingredient {

    private LocalDate useBy;
    public Item(String item, int amount, IngredientUnit unit, LocalDate useBy){
        this.item = item;
        this.amount = amount;
        this.unit = unit;
        this.useBy = useBy;
    }

    public LocalDate getUseBy(){
        return useBy;
    }
    public void setUseBy(LocalDate value){
        useBy = value;
    }
}
