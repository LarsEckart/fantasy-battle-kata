package kata;

public class Player extends Target {

    private final Inventory inventory;
    private final Stats stats;

    public Player(Inventory inventory, Stats stats) {
        this.inventory = inventory;
        this.stats = stats;
    }

    public Damage calculateDamage(Target other) {
        int baseDamage = getBaseDamage();
        float damageModifier = getDamageModifier();
        int totalDamage = Math.round(baseDamage * damageModifier);
        int soak = getSoak(other, totalDamage);
        return new Damage(Math.max(0, totalDamage - soak));
    }

    private int getBaseDamage() {
        Equipment equipment = this.inventory.getEquipment();
        Weapon rightHand = equipment.getRightHand();
        Weapon leftHand = equipment.getLeftHand();
        return rightHand.getBaseDamage() +
                leftHand.getBaseDamage();
    }

    private float getDamageModifier() {
        Equipment equipment = this.inventory.getEquipment();
        Weapon rightHand = equipment.getRightHand();
        Weapon leftHand = equipment.getLeftHand();
        Jewellery necklace = equipment.getNecklace();
        float strengthModifier = stats.getStrength() * 0.8f;
        return strengthModifier +
                rightHand.getDamageModifier() +
                leftHand.getDamageModifier() +
                necklace.getDamageModifier();
    }

    private int getSoak(Target other, int totalDamage) {
        int soak = 0;
        if (other instanceof Player) {
            // TODO: Not implemented yet
            //  Add friendly fire
            soak = totalDamage;
        } else if (other instanceof RareMob rareMob) {
            float soakFromBuffs = ((float) rareMob.getBuffs()
                    .stream()
                    .mapToDouble(DefensiveBuff::soakModifier)
                    .sum()) + 1f;
            float strengthModifier;
            if (rareMob.getArmor().getType() == ArmorType.CLOTH) {
                strengthModifier = stats.getStrength() * 0.1f;
            } else if (rareMob.getArmor().getType() == ArmorType.PLATE) {
                strengthModifier = stats.getStrength() * 1.0f;
            } else {
                strengthModifier = stats.getStrength() * 0.4f;
            }
            if (rareMob.getArmor() instanceof UncommonArmor) {
                soak = Math.round(rareMob.getArmor().getDamageSoak() * (soakFromBuffs + strengthModifier)) + 10;
            } else {
                soak = Math.round(rareMob.getArmor().getDamageSoak() * (soakFromBuffs + strengthModifier));
            }
        }
        return soak;
    }
}
