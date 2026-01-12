package GameEntities.Characters;

import Core.Attack;
import GameEntities.Character;

public class Mage extends Character {

    private final Attack normalAttack;
    private final Attack specialAttack;

    public Mage() {
        normalAttack = new Attack("Simple Spell", "Most basic offensive spell.", this);
        specialAttack = new Attack("Mana Burst", "Powerful magical explosion that deals damage to all enemies.", this);
        specialAttack.damageMultiplier = 0.5;
        specialAttack.spread = true;
    }

    @Override
    public String getASCIIArt(int line){
        return switch (line) {
            case 0 -> "  ^  *";
            case 1 -> "/[]\\ I";
            case 2 -> " []  I";
            case 3 -> " /\\  I";
            default -> "  ^  *\n/[]\\ I\n []  I\n /\\  I";
        };
    }

    @Override
    public String getName() {
        return "Mage";
    }

    @Override
    public String getDescription() {
        return "Mysterious caster.";
    }

    @Override
    public int getBaseAttackPoints() {
        return 40;
    }

    @Override
    public int getBaseHealth() {
        return 60;
    }

    @Override
    public int getBaseDefense() {
        return 2;
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
