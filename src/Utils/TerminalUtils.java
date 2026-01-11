package Utils;

import GameEntities.Character;
import Interfaces.IGameEntity;

import java.util.Map;

public class TerminalUtils {

    public static final int termonalWidth = 140;

    public static String SetColor(String color){
        return switch (color.toLowerCase()) {
            case "black" -> "\u001B[30m";
            case "red" -> "\u001B[31m";
            case "green" -> "\u001B[32m";
            case "yellow" -> "\u001B[33m";
            case "blue" -> "\u001B[34m";
            case "purple" -> "\u001B[35m";
            case "cyan" -> "\u001B[36m";
            case "white" -> "\u001B[37m";
            case "grey" -> "\u001B[90m";
            case "lightred" -> "\u001B[91m";
            case "lightgreen" -> "\u001B[92m";
            case "lightyellow" -> "\u001B[93m";
            case "lightblue" -> "\u001B[94m";
            case "lightpurple" -> "\u001B[95m";
            case "lightcyan" -> "\u001B[96m";
            case "lightwhite" -> "\u001B[97m";
            case "orange" -> "\u001B[38;5;208m";
            case "clear" -> "\u001B[0m";
            default -> "\u001B[0m";
        };
    }

    public static String ColoredText(String color, String text){
        return SetColor(color) + text + SetColor("clear");
    }

    public static void ClearTerminal(){
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    public static String EntitiesInRowString(IGameEntity[] entities){
        int spacing = 5;
        int margin = (TerminalUtils.termonalWidth - (entities.length * 6) - (spacing * (entities.length - 1))) / 2;
        String result = "";
        for (int i = 0; i < 4; i++)
        {
            result += String.valueOf(' ').repeat(margin);
            for (IGameEntity gameEntity : entities)
            {
                if (gameEntity != null)
                {
                    result += gameEntity.getASCIIArt(i);
                }
                else
                {
                    result += emptyCharacterASCIIArt(i);
                }
                result += String.valueOf(' ').repeat(spacing);
            }
            if (i != 3){
                result += '\n';
            }

        }
        return result;
    }

    public static String EntitiesNamesInRowString(IGameEntity[] entities){
        int spacing = 5;
        int margin = (TerminalUtils.termonalWidth - (entities.length * 6) - (spacing * (entities.length - 1))) / 2;
        String result = "";
        result += String.valueOf(' ').repeat(margin);
        for (IGameEntity gameEntity : entities)
        {
            if (gameEntity != null)
            {
                result += gameEntity.getName();
            }
            else
            {
                result += "Empty";
            }
            result += String.valueOf(' ').repeat(spacing);
        }

        return result;
    }

    public static String EntitiesInRowWithIdAndNamesString(Map<Integer, Character> entities){
        int spacing = 5;
        int margin = (TerminalUtils.termonalWidth - (entities.size() * 10) - (spacing * (entities.size() - 1))) / 2;
        String result = "";
        for (int i = 0; i < 4; i++)
        {
            if (i != 1 ){
                result += String.valueOf(' ').repeat(margin + 4);
            } else {
                result += String.valueOf(' ').repeat(margin);
            }
            for (Map.Entry<Integer, Character> gameEntity : entities.entrySet())
            {
                if (i != 1 ){
                    result += gameEntity.getValue().getASCIIArt(i);
                    result += String.valueOf(' ').repeat(spacing + 4);
                } else {
                    result += gameEntity.getKey() + " ";
                    result += gameEntity.getValue().getASCIIArt(i);
                    result += String.valueOf(' ').repeat(spacing);
                }
            }
            result += '\n';
        }
        result += String.valueOf(' ').repeat(margin + 4);
        for (Map.Entry<Integer, Character> gameEntity : entities.entrySet())
        {
            result += gameEntity.getValue().getName();
            result += String.valueOf(' ').repeat(spacing + 4);

        }
        return result;
    }

    public static String CharacterWithStatsString(Character character){
        String weapon = (character.getEquippedWeapon() != null) ? character.getEquippedWeapon().getName() : "NONE";
        String armor = (character.getEquippedArmor() != null) ? character.getEquippedArmor().getName() : "NONE";
        String ring = (character.getEquippedRing() != null) ? character.getEquippedRing().getName() : "NONE";
        int spacing = 5;
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += character.getASCIIArt(i);
            result += String.valueOf(' ').repeat(spacing);
            switch (i){
                case 0 -> result += "Base HP: " + character.getBaseHealth();
                case 1 -> result += "Base Damage: " + character.getBaseDamage();
                case 2 -> result += "Base Defense: " + character.getBaseDefense();
                case 3 -> result += "Equipment: Weapon - " + weapon + ", Armor - " + armor + ", Ring - " + ring;
            }
            if (i != 3){
                result += '\n';
            }
        }
        return result;
    };

    public static String StringOptions(String[] options){
        String result = "";
        int lines = 0;
        boolean newLine = true;
        for (int i = 0; i < options.length; i++) {
            if ((result.length() + 4 + options[i].length()) / 140 > lines){
                result += '\n';
                result += options[i];
                lines++;
                newLine = true;
            }else{
                if (!newLine){
                    result += String.valueOf(' ').repeat(4);
                }
                result += options[i];
                newLine = false;
            }
        }
        return result;
    }

    private static String emptyCharacterASCIIArt(int line){
        return switch (line) {
            case 0, 3 -> "------";
            case 1, 2 -> "|    |";
            default -> "------\n|    |\n|    |\n------";
        };
    }
}





