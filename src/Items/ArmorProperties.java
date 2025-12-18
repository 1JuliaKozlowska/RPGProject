package Items;

import Enums.ItemRarity;

import java.util.UUID;

public class ArmorProperties {
    public final String id;
    public final String name;
    public final String description;
    public final int meleeDefenseBonus;
    public final int rangedDefenseBonus;
    public final int magicDefenseBonus;
    public final int summonDefenseBonus;
    public final int thornsValuePercentage;
    public final int sellValue;
    public final ItemRarity rarity;

    private ArmorProperties(ArmorProperties.ArmorBuilder b) {
        this.id = b.id;
        this.name = b.name;
        this.description = b.description;
        this.meleeDefenseBonus = b.meleeDefenseBonus;
        this.rangedDefenseBonus = b.rangedDefenseBonus;
        this.magicDefenseBonus = b.magicDefenseBonus;
        this.summonDefenseBonus = b.summonDefenseBonus;
        this.thornsValuePercentage = b.thornsValuePercentage;
        this.sellValue = b.sellValue;
        this.rarity = b.rarity;
    }

    public static ArmorProperties.ArmorBuilder builder(String id) {
        return new ArmorProperties.ArmorBuilder(id);
    }

    public static final class ArmorBuilder{
        private final String id;
        private String name = "defaultArmorName";
        private String description = "defaultArmorDescription";
        private int meleeDefenseBonus = 0;
        private int rangedDefenseBonus = 0;
        private int magicDefenseBonus = 0;
        private int summonDefenseBonus = 0;
        private int thornsValuePercentage = 0;
        private int sellValue = 0;
        private ItemRarity rarity = ItemRarity.COMMON;

        public ArmorBuilder(String id) { this.id = id; }

        public ArmorProperties.ArmorBuilder name(String n) {this.name = n; return this;}
        public ArmorProperties.ArmorBuilder description(String d) {this.description = d; return this;}
        public ArmorProperties.ArmorBuilder meleeDefenseBonus(int m) {this.meleeDefenseBonus = m; return this;}
        public ArmorProperties.ArmorBuilder rangedDefenseBonus(int r) {this.rangedDefenseBonus = r; return this;}
        public ArmorProperties.ArmorBuilder magicDefenseBonus(int m) {this.magicDefenseBonus = m; return this;}
        public ArmorProperties.ArmorBuilder summonDefenseBonus(int s) {this.summonDefenseBonus = s; return this;}
        public ArmorProperties.ArmorBuilder thornsValuePercentage(int t) {this.thornsValuePercentage = t; return this;}
        public ArmorProperties.ArmorBuilder sellValue(int s) {this.sellValue = s; return this;}
        public ArmorProperties.ArmorBuilder rarity(ItemRarity r) {this.rarity = r; return this;}

        public ArmorProperties build()
        {
            return new ArmorProperties(this);
        }

    }
}
