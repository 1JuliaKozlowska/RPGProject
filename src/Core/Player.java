package Core;

import java.util.ArrayList;
import java.util.List;
import GameEntities.Character;
import GameEntities.Characters.Knight;

public class Player {
    private int money;

    private final List<Character> availableCharacters = new ArrayList<>();
    private final Character[] selectedCharacters = new Character[3];
    private final Inventory inventory = new Inventory();

    public void CreateNew(){
        this.money = 500;
        unlockCharacter(new Knight());
        SelectCharacter(0, GetCharacterByName("Knight"));
    }

    public void unlockCharacter(Character character){
        if (!hasCharacter(character.getName()))
        {
            availableCharacters.add(character);
        }
    }

    public boolean hasCharacter(String characterName) {
        return availableCharacters.stream().anyMatch(c -> characterName.equals(c.getName()));
    }

    public void SelectCharacter(int position, Character character){
        if (hasCharacter(character.getName())){
            selectedCharacters[position] = character;
        }
        else
        {
            //TODO: exception
        }
    }

    public Character[] getSelectedCharacters() {
        return selectedCharacters;
    }

    public List<Character> getAvailableCharacters(){
        return availableCharacters;
    }

    public Character GetCharacterByName(String name){
        return availableCharacters.stream().filter(c -> name.equals(c.getName())).findFirst().orElse(null);
    }

    public int GetMoney()
    {
        return money;
    }


}
