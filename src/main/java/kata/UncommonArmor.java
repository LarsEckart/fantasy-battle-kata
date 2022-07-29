package kata;

public class UncommonArmor implements Armor {

    private final int soak;
    private final ArmorType type;

    public UncommonArmor(int soak, ArmorType type) {
        this.soak = soak;
        this.type = type;
    }

    @Override
    public int getDamageSoak() {
        return soak;
    }

    @Override
    public ArmorType getType() {
        return type;
    }
}
