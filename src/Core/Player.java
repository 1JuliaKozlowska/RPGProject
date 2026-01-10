package Core;

import java.util.ArrayList;
import java.util.List;
import GameEntities.Character;
import GameEntities.Characters.Knight;

public class Player {
    private int money;

    private final List<Character> availableCharacters = new ArrayList<>();
    private final Inventory inventory = new Inventory();

    public void CreateNew(){
        this.money = 500;
        unlockCharacter(new Knight());
    }

    public void unlockCharacter(Character character){
        if (!hasCharacter(character.getName())){
            availableCharacters.add(character);
        }
    }

    public boolean hasCharacter(String characterName) {
        return availableCharacters.stream().anyMatch(c -> characterName.equals(c.getName()));
    }


}
