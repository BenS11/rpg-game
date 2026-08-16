package rpg.npcs;

import java.util.List;

import rpg.items.Item;

public class ShopKeeper {
    
    private List<Item> items;

    public ShopKeeper() {}

    public ShopKeeper withOptions(List<Item> items) {
        if (this.items == null) {
            this.items = items;
        } else {
            this.items.addAll(items);
        }

        return this;
    }
}
