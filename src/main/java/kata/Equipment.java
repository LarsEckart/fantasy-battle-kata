package kata;

public class Equipment {

    // TODO add a ring item that may be equipped
    // that may also add damage modifier
    private final Item rightHand;
    private final Item leftHand;
    private final Item head;
    private final Item chest;
    private final Item feet;

    public Equipment(Item rightHand, Item leftHand, Item head, Item chest, Item feet) {
        this.rightHand = rightHand;
        this.leftHand = leftHand;
        this.head = head;
        this.chest = chest;
        this.feet = feet;
    }

    public Item getRightHand() {
        return rightHand;
    }

    public Item getLeftHand() {
        return leftHand;
    }

    public Item getHead() {
        return head;
    }

    public Item getChest() {
        return chest;
    }

    public Item getFeet() {
        return feet;
    }
}
