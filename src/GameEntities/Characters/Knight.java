package GameEntities.Characters;

import GameEntities.Character;
import Items.RPGArmor;
import Items.RPGRing;
import Items.RPGWeapon;

public class Knight extends Character
{
    public Knight() {
        this.name = "Knight";
        this.description = "Noble knight.";

        this.baseDamage = 40;
        this.baseHealth = 100;
        this.baseDefense = 20;
    }



    @Override
    public String printASCIIArt(int line){
        return switch (line) {
            case 0 -> "  <> |";
            case 1 -> " /||_|";
            case 2 -> "/_||  ";
            case 3 -> "  /\\  ";
            default -> "  <> |\n /||_|\n/_||  \n  /\\  ";
        };
    }
}
