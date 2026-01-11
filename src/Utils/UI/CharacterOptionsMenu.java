package Utils.UI;

import GameEntities.Character;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

public class CharacterOptionsMenu implements IGameState {
    private final MenuManager manager;
    private final Character character;
    private boolean finished = false;

    public CharacterOptionsMenu(MenuManager menuManager, Character character){
        this.manager = menuManager;
        this.character = character;
    }

    @Override
    public void Display(){
        System.out.println(character.getName());
        System.out.println(character.getDescription());
        System.out.println(TerminalUtils.CharacterWithStatsString(character));
        System.out.println(TerminalUtils.StringOptions(new String[] {"1. Use in party", "2. Equip weapon", "3. Equip armor", "4. Equip ring", "5. Go back"}));
    }

    @Override
    public void HandleInput(String input){
        switch (input) {
            case "1" -> System.out.println("Use in party");
            case "2" -> System.out.println("Equip weapon");
            case "3" -> System.out.println("Equip armor");
            case "4" -> System.out.println("Equip ring");
            case "5" -> finished = true;
            default -> System.out.println("Invalid choice. Please enter valid number.");
        }
    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
