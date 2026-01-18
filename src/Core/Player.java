package Core;

import GameEntities.Character;
import GameEntities.Characters.*;

public class Player {
    //pola z posiadanymi przez gracza pieniędzmi i drużyną postaci
    private int money;
    private final Character[] teamCharacters = new Character[3];

    //tworzenie nowego gracza. na start gracz dostaje 500 pieniędzy i 3 postacie do drużyny
    public void CreateNew(){
        this.money = 500;
        teamCharacters[0] = new Knight();
        teamCharacters[1] = new Archer();
        teamCharacters[2] = new Mage();
    }

    //zwraca postacie w drużynie gracza
    public Character[] getTeamCharacters() {
        return teamCharacters;
    }

    //zwraca pieniądze gracza
    public int GetMoney()
    {
        return money;
    }

    //zabiera pieniądze graczowi
    public void pay(int amount){
        money -= amount;
    }

    //przyznaje pieniądze graczowi
    public void reward(int amount){
        money += amount;
    }


}
