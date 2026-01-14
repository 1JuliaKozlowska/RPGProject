package GameEntities.Enemies;

import GameEntities.Enemy;

public class Harpy extends Enemy {

    public Harpy(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Harpy";
    }

    @Override
    public String getDescription() {
        return "Half-human and half-bird personification of storm winds.";
    }

    @Override
    public int getBaseAttackPoints() {
        return 50;
    }

    @Override
    public int getBaseHealth() {
        return 80;
    }

    @Override
    public int getBaseDefense() {
        return 20;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "  5\\";
            case 1 -> "\\\\()//";
            case 2 -> "   \\  ";
            case 3 -> "    V ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
