package Core;

import java.util.List;
import GameEntities.Character;
import GameEntities.Characters.*;

public class Player {
    private int money;
    private final Character[] teamCharacters = new Character[3];

    public void CreateNew(){
        this.money = 500;
        teamCharacters[0] = new Knight();
        teamCharacters[1] = new Archer();
        teamCharacters[2] = new Mage();
    }



    public Character[] getTeamCharacters() {
        return teamCharacters;
    }

    public Character GetCharacterByName(String name){
        for (Character c : teamCharacters){
            if (c != null && c.getName().equals(name)){
                return c;
            }
        }
        return null;
    }

    public int GetMoney()
    {
        return money;
    }

    public void pay(int amount){
        money -= amount;
    }


}
