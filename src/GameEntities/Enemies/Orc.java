package GameEntities.Enemies;

import GameEntities.Enemy;

public class Orc extends Enemy {

    public Orc(int difficultyLevel) {
        super(difficultyLevel);
    }

    @Override
    public String getName() {
        return "Orc";
    }

    @Override
    public String getDescription() {
        return "Brutal warrior of darkness";
    }

    @Override
    public int getBaseAttackPoints() {
        return 50;
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
            case 0 -> "# @)  ";
            case 1 -> "\\=()  ";
            case 2 -> "  (|  ";
            case 3 -> "  /\\  ";
            default -> getASCIIArt(0) + "\n" + getASCIIArt(1) + "\n" + getASCIIArt(2) + "\n" + getASCIIArt(3);
        };
    }
}
