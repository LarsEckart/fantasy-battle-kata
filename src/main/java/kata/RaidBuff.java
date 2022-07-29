package kata;

public class RaidBuff implements Buff {

    private float soak;

    public RaidBuff(float soak) {
        this.soak = soak;
    }

    @Override
    public float soakModifier() {
        return soak;
    }
}
