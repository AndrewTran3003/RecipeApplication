package features.readFridge.models;
import models.IngredientUnit;

public class ItemDto {
    private String item;
    private int amount;
    private IngredientUnit unit;
    private String useBy;
    public ItemDto(){

    }
    public String getItem(){
        return item;
    }
    public void setItem(String value){
        item = value;
    }
    public int getAmount(){
        return amount;
    }
    public void setAmount(int value){
        amount = value;
    }
    public IngredientUnit getUnit(){
        return unit;
    }
    public void setUnit(IngredientUnit value){
        unit = value;
    }
    public String getUseBy(){
        return useBy;
    }
    public void setUseBy(String value){
        useBy = value;
    }
}
