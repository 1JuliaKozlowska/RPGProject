package Items;

import Enums.ItemRarity;

import java.util.UUID;

public class WeaponProperties {
    public final String id;
    public final String name;
    public final String description;
    public final int meleeDamageBonus;
    public final int rangedDamageBonus;
    public final int magicDamageBonus;
    public final int summonDamageBonus;
    public final int sellValue;
    public final ItemRarity rarity;

    private WeaponProperties(WeaponProperties.WeaponBuilder b) {
        this.id = b.id;
        this.name = b.name;
        this.description = b.description;
        this.meleeDamageBonus = b.meleeDamageBonus;
        this.rangedDamageBonus = b.rangedDamageBonus;
        this.magicDamageBonus = b.magicDamageBonus;
        this.summonDamageBonus = b.summonDamageBonus;
        this.sellValue = b.sellValue;
        this.rarity = b.rarity;
    }

    public static WeaponProperties.WeaponBuilder builder(String id) {
        return new WeaponProperties.WeaponBuilder(id);
    }

    public static final class WeaponBuilder{
        private final String id;
        private String name = "defaultWeaponName";
        private String description = "defaultWeaponDescription";
        private int meleeDamageBonus = 0;
        private int rangedDamageBonus = 0;
        private int magicDamageBonus = 0;
        private int summonDamageBonus = 0;
        private int sellValue = 0;
        private ItemRarity rarity = ItemRarity.COMMON;

        public WeaponBuilder(String id) { this.id = id; }

        public WeaponProperties.WeaponBuilder name(String n) {this.name = n; return this;}
        public WeaponProperties.WeaponBuilder description(String d) {this.description = d; return this;}
        public WeaponProperties.WeaponBuilder meleeDamageBonus(int mDam) {this.meleeDamageBonus = mDam; return this;}
        public WeaponProperties.WeaponBuilder rangedDamageBonus(int rDam) {this.rangedDamageBonus = rDam; return this;}
        public WeaponProperties.WeaponBuilder magicDamageBonus(int mDam) {this.magicDamageBonus = mDam; return this;}
        public WeaponProperties.WeaponBuilder summonDamageBonus(int sDam) {this.summonDamageBonus = sDam; return this;}
        public WeaponProperties.WeaponBuilder sellValue(int s) {this.sellValue = s; return this;}
        public WeaponProperties.WeaponBuilder rarity(ItemRarity r) {this.rarity = r; return this;}

        public WeaponProperties build()
        {
            return new WeaponProperties(this);
        }

    }
}
