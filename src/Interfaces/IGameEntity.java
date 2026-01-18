package Interfaces;

//interfejs który implementują wszystkie postacie i przeciwnicy
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

    int takeAttack(int damageValue);
    int takeAttackNoDefense(int damageValue);

    boolean isAlive();
}
