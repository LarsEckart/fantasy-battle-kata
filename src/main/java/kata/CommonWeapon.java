package kata;

public class CommonWeapon implements Weapon {

    private final String name;
    private final int baseDamage;
    private final float damageModifier;

    public CommonWeapon(String name, int baseDamage, float damageModifier) {
        this.name = name;
        this.baseDamage = baseDamage;
        this.damageModifier = damageModifier;
    }

    @Override
    public int getBaseDamage() {
        return baseDamage;
    }

    @Override
    public float getDamageModifier() {
        return damageModifier;
    }
}
