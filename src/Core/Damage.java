package Core;

public class Damage {
    private int meleeValue;
    private int rangedValue;
    private int magicValue;
    private int summonValue;

    public Damage(int meleeValue, int rangedValue, int magicValue, int summonValue){
        this.meleeValue = meleeValue;
        this.rangedValue = rangedValue;
        this.magicValue = magicValue;
        this.summonValue = summonValue;
    }

    public int getMeleeValue() {
        return meleeValue;
    }

    public int getRangedValue() {
        return rangedValue;
    }

    public int getMagicValue() {
        return magicValue;
    }

    public int getSummonValue() {
        return summonValue;
    }
}
