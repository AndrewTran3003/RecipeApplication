package models.fridge;

import java.util.ArrayList;

public class Fridge {
    private ArrayList<Item> items;
    public ArrayList<Item> getItems(){
        return items;
    }
    public void setItems(ArrayList<Item> value){
        items = value;
    }
}
