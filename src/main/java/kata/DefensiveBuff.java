package kata;

public class DefensiveBuff {

    private final float soak;

    public DefensiveBuff(float soak) {
        this.soak = soak;
    }

    public float soakModifier() {
        return soak;
    }
}
