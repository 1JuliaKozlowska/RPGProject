package Items;

public abstract class RPGWeapon extends Item {
    protected final int meleeDamageBonus;
    protected final int rangedDamageBonus;
    protected final int magicDamageBonus;
    protected final int summonDamageBonus;

    protected RPGWeapon(WeaponBuilder b) {
        super(b);
        this.meleeDamageBonus = b.meleeDamageBonus;
        this.rangedDamageBonus = b.rangedDamageBonus;
        this.magicDamageBonus = b.magicDamageBonus;
        this.summonDamageBonus = b.summonDamageBonus;
    }

    public int getMeleeDamageBonus() { return meleeDamageBonus; }

    public static abstract class WeaponBuilder extends Item.ItemBuilder<WeaponBuilder> {
        private int meleeDamageBonus = 0;
        private int rangedDamageBonus = 0;
        private int magicDamageBonus = 0;
        private int summonDamageBonus = 0;

        protected WeaponBuilder(String id) { super(id); }

        @Override
        protected WeaponBuilder self() { return this; }

        public WeaponBuilder meleeDamageBonus(int v) { this.meleeDamageBonus = v; return this; }
        public WeaponBuilder rangedDamageBonus(int v) { this.rangedDamageBonus = v; return this; }
        public WeaponBuilder magicDamageBonus(int v) { this.magicDamageBonus = v; return this; }
        public WeaponBuilder summonDamageBonus(int v) { this.summonDamageBonus = v; return this; }
    }
}
