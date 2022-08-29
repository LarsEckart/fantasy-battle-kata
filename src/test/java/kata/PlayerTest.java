package kata;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Stats stats = mock(Stats.class);
        given(stats.getStrength()).willReturn(18);
        RareMob target = mock(RareMob.class);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(431, damage.getAmount());
    }

    @Disabled("Test is not finished yet")
    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(null);
        Stats stats = new Stats(18);
        RareMob target = new RareMob(null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(431, damage.getAmount());
    }
}
