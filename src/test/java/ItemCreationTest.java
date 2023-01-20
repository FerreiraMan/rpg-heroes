import org.junit.jupiter.api.Test;
import tp1.Armor;
import tp1.Enum.ArmorTypeEnum;
import tp1.Enum.SlotEnum;
import tp1.Enum.WeaponTypeEnum;
import tp1.HeroAttribute;
import tp1.Weapon;
import static org.junit.jupiter.api.Assertions.*;

public class ItemCreationTest {
    final String DUMMY_WEAPON_NAME = "Weapon";
    final String DUMMY_ARMOR_NAME = "Armor";

    @Test // Test the correct creation of a Weapon.
    void testWeaponCreation(){
        // arrange
        Weapon weaponTest = new Weapon(DUMMY_WEAPON_NAME,1, SlotEnum.Weapon, WeaponTypeEnum.Sword,1);
        // act
        //assert
        assertEquals(DUMMY_WEAPON_NAME, weaponTest.getName());
        assertEquals(1, weaponTest.getRequiredLevel());
        assertEquals(SlotEnum.Weapon,weaponTest.getSlot());
        assertEquals(WeaponTypeEnum.Sword,weaponTest.getType());
    }

    @Test // Test the correct creation of a Armor.
    void testArmorCreation(){
        // arrange
        Armor armorTest = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Head, ArmorTypeEnum.Mail, new HeroAttribute(0,0,0));
        // act
        HeroAttribute armorAttributeTest = new HeroAttribute(0,0,0);
        //assert
        assertEquals(DUMMY_ARMOR_NAME, armorTest.getName());
        assertEquals(1, armorTest.getRequiredLevel());
        assertEquals(SlotEnum.Head,armorTest.getSlot());
        assertEquals(ArmorTypeEnum.Mail,armorTest.getType());
        assertEquals(armorAttributeTest, armorTest.getArmorAttribute());
    }
}
