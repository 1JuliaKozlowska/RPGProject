package Items;

import java.util.UUID;

public abstract class RPGRing {
    private RingProperties ringProperties;

    protected RPGRing(){
        RingProperties.RingBuilder builder = RingProperties.builder(defaultID());
        setDefaults(builder);
        this.ringProperties = builder.build();
    }
    protected String defaultID() { return this.getClass().getSimpleName().toLowerCase(); }
    protected abstract void setDefaults(RingProperties.RingBuilder builder);
    public RingProperties getRingProperties(){
        return ringProperties;
    }
}
