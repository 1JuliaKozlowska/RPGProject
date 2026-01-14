package GameEntities.Characters;

import Core.Attack;
import GameEntities.Character;

public class Archer extends Character {

    private final Attack normalAttack;
    private final Attack specialAttack;

    public Archer() {
        normalAttack = new Attack("Simple Shot", "Simple shot from bow.", this);
        specialAttack = new Attack("Headshot!", "Double damage but has 50% chance to miss.", this);
        specialAttack.damageMultiplier = 2;
        specialAttack.chanceToHit = 50;
    }

    @Override
    public String getASCIIArt(int line){
        return switch (line) {
            case 0 -> "o  \\  ";
            case 1 -> "[]--I>";
            case 2 -> "[] /  ";
            case 3 -> "/\\    ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }

    @Override
    public String getName() {
        return "Archer";
    }

    @Override
    public String getDescription() {
        return "Professional ranger.";
    }

    @Override
    public int getBaseAttackPoints() {
        return 50;
    }

    @Override
    public int getBaseHealth() {
        return 70;
    }

    @Override
    public int getBaseDefense() {
        return 6;
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
