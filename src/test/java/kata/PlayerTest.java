package kata;

import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.Mockito;

import com.github.larseckart.tcr.SilentTestCommitRevertMainExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(SilentTestCommitRevertMainExtension.class)
public class PlayerTest {

//    @Disabled("Test is not finished yet")
    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Equipment mockEquipment = mock(Equipment.class);
        Weapon mockWeapon = mock(Weapon.class);
        Jewellery mockJewellery = mock(Jewellery.class);
        Armor mockTargetArmor = mock(Armor.class);
        given(inventory.getEquipment()).willReturn(mockEquipment);
        given(mockEquipment.getLeftHand()).willReturn(mockWeapon);
        given(mockEquipment.getRightHand()).willReturn(mockWeapon);
        given(mockWeapon.getBaseDamage()).willReturn(5);
        given(mockWeapon.getDamageModifier()).willReturn(1.0f);
        given(mockEquipment.getNecklace()).willReturn(mockJewellery);
        given(mockJewellery.getDamageModifier()).willReturn(1.0f);
        Stats stats = mock(Stats.class);
        given(stats.getStrength()).willReturn(2);
        RareMob target = mock(RareMob.class);
        given(target.getArmor()).willReturn(mockTargetArmor);
        given(mockTargetArmor.getType()).willReturn(ArmorType.MAIL);
        given(mockTargetArmor.getDamageSoak()).willReturn(1);

        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(43, damage.getAmount());
    }

    @Disabled("Test is not finished yet")
    @Test
    void damageCalculations() {
        Inventory inventory = new Inventory(null);
        Stats stats = new Stats(0);
        RareMob target = new RareMob(null, null);
        Damage damage = new Player(inventory, stats).calculateDamage(target);
        assertEquals(10, damage.getAmount());
    }
}
