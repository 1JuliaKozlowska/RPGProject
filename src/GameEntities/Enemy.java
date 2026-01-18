package GameEntities;

import Interfaces.IGameEntity;

public abstract class Enemy implements IGameEntity {

    //klasa na której bazują przeciwnicy
    protected int currentHealth;
    protected int difficultyLevel;

    public Enemy(int difficultyLevel){
        this.difficultyLevel = difficultyLevel;
        currentHealth = getHealth();
    }

    @Override
    public abstract String getName();

    @Override
    public abstract String getDescription();

    @Override
    public abstract int getBaseAttackPoints();

    @Override
    public abstract int getBaseHealth();

    @Override
    public abstract int getBaseDefense();

    @Override
    public int getAttackPoints() {
        return (int) (getBaseAttackPoints() * (1 + 0.12 * (difficultyLevel - 1)));
    }

    @Override
    public int getHealth() {
        return (int) (getBaseHealth() * Math.pow(1 + 0.2 * (difficultyLevel - 1), 1.2));
    }

    @Override
    public int getCurrentHealth() {
        return currentHealth;
    }

    @Override
    public int getDefense() {
        return (int)(getBaseDefense() * (1 + 0.3 * Math.log(difficultyLevel)));
    }

    @Override
    public abstract String getASCIIArt(int line);

    @Override
    public int takeAttack(int damageValue) {
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
    public boolean isAlive() {
        return currentHealth > 0;
    }
}
