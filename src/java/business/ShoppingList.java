/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;
import java.util.ArrayList;

/**
 *
 * @author 725899
 */
public class ShoppingList implements Serializable{
    private ArrayList<Item> items;
    
    public ShoppingList() {
        items = new ArrayList<>();
    }

    public ArrayList<Item> getItems() {
        return items;
    }

    public void setItems(ArrayList<Item> items) {
        this.items = items;
    }
    
    public void addItem(Item item) {
        items.add(item);
    }
    
    public void removeItem(Item item) {
        for (int i=0;i<items.size();i++) {
            if (items.get(i).getName().equals(item.getName())) {
                items.remove(i);
            }
        }
    }
}
