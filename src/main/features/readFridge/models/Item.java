package features.readFridge.models;

import models.IngredientUnit;

import java.util.Date;

public class Item {
    private String item;
    private int amount;
    private IngredientUnit unit;
    private Date useBy;
    public Item(String item, int amount, IngredientUnit unit, Date useBy){
        this.item = item;
        this.amount = amount;
        this.unit = unit;
        this.useBy = useBy;
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
    public Date getUseBy(){
        return useBy;
    }
    public void setUseBy(Date value){
        useBy = value;
    }
}
