package Utils.UI;

import Interfaces.IGameEntity;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

public class MainMenu implements IGameState {
    private final MenuManager manager;
    private boolean finished = false;

    public MainMenu(MenuManager menuManager){
        this.manager = menuManager;
    }

    @Override
    public void Display(){
        TerminalUtils.ClearTerminal();
        GameEntities.Character[] characters = manager.game.getPlayer().getSelectedCharacters();
        int difficulty = manager.game.getDifficulty();
        System.out.println("RPG Game main menu");
        if (difficulty < 5) {
            System.out.println("Current difficulty: " + TerminalUtils.ColoredText("lightgreen", String.valueOf(difficulty)));
        }
        else if (difficulty >= 5 && difficulty < 8)
        {
            System.out.println("Current difficulty: " + TerminalUtils.ColoredText("yellow", String.valueOf(difficulty)));
        }
        else
        {
            System.out.println("Current difficulty: " + TerminalUtils.ColoredText("red", String.valueOf(difficulty)));
        }
        System.out.println("Money: " + TerminalUtils.ColoredText("lightyellow", String.valueOf(manager.game.getPlayer().GetMoney())));
        System.out.println("Your team:");
        System.out.println(TerminalUtils.EntitiesInRowString(characters));
        System.out.println(TerminalUtils.EntitiesNamesInRowString(characters));
        System.out.println(TerminalUtils.StringOptions(new String[] {"1. Fight!", "2. Show characters", "3. Show inventory", "4. Shop", "5. Change difficulty", "6. Exit game"}));

    }

    @Override
    public void HandleInput(String input){
        switch (input) {
            case "1" -> System.out.println("Fighting!");
            case "2" -> manager.Push(new CharactersMenu(manager));
            case "3" -> System.out.println("Showing inventory!");
            case "4" -> System.out.println("Shop");
            case "5" -> manager.Push(new NumberInput(manager, "Enter difficulty value (1-10):", "Provided value is not a number. Please enter a number.", manager.game::setDifficulty));
            case "6" -> finished = true;
            default -> System.out.println("Invalid choice. Please enter valid number.");
        }
    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
