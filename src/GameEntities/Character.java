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

    protected int baseDamage;
    protected int baseHealth;
    protected int baseDefense;

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


    @Override
    public int getBaseDamage() { return baseDamage; }

    @Override
    public int getBaseHealth() { return baseHealth; }

    @Override
    public int getBaseDefense() { return baseDefense; }


    //TODO: Zmienić wartości aby były wyliczane z założonych przedmiotów i ich buffów
    @Override
    public int getDamage() {
        return baseDamage;
    }

    @Override
    public int getHealth() {
        return baseHealth;
    }

    @Override
    public int getDefense() {
        return baseDefense;
    }
}
