package tp1.Heroes;
import tp1.*;
import tp1.Enum.ArmorTypeEnum;
import tp1.Enum.WeaponTypeEnum;
import tp1.Exceptions.InvalidArmorException;
import tp1.Exceptions.InvalidWeaponException;

import java.util.Arrays;

public class Warrior extends Hero {
    public Warrior(String name){
        super(name);
        this.levelAttributes = new HeroAttribute(5,2,1);                            //Initial attributes for this class of Hero.
        validWeaponTypes = Arrays.asList(WeaponTypeEnum.Axe, WeaponTypeEnum.Hammer, WeaponTypeEnum.Sword);   //Valid weapons for this class of Hero.
        validArmorTypes = Arrays.asList(ArmorTypeEnum.Mail, ArmorTypeEnum.Plate);                            //Valid armor for this class of Hero.
    }
    //Method to calculate the incrementation when leveling up
    public void levelUp() {
        level++;
        levelAttributes.increaseStrength(3);
        levelAttributes.increaseDexterity(2);
        levelAttributes.increaseIntelligence(1);
    }
    //Equipping the weapon and armor and the respective exceptions.
    @Override
    public void equip(Weapon weapon) throws InvalidWeaponException {
        boolean has_valid_type = validWeaponTypes.contains(weapon.getType());
        boolean has_valid_level = weapon.getRequiredLevel() <= this.level;
        if(!has_valid_type || !has_valid_level){
            throw new InvalidWeaponException(has_valid_type, has_valid_level);
        }
        this.equipment.put(weapon.getSlot(), weapon);
    }

    @Override
    public void equip(Armor armor) throws InvalidArmorException {
        boolean has_valid_type = validArmorTypes.contains(armor.getType());
        boolean has_valid_level = armor.getRequiredLevel() <= this.level;
        if(!has_valid_type || !has_valid_level){
            throw new InvalidArmorException(has_valid_type, has_valid_level);
        }
        this.equipment.put(armor.getSlot(), armor);
    }
    //Method to calculate the damaging attribute of this Hero class. In this case its influenced by strength.
    @Override
    public int getDamagingAttribute() {
        return this.totalAttributes().getStrength();
    }
}
