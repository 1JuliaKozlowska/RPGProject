package Items;

import Enums.ItemRarity;

public abstract class Item {
    protected final String id;
    protected final String name;
    protected final String description;
    protected final int sellValue;
    protected final ItemRarity rarity;

    protected Item(ItemBuilder<?> b) {
        this.id = b.id;
        this.name = b.name;
        this.description = b.description;
        this.sellValue = b.sellValue;
        this.rarity = b.rarity;
    }

    public String getId() { return id; }
    public String getName() { return name; }
    public String getDescription() { return description; }
    public int getSellValue() { return sellValue; }
    public ItemRarity getRarity() { return rarity; }

    //TODO: wyświetla nazwę kolorami zależnie od rarity
    public String getDisplayLine() {
        return name + " [" + rarity + "] - " + description;
    }

    public static abstract class ItemBuilder<T extends ItemBuilder<T>> {
        private final String id;
        private String name = "defaultItemName";
        private String description = "defaultItemDescription";
        private int sellValue = 0;
        private ItemRarity rarity = ItemRarity.COMMON;

        protected ItemBuilder(String id) {
            this.id = id;
        }

        protected abstract T self();

        public T name(String n) { this.name = n; return self(); }
        public T description(String d) { this.description = d; return self(); }
        public T sellValue(int s) { this.sellValue = s; return self(); }
        public T rarity(ItemRarity r) { this.rarity = r; return self(); }
    }
}
