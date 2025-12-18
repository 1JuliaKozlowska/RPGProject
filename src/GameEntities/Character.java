package GameEntities;

import Interfaces.IGameEntity;
import Items.RPGArmor;
import Items.RPGRing;
import Items.RPGWeapon;

public abstract class Character implements IGameEntity {
    protected String name;
    protected String description;
    protected Attack[] attacks = new Attack[4];
    protected RPGWeapon equippedWeapon;
    protected RPGArmor equippedArmor;
    protected RPGRing equippedRing;
    protected abstract String printASCIIArt(int line);

    public Character() {
        this.name = null;
        this.description = null;
        this.equippedWeapon = null;
        this.equippedArmor = null;
        this.equippedRing = null;
    }

    @Override
    public String getName() { return name; }

    @Override
    public String getDescription() { return description; }

    @Override
    public Attack[] getAttacks() { return attacks; }

    @Override
    public RPGWeapon getEquippedWeapon() { return equippedWeapon; }

    @Override
    public RPGArmor getEquippedArmor() { return equippedArmor; }

    @Override
    public RPGRing getEquippedRing() { return equippedRing; }
}
