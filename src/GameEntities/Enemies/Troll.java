package GameEntities.Enemies;

import GameEntities.Enemy;

public class Troll extends Enemy {

    public Troll(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Troll";
    }

    @Override
    public String getDescription() {
        return "Dangerous strong creature.";
    }

    @Override
    public int getBaseAttackPoints() {
        return 50;
    }

    @Override
    public int getBaseHealth() {
        return 200;
    }

    @Override
    public int getBaseDefense() {
        return 60;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "& (@) ";
            case 1 -> "N=/X\\\\";
            case 2 -> "N ###/";
            case 3 -> "  U U ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
