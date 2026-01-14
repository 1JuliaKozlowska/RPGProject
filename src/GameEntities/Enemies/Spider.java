package GameEntities.Enemies;

import GameEntities.Enemy;

public class Spider extends Enemy {

    public Spider(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Spider";
    }

    @Override
    public String getDescription() {
        return "Giant Spider";
    }

    @Override
    public int getBaseAttackPoints() {
        return 40;
    }

    @Override
    public int getBaseHealth() {
        return 80;
    }

    @Override
    public int getBaseDefense() {
        return 10;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "  _   ";
            case 1 -> " / \\/\\";
            case 2 -> "9  | /";
            case 3 -> "//\\\\\\\\";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
