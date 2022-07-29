package kata;

public class CommonItem implements Item {

    private final String name;
    private final float damageModifier;

    public CommonItem(String name, float damageModifier) {
        this.name = name;
        this.damageModifier = damageModifier;
    }

    @Override
    public int getBaseDamage() {
        return 0;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}
