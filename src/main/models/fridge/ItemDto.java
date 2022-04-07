package models.fridge;
import models.recipeList.Ingredient;

public class ItemDto extends Ingredient {
    private String useBy;
    public ItemDto(){

    }
    public String getUseBy(){
        return useBy;
    }
    public void setUseBy(String value){
        useBy = value;
    }
}
