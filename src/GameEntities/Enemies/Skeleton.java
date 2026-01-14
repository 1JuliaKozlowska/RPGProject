package GameEntities.Enemies;

import GameEntities.Enemy;

public class Skeleton extends Enemy {

    public Skeleton(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Skeleton";
    }

    @Override
    public String getDescription() {
        return "Undead cursed skeleton";
    }

    @Override
    public int getBaseAttackPoints() {
        return 35;
    }

    @Override
    public int getBaseHealth() {
        return 100;
    }

    @Override
    public int getBaseDefense() {
        return 30;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "   9  ";
            case 1 -> " \\/E3\\";
            case 2 -> "    ! ";
            case 3 -> "   /\\ ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
