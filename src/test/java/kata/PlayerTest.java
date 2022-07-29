package kata;

import java.util.List;

import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;

import com.github.larseckart.tcr.SilentTestCommitRevertMainExtension;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

@ExtendWith(SilentTestCommitRevertMainExtension.class)
public class PlayerTest {

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
        DefensiveBuff mockDefensiveBuff = mock(DefensiveBuff.class);
        given(target.getBuffs()).willReturn(List.of(mockDefensiveBuff, mockDefensiveBuff));
        given(mockDefensiveBuff.soakModifier()).willReturn(0.2f, 0.3f);
        given(target.getArmor()).willReturn(mockTargetArmor);
        given(mockTargetArmor.getType()).willReturn(ArmorType.MAIL);
        given(mockTargetArmor.getDamageSoak()).willReturn(4);

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(28, damage.getAmount());
    }

    @Test
    void damageCalculations() {
        Equipment equipment = new Equipment(
                new CommonWeapon("axe", 5, 1.0f),
                new CommonWeapon("hammer", 5, 1.0f),
                null,
                null,
                null,
                new Jewellery("necklace", 1.0f));
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(2);
        RareMob target = new RareMob(
                new CommonArmor("anything", 4, ArmorType.MAIL),
                List.of(new DefensiveBuff(0.2f), new DefensiveBuff(0.3f)));

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(28, damage.getAmount());
    }

    @Test
    void damageCalculationsWithRings() {
        Jewellery ring1 = new Jewellery("Red Diamond Ring", 0.5f);
        Jewellery ring2 = new Jewellery("Blue Diamond Ring", 0.7f);
        Equipment equipment = new Equipment(
                new CommonWeapon("axe", 5, 1.0f),
                new CommonWeapon("hammer", 5, 1.0f),
                null,
                null,
                null,
                new Jewellery("necklace", 1.0f),
                ring1, ring2);
        Inventory inventory = new Inventory(equipment);
        Stats stats = new Stats(2);
        RareMob target = new RareMob(
                new CommonArmor("anything", 4, ArmorType.MAIL),
                List.of(new DefensiveBuff(0.2f), new DefensiveBuff(0.3f)));

        Damage damage = new Player(inventory, stats).calculateDamage(target);

        assertEquals(28, damage.getAmount());
    }
}
