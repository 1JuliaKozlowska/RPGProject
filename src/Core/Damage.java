package Core;

public class Damage {
    public int getDamageValue() {
        return damageValue;
    }

    public boolean isSpread() {
        return spread;
    }

    public int getChanceToHit() {
        return chanceToHit;
    }

    public String getAttackerName() {
        return attackerName;
    }

    private int damageValue;
    private boolean spread;
    private int chanceToHit;
    private String attackerName;

    public Damage(int damageValue, boolean spread, int chanceToHit, String attackerName){
        this.damageValue = damageValue;
        this.spread = spread;
        this.chanceToHit = chanceToHit;
        this.attackerName = attackerName;
    }


}
