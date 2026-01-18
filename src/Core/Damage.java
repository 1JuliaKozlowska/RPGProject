package Core;

//klasa na damage
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

    public double getSelfDamageValue() {
        return selfDamageValue;
    }

    private int damageValue;
    private boolean spread;
    private int chanceToHit;
    private String attackerName;
    private double selfDamageValue;


    public Damage(int damageValue, boolean spread, int chanceToHit, String attackerName, double selfDamageValue){
        this.damageValue = damageValue;
        this.spread = spread;
        this.chanceToHit = chanceToHit;
        this.attackerName = attackerName;
        this.selfDamageValue = selfDamageValue;
    }


}
