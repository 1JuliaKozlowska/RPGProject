package Utils;

public class TerminalUtils {

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
}





