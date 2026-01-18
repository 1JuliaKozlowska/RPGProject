package Core;

import Utils.MenuManager;
import Utils.UI.MainMenu;

import java.util.Scanner;

public class Game {
    //pola prywatne przechowujące informacje o grze
    private boolean on = false;
    private Player player;
    private int difficulty;
    private Scanner scanner;
    private MenuManager menuManager;

    //konstruktor gry. ustawia nowego gracza, poziom trudności i MenuManager odpowiedzialny za wyświetlanie UI i operowanie inputami z klawiatury
    public Game(){
        player = new Player();
        player.CreateNew();
        difficulty = 1;
        menuManager = new MenuManager(this);
        menuManager.Push(new MainMenu(menuManager));
    }

    //włącza gre
    public void Start()
    {
        on = true;
        gameLoop();
    }

    //pętla gry
    private void gameLoop(){
        while (on){
            menuManager.Show();
        }
    }

    //pobranie obiektu gracza
    public Player getPlayer(){
        return player;
    }

    //przerwanie pętli gry
    public void Close(){
        on = false;
    }

    //zwraca ustawiony poziom trudności gry
    public int getDifficulty(){
        return difficulty;
    }

    //ustawia poziom trudności gry na wartość od 1 do 10
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
