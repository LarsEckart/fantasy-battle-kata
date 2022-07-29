package kata;

public class Jewellery {

    private final String name;
    private final float damageModifier;

    public Jewellery(String name, float damageModifier) {
        this.name = name;
        this.damageModifier = damageModifier;
    }

    public float getDamageModifier() {
        return damageModifier;
    }
}
