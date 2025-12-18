package Items;

import Enums.ItemRarity;
import java.util.UUID;

public class RingProperties {
    public final String id;
    public final String name;
    public final String description;
    public final int meleeDamageBonus;
    public final int rangedDamageBonus;
    public final int magicDamageBonus;
    public final int summonDamageBonus;
    public final int meleeDefenseBonus;
    public final int rangedDefenseBonus;
    public final int magicDefenseBonus;
    public final int summonDefenseBonus;
    public final int sellValue;
    public final ItemRarity rarity;

    private RingProperties(RingBuilder b) {
        this.id = b.id;
        this.name = b.name;
        this.description = b.description;
        this.meleeDamageBonus = b.meleeDamageBonus;
        this.rangedDamageBonus = b.rangedDamageBonus;
        this.magicDamageBonus = b.magicDamageBonus;
        this.summonDamageBonus = b.summonDamageBonus;
        this.meleeDefenseBonus = b.meleeDefenseBonus;
        this.rangedDefenseBonus = b.rangedDefenseBonus;
        this.magicDefenseBonus = b.magicDefenseBonus;
        this.summonDefenseBonus = b.summonDefenseBonus;
        this.sellValue = b.sellValue;
        this.rarity = b.rarity;
    }

    public static RingBuilder builder(String id) {
        return new RingBuilder(id);
    }

    public static final class RingBuilder{
        private final String id;
        private String name = "defaultRingName";
        private String description = "defaultRingDescription";
        private int meleeDamageBonus = 0;
        private int rangedDamageBonus = 0;
        private int magicDamageBonus = 0;
        private int summonDamageBonus = 0;
        private int meleeDefenseBonus = 0;
        private int rangedDefenseBonus = 0;
        private int magicDefenseBonus = 0;
        private int summonDefenseBonus = 0;
        private int sellValue = 0;
        private ItemRarity rarity = ItemRarity.COMMON;

        public RingBuilder(String id) { this.id = id; }

        public RingBuilder name(String n) {this.name = n; return this;}
        public RingBuilder description(String d) {this.description = d; return this;}
        public RingBuilder meleeDamageBonus(int mDam) {this.meleeDamageBonus = mDam; return this;}
        public RingBuilder rangedDamageBonus(int rDam) {this.rangedDamageBonus = rDam; return this;}
        public RingBuilder magicDamageBonus(int mDam) {this.magicDamageBonus = mDam; return this;}
        public RingBuilder summonDamageBonus(int sDam) {this.summonDamageBonus = sDam; return this;}
        public RingBuilder meleeDefenseBonus(int mDef) {this.meleeDefenseBonus = mDef; return this;}
        public RingBuilder rangedDefenseBonus(int rDef) {this.rangedDefenseBonus = rDef; return this;}
        public RingBuilder magicDefenseBonus(int mDef) {this.magicDefenseBonus = mDef; return this;}
        public RingBuilder summonDefenseBonus(int sDef) {this.summonDefenseBonus = sDef; return this;}
        public RingBuilder sellValue(int s) {this.sellValue = s; return this;}
        public RingBuilder rarity(ItemRarity r) {this.rarity = r; return this;}

        public RingProperties build()
        {
            return new RingProperties(this);
        }

    }
}
