package Core;

import Enums.UIModes;

import java.util.Scanner;

public class Game {

    private boolean on;
    private Player player;
    private int difficulty;
    private Scanner scanner;
    private UIModes currentUI;

    public Game(){
        player = new Player();
        player.CreateNew();
        on = true;
        difficulty = 1;
    }

    private void gameLoop(){
        while (on){

        }
    }


}
