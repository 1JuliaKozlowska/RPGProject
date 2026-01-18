package Utils.UI;

import GameEntities.Character;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

public class MainMenu implements IGameState {
    private final MenuManager manager;
    private boolean finished = false;

    //menu główne
    public MainMenu(MenuManager menuManager){
        this.manager = menuManager;
    }

    @Override
    public void Display(){
        Character[] characters = manager.game.getPlayer().getTeamCharacters();
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
        System.out.println(TerminalUtils.StringOptions(new String[] {"1. Fight!", "2. Characters", "3. Change difficulty", "4. Exit game"}));

    }

    @Override
    public void HandleInput(String input){
        switch (input) {
            case "1" -> {
                TerminalUtils.ClearTerminal();
                manager.Push(new FightScene(manager));
            }
            case "2" -> {
                TerminalUtils.ClearTerminal();
                manager.Push(new CharactersMenu(manager));
            }
            case "3" -> manager.Push(new NumberInput(manager, "Enter difficulty value (1-10):", "Provided value is not a number. Please enter a number.", manager.game::setDifficulty));
            case "4" -> finished = true;
            default -> TerminalUtils.ClearTerminalWithMessage(TerminalUtils.ColoredText("red", "Invalid choice. Please enter valid number."));
        }
    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
