package GameEntities.Enemies;

import GameEntities.Enemy;

public class Slime extends Enemy {

    public Slime(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Slime";
    }

    @Override
    public String getDescription() {
        return "Cute jelly monster";
    }

    @Override
    public int getBaseAttackPoints() {
        return 20;
    }

    @Override
    public int getBaseHealth() {
        return 60;
    }

    @Override
    public int getBaseDefense() {
        return 30;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "    O ";
            case 1 -> " __/_ ";
            case 2 -> "/o o \\";
            case 3 -> "\\_w__/";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
