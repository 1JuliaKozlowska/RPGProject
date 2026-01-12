package GameEntities;

import Core.Attack;
import Core.Damage;
import Interfaces.IGameEntity;

public abstract class Character implements IGameEntity {

    /*protected String name;
    protected String description;

    protected int baseAttackPoints;
    protected int baseHealth;
    protected int baseDefense;*/

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    protected int currentHealth;
    protected boolean alive;

    protected int attackPointsLevel;
    protected int healthLevel;
    protected int defenseLevel;

    @Override
    public abstract String getASCIIArt(int line);

    public Character() {
        this.attackPointsLevel = 0;
        this.healthLevel = 0;
        this.defenseLevel = 0;
        alive = true;
        fullHeal();
    }

    @Override
    public abstract String getName();

    @Override
    public abstract String getDescription();

    public void attack(IGameEntity target, Damage damage)
    {
        target.takeAttack(damage.getDamageValue());
    }

    @Override
    public void takeAttack(int damageValue)
    {
        int finalDamage = damageValue * (damageValue / (damageValue + getDefense()));
        if (finalDamage >= getCurrentHealth()){
            currentHealth = 0;

        }
    }

    @Override
    public boolean isAlive(){
        return alive;
    }

    @Override
    public abstract int getBaseAttackPoints();

    @Override
    public abstract int getBaseHealth();

    @Override
    public abstract int getBaseDefense();

    @Override
    public int getAttackPoints() {
        return getBaseAttackPoints() + attackPointsLevel * 5;
    }

    @Override
    public int getHealth() {
        return getBaseHealth() + healthLevel * 10;
    }

    @Override
    public int getDefense() {
        return getBaseDefense() + defenseLevel * 2;
    }

    public void LevelUpDamage(){
        attackPointsLevel++;
    }
    public void LevelUpHealth(){
        healthLevel++;
    }
    public void LevelUpDefense(){
        defenseLevel++;
    }

    public void fullHeal(){
        setCurrentHealth(getHealth());
    }

    public int getTotalLevel(){
        return defenseLevel + healthLevel + attackPointsLevel;
    }

    public int getUpgradeCost(){
        return 50 + 5 * getTotalLevel();
    }

    public abstract Attack normalAttack();
    public abstract Attack specialAttack();
}
