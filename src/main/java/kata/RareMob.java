package kata;

import java.util.List;

public class RareMob extends Target {

    private final Armor armor;
    private final List<Buff> buffs;

    public RareMob(Armor armor, List<Buff> buffs) {
        this.armor = armor;
        this.buffs = buffs;
    }

    List<Buff> getBuffs() {
        return buffs;
    }

    Armor getArmor() {
        return this.armor;
    }
}
