import org.junit.jupiter.api.Test;
import tp1.Armor;
import tp1.Enum.ArmorTypeEnum;
import tp1.Enum.SlotEnum;
import tp1.Enum.WeaponTypeEnum;
import tp1.Exceptions.InvalidArmorException;
import tp1.Exceptions.InvalidWeaponException;
import tp1.HeroAttribute;
import tp1.Heroes.Mage;
import tp1.Weapon;

import static org.junit.jupiter.api.Assertions.*;

public class MageTest {
    final String DUMMY_HERO_NAME = "Name";
    final String DUMMY_WEAPON_NAME = "Weapon";
    final String DUMMY_ARMOR_NAME = "Armor";

    // ---------------TESTING ATTRIBUTES AT LEVEL 1 AND BY LEVELING UP---------------

    @Test // Test the correct attributes at Level 1.
    void testLevelOneAttributes(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);

        // act
        HeroAttribute levelOneAttri = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(1,1,8);
        boolean compareTwoResults = levelOneAttri.equals(expected);
        assertEquals(true, compareTwoResults);
    }

    @Test // Test the correct incrementation of the attributes when leveling up.
    void testLevelingUpAttributes(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        w.levelUp(); // set the Hero level to 2
        // act
        HeroAttribute levelTwoAttri = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(2,2,13);
        boolean compareTwoResults = levelTwoAttri.equals(expected);
        assertEquals(true, compareTwoResults);
    }

    // ---------------TESTING EXCEPTIONS OF EQUIPPING ARMOR AND WEAPON---------------
    @Test
    void testCantEquipWeaponWithHigherLevel(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        w.levelUp(); // set the hero level to 2
        Weapon weapon = new Weapon(DUMMY_WEAPON_NAME, 3, SlotEnum.Weapon, WeaponTypeEnum.Wand, 10);
        // act

        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class, () -> {
            w.equip(weapon);
        });

        // assert
        String expectedMessage = "Your level is too low for this equipment!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    @Test
    void testCantEquipInvalidWeapon(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        Weapon weapon = new Weapon(DUMMY_WEAPON_NAME, 1, SlotEnum.Weapon, WeaponTypeEnum.Sword, 1);
        // act
        InvalidWeaponException exception = assertThrows(InvalidWeaponException.class, () -> {
            w.equip(weapon);
        });
        // assert
        String expectedMessage = "This Hero class cannot equip this weapon!";
        String actualMessage = exception.getMessage();

        assertEquals(expectedMessage, actualMessage);
    }

    // ---------------TESTING DAMAGE REGARDING WEAPON AND WEAPON + ARMOR ---------------

    @Test
    void testDamageWarriorLevel1WithoutWeapons(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        // act
        double damageValue = w.damage();
        // assert
        double expected = 1.08;
        assertEquals(expected, damageValue);
    }

    @Test
    void testDamageMageLevel2WithWeapon() throws InvalidWeaponException {
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        w.levelUp(); // set the Hero level to 2
        Weapon weapon = new Weapon(DUMMY_WEAPON_NAME, 2, SlotEnum.Weapon, WeaponTypeEnum.Wand, 10);
        w.equip(weapon);
        // act
        double damageValue = w.damage();

        // assert
        double expected = 10 * (1 + (double) 13/100);
        assertEquals(expected, damageValue);
    }

    @Test
    void testReplacingWeapon() throws InvalidWeaponException {
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        w.levelUp(); // set the Hero level to 2
        Weapon weapon1 = new Weapon(DUMMY_WEAPON_NAME, 2, SlotEnum.Weapon, WeaponTypeEnum.Wand, 10);
        w.equip(weapon1);
        Weapon weapon2 = new Weapon(DUMMY_WEAPON_NAME, 2, SlotEnum.Weapon, WeaponTypeEnum.Wand, 8);
        w.equip(weapon2);

        // act
        double damageValue = w.damage();

        // assert
        double expected = 8 * (1 + (double) 13/100);
        assertEquals(expected, damageValue);
    }

    @Test
    void testDamageWeaponAndArmor() throws InvalidWeaponException, InvalidArmorException {
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        Weapon weapon = new Weapon(DUMMY_WEAPON_NAME, 1, SlotEnum.Weapon, WeaponTypeEnum.Wand, 10);
        Armor armor = new Armor(DUMMY_ARMOR_NAME, 1, SlotEnum.Head, ArmorTypeEnum.Cloth, new HeroAttribute(1,1,1));
        w.equip(weapon);
        w.equip(armor);

        // act
        double damageValue = w.damage();

        // assert
        double expected = 10 * (1 + (double) (1+8)/100);
        assertEquals(expected, damageValue);
    }

    // ---------------TESTING ATTRIBUTES REGARDING ARMOR---------------

    @Test
    void testTotalAttributesWithNoEquip(){
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);

        // act
        HeroAttribute totalAttributes = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(1,1,8);
        boolean compareTwoResults = totalAttributes.equals(expected);
        assertEquals(true, compareTwoResults);
    }

    @Test
    void testTotalAttributesWithOneArmor() throws InvalidArmorException {
        // arrange
        Mage w = new Mage(DUMMY_HERO_NAME);
        Armor armor = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Head, ArmorTypeEnum.Cloth, new HeroAttribute (1,1,1));
        w.equip(armor);

        // act
        HeroAttribute totalAttributes = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(2,2,9);
        boolean compareTwoResults = totalAttributes.equals(expected);
        assertEquals(true, compareTwoResults);
    }

    @Test
    void testTotalAttributesWithTwoArmor() throws InvalidArmorException {
        Mage w = new Mage(DUMMY_HERO_NAME);
        Armor armor1 = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Head, ArmorTypeEnum.Cloth, new HeroAttribute (1,1,1));
        Armor armor2 = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Legs, ArmorTypeEnum.Cloth, new HeroAttribute (1,1,1));
        w.equip(armor1);
        w.equip(armor2);

        // act
        HeroAttribute totalAttributes = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(3,3,10);
        boolean compareTwoResults = totalAttributes.equals(expected);
        assertEquals(true, compareTwoResults);
    }

    @Test
    void testTotalAttributesReplacingArmor() throws InvalidArmorException {
        Mage w = new Mage(DUMMY_HERO_NAME);
        Armor armor1 = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Head, ArmorTypeEnum.Cloth, new HeroAttribute (1,1,1));
        Armor armor2 = new Armor(DUMMY_ARMOR_NAME,1,SlotEnum.Head, ArmorTypeEnum.Cloth, new HeroAttribute (2,2,2));
        w.equip(armor1);
        w.equip(armor2);

        // act
        HeroAttribute totalAttributes = w.totalAttributes();

        //assert
        HeroAttribute expected = new HeroAttribute(3,3,10);
        boolean compareTwoResults = totalAttributes.equals(expected);
        assertEquals(true, compareTwoResults);
    }
}