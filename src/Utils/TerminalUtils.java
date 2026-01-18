package Utils;

import Core.Attack;
import GameEntities.Character;
import Interfaces.IGameEntity;

import java.util.Map;

public class TerminalUtils {

    //szerokość terminala
    public static final int termonalWidth = 140;

    //ustawia dany kolor w terminalu
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
            default -> "";
        };
    }

    //wyświtla tekst o danym kolorze a następnie przywraca kolor domyślny
    public static String ColoredText(String color, String text){
        return SetColor(color) + text + SetColor("clear");
    }

    //czyści terminal. w wypadku gdy terminal nie obsługuje czyszczenia oddzieli poprzedni tekst znakami '='
    public static void ClearTerminal(){
        System.out.println(String.valueOf('=').repeat(TerminalUtils.termonalWidth));
        System.out.print("\033[H\033[2J");
        System.out.flush();
    }

    //czyści terminal i wyświetla wiadomość po tym
    public static void ClearTerminalWithMessage(String message){
        ClearTerminal();
        System.out.println(message);
    }

    //zwraca postacie obok siebie
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

    //zwraca  nazwy postaci obok siebie
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

    //zwraca postacie oraz ich adresy ID obok siebie
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

    //zwraca postacie i ich statystyki obok siebie
    public static String CharacterWithStatsString(Character character){
        int spacing = 5;
        String result = "";
        for (int i = 0; i < 4; i++) {
            result += character.getASCIIArt(i);
            result += String.valueOf(' ').repeat(spacing);
            switch (i){
                case 0 -> result += "HP: " + character.getCurrentHealth() + "/" + character.getHealth();
                case 1 -> result += "Damage: " + character.getAttackPoints();
                case 2 -> result += "Defense: " + character.getDefense();
                case 3 -> result += "Level: " + character.getTotalLevel();
            }
            result += '\n';
        }
        result += "Level up cost - " + ColoredText("yellow", String.valueOf(character.getUpgradeCost())) + " money\n";
        result += "Full heal cost - " + ColoredText("yellow", String.valueOf(20)) + " money";
        return result;
    };

    //zwraca listę opcji inputu
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

    //zwraca ekran walki z przeciwnikami
    public static String FightScreenString(IGameEntity[] characters, IGameEntity[] enemies, int selectedCharacter, int targettedEnemy){
        int margin = 1;
        String result = "";
        result += "Now attacks - " + ColoredText("yellow", characters[selectedCharacter].getName()) + '\n';
        for (int i = 0; i < 3; i++) {
            result += padRight(String.valueOf(' ').repeat(margin) + padRight(characters[i].getName(), 8) + " " + characters[i].getCurrentHealth() + "/" + characters[i].getHealth() + " HP", termonalWidth - 18);
            result += padRight(enemies[i].getName(), 8) + " " + enemies[i].getCurrentHealth() + "/" + enemies[i].getHealth() + " HP" + '\n';
        }
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 4; j++) {
                if (i == selectedCharacter){
                    result += padRight((j == 1 ? (String.valueOf(' ').repeat(margin) + padRight(characters[i].getName(), 9)) : String.valueOf(' ').repeat(margin + 9)) + ' ' + ColoredText("yellow", characters[i].getASCIIArt(j)), termonalWidth - 7);
                }else if (!characters[i].isAlive()){
                    result += padRight((j == 1 ? (String.valueOf(' ').repeat(margin) + padRight(characters[i].getName(), 9)) : String.valueOf(' ').repeat(margin + 9)) + ' ' + ColoredText("red", characters[i].getASCIIArt(j)), termonalWidth - 7);
                }else {
                    result += padRight((j == 1 ? (String.valueOf(' ').repeat(margin) + padRight(characters[i].getName(), 9)) : String.valueOf(' ').repeat(margin + 9)) + ' ' + characters[i].getASCIIArt(j), termonalWidth - 16);
                }
                result += ColoredText(i == targettedEnemy ? "orange" : !enemies[i].isAlive() ? "red" : "default", enemies[i].getASCIIArt(j)) + (j == 1 ? (' ' + enemies[i].getName()) : "");
                result += '\n';
            }
        }
        return result;
    }

    //zwraca puste miejsce na postać
    private static String emptyCharacterASCIIArt(int line){
        return switch (line) {
            case 0, 3 -> "------";
            case 1, 2 -> "|    |";
            default -> "------\n|    |\n|    |\n------";
        };
    }

    //zwraca tekst i wypełnia daną ilość znaków na prawo znakami ' '
    public static String padRight(String text, int length) {
        if (text.length() >= length) {
            return text;
        }

        return text + " ".repeat(length - text.length());
    }

    //zwraca okienko z opisem ataku
    public static String attackString(Attack attack){
        String result = "";
        result += "=".repeat(90) + '\n';
        result += "| " + padRight(attack.getName() + " - " + attack.damage().getDamageValue(), 87) + "|\n";
        result += "| " + padRight(attack.getDescription(), 87) + "|\n";
        result += "=".repeat(90);
        return result;
    }
}





