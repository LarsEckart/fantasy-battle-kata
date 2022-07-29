package kata;

import java.util.List;

public class RareMob extends Target {

    private final Armor armor;
    private final List<DefensiveBuff> buffs;

    public RareMob(Armor armor, List<DefensiveBuff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    public List<DefensiveBuff> getBuffs() {
        return buffs;
    }

    public Armor getArmor() {
        return this.armor;
    }
}
