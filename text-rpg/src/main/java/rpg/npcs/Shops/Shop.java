package rpg.npcs.Shops;

import java.util.ArrayList;
import java.util.List;

import rpg.items.Item;
import rpg.items.Items;
import rpg.utility.IO;

public class Shop {

    private final List<Item> forSale = new ArrayList<>();
    private boolean visited = false;

    public Shop() {
        forSale.addAll(Items.generateShopInventory());
    }

    public List<Item> getInventory() {
        return forSale;
    }

    public void onEnterShop() {
        visited = true;
    }

    public void displayInventory() {
        IO.printNumberedList(forSale);
    }


    public boolean canBuy(int idx, int treasure) {
        return forSale.get(idx).value() < treasure; 
    }

    public Item buy(int idx) {
        return forSale.set(idx, Items.soldOut);
    }

    public boolean hasItems() {
        for (Item i: forSale) {
            if (!i.equals(Items.soldOut)) return true;
        }

        return false;
    }

    public void visit() {
        visited = true;
    }

    public boolean visited() {
        return visited;
    }
}
