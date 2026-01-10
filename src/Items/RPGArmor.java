package Items;

import java.util.UUID;

public abstract class RPGArmor extends Item {
    protected final int meleeDefenseBonus;
    protected final int rangedDefenseBonus;
    protected final int magicDefenseBonus;
    protected final int summonDefenseBonus;
    protected final int thornsValuePercentage;

    protected RPGArmor(ArmorBuilder b) {
        super(b);
        this.meleeDefenseBonus = b.meleeDefenseBonus;
        this.rangedDefenseBonus = b.rangedDefenseBonus;
        this.magicDefenseBonus = b.magicDefenseBonus;
        this.summonDefenseBonus = b.summonDefenseBonus;
        this.thornsValuePercentage = b.thornsValuePercentage;
    }

    public int getMeleeDefenseBonus() { return meleeDefenseBonus; }
    public int getRangedDefenseBonus() { return rangedDefenseBonus; }
    public int getMagicDefenseBonus() { return magicDefenseBonus; }
    public int getSummonDefenseBonus() { return summonDefenseBonus; }
    public int getThornsValuePercentage() { return thornsValuePercentage; }

    public static abstract class ArmorBuilder extends Item.ItemBuilder<ArmorBuilder> {
        private int meleeDefenseBonus = 0;
        private int rangedDefenseBonus = 0;
        private int magicDefenseBonus = 0;
        private int summonDefenseBonus = 0;
        private int thornsValuePercentage = 0;

        protected ArmorBuilder(String id) { super(id); }

        @Override
        protected ArmorBuilder self() { return this; }

        public ArmorBuilder meleeDefenseBonus(int v) { this.meleeDefenseBonus = v; return this; }
        public ArmorBuilder rangedDefenseBonus(int v) { this.rangedDefenseBonus = v; return this; }
        public ArmorBuilder magicDefenseBonus(int v) { this.magicDefenseBonus = v; return this; }
        public ArmorBuilder summonDefenseBonus(int v) { this.summonDefenseBonus = v; return this; }
        public ArmorBuilder thornsValuePercentage(int v) { this.thornsValuePercentage = v; return this; }
    }
}
