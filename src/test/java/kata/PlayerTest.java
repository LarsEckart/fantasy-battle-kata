package kata;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        RareMob target = mock(RareMob.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }

    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(
                new Equipment(
                        new CommonWeapon(null, 18, 3.5f),
                        new CommonWeapon(null, 15, 3.7f),
                        null,
                        null,
                        null,
                        new Jewellery(null, 2.9f)));
        Stats stats = new Stats(18);
        RareMob target = new RareMob(new CommonArmor(null, 21, ArmorType.MAIL));
        Player player = new Player(inventory, stats);

        Damage damage = player.calculateDamage(target);

        assertEquals(431, damage.getAmount());
    }
}
