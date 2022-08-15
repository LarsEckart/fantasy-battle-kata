package kata;

import java.util.List;

public class RareMob extends Target {

    private final Armor armor;
    private final List<DefensiveBuff> buffs;

    public RareMob(Armor armor) {
        this.armor = armor;
        this.buffs = List.of(new DefensiveBuff(5.0f));
    }

    public List<DefensiveBuff> getBuffs() {
        return buffs;
    }

    public Armor getArmor() {
        return this.armor;
    }
}
