package Items;

import java.util.UUID;

public abstract class RPGArmor {
    private ArmorProperties armorProperties;

    protected RPGArmor(){
        ArmorProperties.ArmorBuilder builder = ArmorProperties.builder(defaultID());
        setDefaults(builder);
        this.armorProperties = builder.build();
    }
    protected String defaultID() { return this.getClass().getSimpleName().toLowerCase(); }
    protected abstract void setDefaults(ArmorProperties.ArmorBuilder builder);
    public ArmorProperties getArmorProperties(){
        return armorProperties;
    }
}
