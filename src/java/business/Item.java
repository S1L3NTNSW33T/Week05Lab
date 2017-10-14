package business;

public class Item  {
    
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
