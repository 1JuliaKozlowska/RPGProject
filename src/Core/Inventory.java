package Core;

import Items.Item;

import java.util.*;

public class Inventory {
    private final List<Item> items = new ArrayList<>();

    public void add(Item item) {
        items.add(item);
    }

    //TODO: lepsze wyświetlanie ekwipunku
    public void printInventory() {
        for (Item i : items) {
            System.out.println(i.getDisplayLine());
        }
    }
}
