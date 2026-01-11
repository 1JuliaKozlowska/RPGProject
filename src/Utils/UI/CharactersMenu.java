package Utils.UI;

import Interfaces.IGameEntity;
import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

import java.util.HashMap;
import java.util.Map;
import java.util.Objects;

public class CharactersMenu implements IGameState {
    private final MenuManager manager;
    private boolean finished = false;
    private final Map<Integer, GameEntities.Character> availableCharactersWithId;

    public CharactersMenu(MenuManager menuManager){
        this.manager = menuManager;
        availableCharactersWithId = new HashMap<>();

        int id = 100;
        for (GameEntities.Character character : manager.game.getPlayer().getAvailableCharacters())
        {
            id++;
            availableCharactersWithId.put(id, character);
        }
    }

    @Override
    public void Display(){
        TerminalUtils.ClearTerminal();
        System.out.println("Characters menu");
        System.out.println("Available characters:");
        System.out.println(TerminalUtils.EntitiesInRowWithIdAndNamesString(availableCharactersWithId));
        System.out.println(TerminalUtils.StringOptions(new String[] {"1. Go back", "ID - view character"}));
    }

    @Override
    public void HandleInput(String input){
        if (Objects.equals(input, "1")){
            finished = true;
        } else {
            try {
                int value = Integer.parseInt(input);
                if (availableCharactersWithId.containsKey(value)){
                    manager.Push(new CharacterOptionsMenu(manager, availableCharactersWithId.get(value)));
                }
            } catch (Exception e){
                System.out.println("Provided value is not a number. Please enter a number.");
            }
        }
    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
