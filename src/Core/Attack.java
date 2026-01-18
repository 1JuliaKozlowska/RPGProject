package Core;

import GameEntities.Character;

//klasa na ataki postaci. każda postać ma atak normalny oraz specjalny
public class Attack {
    private Character character;

    public String getName() {
        return name;
    }

    public String getDescription() {
        return description;
    }

    private String name;
    private String description;
    public boolean spread = false;
    public int chanceToHit = 100;
    public double damageMultiplier = 1;
    public double selfDamageValue = 0;

    public Attack(String name, String description, Character character){
        this.name = name;
        this.description = description;
        this.character = character;
    }

    public Damage damage(){
        return new Damage((int)(character.getAttackPoints() * damageMultiplier), spread, chanceToHit, character.getName(), selfDamageValue);
    }


}
