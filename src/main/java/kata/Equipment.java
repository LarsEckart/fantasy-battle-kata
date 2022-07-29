package kata;

public class Equipment {

    private final Weapon rightHand;
    private final Weapon leftHand;
    private final Armor head;
    private final Armor chest;
    private final Armor feet;
    private final Jewellery necklace;
    private final Jewellery ring1;
    private final Jewellery ring2;
    // TODO add new jewellery (2x ring) that may be equipped and contributed to damage modifier like necklace does.

    public Equipment(Weapon rightHand, Weapon leftHand, Armor head, Armor chest, Armor feet, Jewellery necklace) {
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.head = head;
        this.chest = chest;
        this.feet = feet;
        this.necklace = necklace;
        this.ring1 = null;
        this.ring2 = null;
    }

    public Equipment(
            Weapon rightHand,
            Weapon leftHand,
            Armor head,
            Armor chest,
            Armor feet,
            Jewellery necklace,
            Jewellery ring1,
            Jewellery ring2) {
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.head = head;
        this.chest = chest;
        this.feet = feet;
        this.necklace = necklace;
        this.ring1 = ring1;
        this.ring2 = ring2;
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
