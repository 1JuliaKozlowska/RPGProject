package Core;

import Enums.UIModes;
import Utils.MenuManager;
import Utils.UI.MainMenu;

import java.util.Scanner;

public class Game {

    private boolean on = false;
    private Player player;
    private int difficulty;
    private Scanner scanner;
    private UIModes currentUI;
    private MenuManager menuManager;

    public Game(){
        player = new Player();
        player.CreateNew();
        difficulty = 1;
        menuManager = new MenuManager(this);
        menuManager.Push(new MainMenu(menuManager));
    }

    public void Start()
    {
        on = true;
        gameLoop();
    }

    private void gameLoop(){
        while (on){
            menuManager.Show();
        }
    }

    public Player getPlayer(){
        return player;
    }

    public void Close(){
        on = false;
    }

    public int getDifficulty(){
        return difficulty;
    }

    public void setDifficulty(int value){
        if (value < 1){
            difficulty = 1;
        } else if (value > 10) {
            difficulty = 10;
        } else {
            difficulty = value;
        }
    }


}
