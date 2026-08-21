package rpg.items;

import java.util.List;

public class Items {
    
    private Items() {}

    public static Item soldOut = new Item().withName("Sold Out").withValue(999999).build();

    public static List<Item> generateShopInventory() {
        return List.of(new Item().withValue(5), new Item().withValue(10), new Item().withValue(15));
    }

    
}
