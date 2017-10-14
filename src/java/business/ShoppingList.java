
package business;

import java.io.Serializable;
import java.util.ArrayList;

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
