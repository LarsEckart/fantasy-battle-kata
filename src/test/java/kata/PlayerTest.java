package kata;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.BDDMockito.given;
import static org.mockito.Mockito.mock;

public class PlayerTest {

    @Test
    void damageCalculationsWithMocks() {
        Inventory inventory = mock(Inventory.class);
        Equipment equipment = mock(Equipment.class);
        Weapon mainHand = mock(Weapon.class);
        Weapon offHand = mock(Weapon.class);
        Jewellery necklace = mock(Jewellery.class);
        Stats stats = mock(Stats.class);
        RareMob target = mock(RareMob.class);
        Armor armor = mock(Armor.class);
        DefensiveBuff defensiveBuff = mock(DefensiveBuff.class);

        given(inventory.getEquipment()).willReturn(equipment);
        given(equipment.getRightHand()).willReturn(mainHand);
        given(equipment.getLeftHand()).willReturn(offHand);
        given(equipment.getNecklace()).willReturn(necklace);
        given(mainHand.getBaseDamage()).willReturn(18);
        given(mainHand.getDamageModifier()).willReturn(3.5f);
        given(offHand.getDamageModifier()).willReturn(3.7f);
        given(offHand.getBaseDamage()).willReturn(15);
        given(necklace.getDamageModifier()).willReturn(2.9f);
        given(stats.getStrength()).willReturn(18);
        given(target.getArmor()).willReturn(armor);
        given(armor.getType()).willReturn(ArmorType.MAIL);
        given(armor.getDamageSoak()).willReturn(21);
        given(target.getBuffs()).willReturn(List.of(defensiveBuff));
        given(defensiveBuff.soakModifier()).willReturn(5.0f);
        Player player = new Player(inventory, stats);

        Damage damage = player.calculateDamage(target);

        assertEquals(431, damage.getAmount());
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
