package kata;

public class Inventory {

    private final Equipment equipment;
    // TODO: besides equipped items, players can have a bag which can contain charms, which can be offensive or defensive
    //  "Forked Charm", damage modifier: 2.0
    //  "Stalwart Charm", soak modifier: 8.5

    public Inventory(Equipment equipment) {
        this.equipment = equipment;
    }

    public Equipment getEquipment() {
        return equipment;
    }
}
