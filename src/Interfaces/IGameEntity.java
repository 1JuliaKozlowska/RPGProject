package Interfaces;


import Core.Damage;

public interface IGameEntity {
    String getName();
    String getDescription();

    int getBaseAttackPoints();
    int getBaseHealth();
    int getBaseDefense();

    int getAttackPoints();
    int getHealth();
    int getCurrentHealth();
    int getDefense();

    String getASCIIArt(int line);

    void takeAttack(int damageValue);

    boolean isAlive();
}
