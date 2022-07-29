package kata;

public class Player extends Target {

    private final Inventory inventory;
    private final Stats stats;

    Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    Damage calculateDamage(Target other) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private int getBaseDamage() {
        Equipment equipment = this.inventory.getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        return leftHand.getBaseDamage() +
                rightHand.getBaseDamage() +
                head.getBaseDamage() +
                feet.getBaseDamage() +
                chest.getBaseDamage();
    }

    private float getDamageModifier() {
        Equipment equipment = this.inventory.getEquipment();
        Item leftHand = equipment.getLeftHand();
        Item rightHand = equipment.getRightHand();
        Item head = equipment.getHead();
        Item feet = equipment.getFeet();
        Item chest = equipment.getChest();
        float strengthModifier = stats.getStrength() * 0.8f;
        return strengthModifier +
                leftHand.getDamageModifier() +
                rightHand.getDamageModifier() +
                head.getDamageModifier() +
                feet.getDamageModifier() +
                chest.getDamageModifier();
    }

    private int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof SimpleEnemy simpleEnemy) {
            float soakFromBuffs = ((float) simpleEnemy.getBuffs()
                    .stream()
                    .mapToDouble(Buff::soakModifier)
                    .sum()) + 1f;
            float strengthModifier;
            if (simpleEnemy.getArmor().getType() == ArmorType.CLOTH) {
                strengthModifier = stats.getStrength() * 0.1f;
            } else if (simpleEnemy.getArmor().getType() == ArmorType.PLATE) {
                strengthModifier = stats.getStrength() * 1.0f;
            } else {
                strengthModifier = stats.getStrength() * 0.4f;
            }
            soak = Math.round(simpleEnemy.getArmor().getDamageSoak() * (soakFromBuffs + strengthModifier));
        }
        return soak;
    }
}
