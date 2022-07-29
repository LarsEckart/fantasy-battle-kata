package kata;

public class Equipment {

    private final Weapon rightHand;
    private final Weapon leftHand;
    private final Armor head;
    private final Armor chest;
    private final Armor feet;
    private final Jewellery necklace;
    // TODO add new jewellery (ring) that may be equipped
    // that may also add damage modifier

    public Equipment(Weapon rightHand, Weapon leftHand, Armor head, Armor chest, Armor feet, Jewellery necklace) {
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.head = head;
        this.chest = chest;
        this.feet = feet;
        this.necklace = necklace;
    }

    public Weapon getRightHand() {
        return rightHand;
    }

    public Weapon getLeftHand() {
        return leftHand;
    }

    public Armor getHead() {
        return head;
    }

    public Armor getChest() {
        return chest;
    }

    public Armor getFeet() {
        return feet;
    }

    public Jewellery getNecklace() {
        return necklace;
    }
}
