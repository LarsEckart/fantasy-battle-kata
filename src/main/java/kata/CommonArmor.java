package kata;

public class CommonArmor implements Armor {

    private final String name;
    private final int soak;
    private final ArmorType type;

    public CommonArmor(String name, int soak, ArmorType type) {
        this.name = name;
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
