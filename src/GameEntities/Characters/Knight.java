package GameEntities.Characters;

import Core.Attack;
import GameEntities.Character;

public class Knight extends Character
{
    private final Attack normalAttack;
    private final Attack specialAttack;
    public Knight(){
        normalAttack = new Attack("Sword Slash", "Simple attack.", this);
        specialAttack = new Attack("Charge!", "Powerful attack that also damages attacker.", this);
        specialAttack.damageMultiplier = 1.5;
        specialAttack.selfDamageValue = 0.2;
    }


    @Override
    public String getASCIIArt(int line){
        return switch (line) {
            case 0 -> "  <> |";
            case 1 -> " /||_|";
            case 2 -> "/_||  ";
            case 3 -> "  /\\  ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }

    @Override
    public String getName() {
        return "Knight";
    }

    @Override
    public String getDescription() {
        return "Noble knight.";
    }

    @Override
    public int getBaseAttackPoints() {
        return 30;
    }

    @Override
    public int getBaseHealth() {
        return 100;
    }

    @Override
    public int getBaseDefense() {
        return 10;
    }

    @Override
    public Attack normalAttack() {
        return normalAttack;
    }

    @Override
    public Attack specialAttack() {
        return specialAttack;
    }


}
