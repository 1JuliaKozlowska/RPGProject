import GameEntities.Characters.Knight;
import Utils.TerminalUtils;

import java.lang.reflect.Method;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        boolean requirementsSatisfied = false;

        //wywołanie funkcji która pyta użytkownika, czy wszystko poprawnie się renderuje w terminalu. funkcja poprosi o wpisanie "yes"
        try {
            requirementsSatisfied = correctSettings();
        } catch (Exception e) {
            throw new RuntimeException(e);
        }

        if (requirementsSatisfied){
            System.out.println("correct");
        }
        else
        {
            System.out.println("Closing game...");
            System.exit(0);
        }

    }

    static boolean correctSettings() throws Exception{
        System.out.println("Hello and welcome to the RPG Game!");
        System.out.println("For this game to run properly you need:");
        System.out.println("1. Monospace terminal font. If you are using one this ASCII knight should be rendered correctly:");
        //sprawdzenie czy ASCII arty poprawnie są wyświetlane. Sprawdzane jest to przy użyciu refleksji
        Object instance = Knight.class.getDeclaredConstructor().newInstance();
        Method method = Knight.class.getDeclaredMethod("printASCIIArt", int.class);
        String result = (String) method.invoke(instance, 4);
        System.out.println(result);
        //sprawdzanie czy terminal ma odpowiedną szerokość w znakach. Jeśli tak znaki "=" powinny być wyświetlone w jednej linijce
        System.out.println("2. At least 140 chars terminal width. If your terminal is set correctly those '=' should fit in one line:");
        System.out.println(String.valueOf('=').repeat(140));
        //sprawdzenie czy kolory się poprawnie wyświetlają
        System.out.println("3. Color support. Following colors should be displayed correctly: " + TerminalUtils.ColoredText("red", "red") + ", " + TerminalUtils.ColoredText("orange", "orange") + ", " +TerminalUtils.ColoredText("yellow", "yellow") + ", " +TerminalUtils.ColoredText("lightpurple", "light purple"));

        System.out.println("\nIf everything is displayed correctly type 'yes'. Otherwise game will close.");
        Scanner scanner = new Scanner(System.in);
        String answer = scanner.next();
        System.out.println(answer.toLowerCase());
        return answer.equalsIgnoreCase("yes") || answer.equalsIgnoreCase("y");
    }
}