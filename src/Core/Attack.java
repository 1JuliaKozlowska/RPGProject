package Core;

import GameEntities.Character;

public class Attack {
    private Character character;
    private String name;
    private String description;
    public boolean spread = false;
    public int chanceToHit = 100;
    public double damageMultiplier = 1;

    public Attack(String name, String description, Character character){

    }

    public Damage damage(){
        return new Damage((int)(character.getAttackPoints() * damageMultiplier), spread, chanceToHit, character.getName());
    }


}
