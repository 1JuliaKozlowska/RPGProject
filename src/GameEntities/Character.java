package GameEntities;

import Core.Attack;
import Core.Damage;
import Interfaces.IGameEntity;

public abstract class Character implements IGameEntity {

    

    public void setCurrentHealth(int currentHealth) {
        this.currentHealth = currentHealth;
    }

    protected int currentHealth;

    protected int attackPointsLevel;
    protected int healthLevel;
    protected int defenseLevel;

    @Override
    public abstract String getASCIIArt(int line);

    public Character() {
        this.attackPointsLevel = 0;
        this.healthLevel = 0;
        this.defenseLevel = 0;
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
    public int takeAttack(int damageValue)
    {
        double reduction = (double) damageValue / (damageValue + getDefense());
        int finalDamage = (int) Math.round(damageValue * reduction);
        if (finalDamage >= getCurrentHealth()){
            currentHealth = 0;
        }
        else
        {
            currentHealth -= finalDamage;
        }
        return finalDamage;
    }

    @Override
    public int takeAttackNoDefense(int damageValue) {
        if (damageValue >= getCurrentHealth()){
            currentHealth = 0;
        }
        else
        {
            currentHealth -= damageValue;
        }
        return damageValue;
    }

    @Override
    public boolean isAlive(){
        return currentHealth > 0;
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
