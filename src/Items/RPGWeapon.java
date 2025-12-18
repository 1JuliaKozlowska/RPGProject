package Items;

public abstract class RPGWeapon {
    private WeaponProperties weaponProperties;

    protected RPGWeapon(){
        WeaponProperties.WeaponBuilder builder = WeaponProperties.builder(defaultID());
        setDefaults(builder);
        this.weaponProperties = builder.build();
    }
    protected String defaultID() { return this.getClass().getSimpleName().toLowerCase(); }
    protected abstract void setDefaults(WeaponProperties.WeaponBuilder builder);
    public WeaponProperties getWeaponProperties(){
        return weaponProperties;
    }
}
