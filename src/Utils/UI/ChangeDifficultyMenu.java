package Utils.UI;

import Interfaces.IGameState;
import Utils.MenuManager;
import Utils.TerminalUtils;

public class ChangeDifficultyMenu implements IGameState {
    private final MenuManager manager;
    private boolean finished = false;

    //menu które zmienia poziom trudności
    public ChangeDifficultyMenu(MenuManager menuManager){
        this.manager = menuManager;
    }

    @Override
    public void Display(){
        System.out.println("Enter difficulty value:");
    }

    @Override
    public void HandleInput(String input){
        try {
            manager.game.setDifficulty(Integer.parseInt(input));
            finished = true;
        } catch (Exception e){
            System.out.println("Provided value is not a number. Please enter a number.");
        }

    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}
