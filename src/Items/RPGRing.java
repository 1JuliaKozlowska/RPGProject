package Items;

import java.util.UUID;

public abstract class RPGRing extends Item {
    protected final int meleeDamageBonus;
    protected final int meleeDefenseBonus;

    protected RPGRing(RingBuilder b) {
        super(b);
        this.meleeDamageBonus = b.meleeDamageBonus;
        this.meleeDefenseBonus = b.meleeDefenseBonus;
    }

    public static abstract class RingBuilder extends Item.ItemBuilder<RingBuilder> {
        private int meleeDamageBonus = 0;
        private int meleeDefenseBonus = 0;

        protected RingBuilder(String id) { super(id); }

        @Override
        protected RingBuilder self() { return this; }

        public RingBuilder meleeDamageBonus(int v) { this.meleeDamageBonus = v; return this; }
        public RingBuilder meleeDefenseBonus(int v) { this.meleeDefenseBonus = v; return this; }
    }
}
