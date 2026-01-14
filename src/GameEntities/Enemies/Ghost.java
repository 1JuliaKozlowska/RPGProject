package GameEntities.Enemies;

import GameEntities.Enemy;

public class Ghost extends Enemy {

    public Ghost(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Ghost";
    }

    @Override
    public String getDescription() {
        return "Undead creature made of ectoplasm";
    }

    @Override
    public int getBaseAttackPoints() {
        return 30;
    }

    @Override
    public int getBaseHealth() {
        return 60;
    }

    @Override
    public int getBaseDefense() {
        return 60;
    }

    @Override
    public String getASCIIArt(int line) {
        return switch (line) {
            case 0 -> "  /\\  ";
            case 1 -> " (**) ";
            case 2 -> " |  | ";
            case 3 -> " ~~~~ ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
