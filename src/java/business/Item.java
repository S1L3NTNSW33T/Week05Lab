/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package business;

import java.io.Serializable;

/**
 *
 * @author 725899
 */
public class Item implements Serializable {
    
    private String name;
    
    public Item() {
    }

    public boolean setName (String name) {
        this.name = name;
        return true;
    }
    
    public String getName() {
        return name;
    }
    
    public boolean equals(Item item) {
        if (item.getName().equals(this.getName())) {
            return true;
        }
        
        return false;
    }
}
