package Utils.UI;

import Interfaces.IGameState;
import Utils.MenuManager;

import java.util.function.IntConsumer;

public class NumberInput implements IGameState {
    private final MenuManager manager;
    private boolean finished = false;
    private final String message;
    private final String invalidOptionMessage;
    private final IntConsumer setter;

    public NumberInput(MenuManager menuManager, String message, String invalidOptionMessage, IntConsumer setter){
        this.manager = menuManager;
        this.message = message;
        this.invalidOptionMessage = invalidOptionMessage;
        this.setter = setter;
    }

    @Override
    public void Display(){
        System.out.println(message);
    }

    @Override
    public void HandleInput(String input){
        try {
            int value = Integer.parseInt(input);
            setter.accept(value);
            finished = true;
        } catch (Exception e){
            System.out.println(invalidOptionMessage);
        }

    }

    @Override
    public boolean IsFinished(){
        return finished;
    }
}