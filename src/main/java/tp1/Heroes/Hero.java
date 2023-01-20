package tp1.Heroes;
import tp1.*;
import tp1.Enum.ArmorTypeEnum;
import tp1.Enum.SlotEnum;
import tp1.Enum.WeaponTypeEnum;
import tp1.Exceptions.InvalidArmorException;
import tp1.Exceptions.InvalidWeaponException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;


public abstract class Hero {
    protected String name;
    protected int level;
    protected HeroAttribute levelAttributes;
    protected HashMap<SlotEnum, Item> equipment;
    protected List<WeaponTypeEnum> validWeaponTypes;
    protected List<ArmorTypeEnum> validArmorTypes;

    //Constructor for the Hero
    public Hero(String name) {
        this.name = name;
        this.level = 1;
        this.levelAttributes = new HeroAttribute(0,0,0);
        this.equipment = new HashMap<>();
        for(SlotEnum x: SlotEnum.values()){ //Loop in order to have each Slot as an entry with null values thus representing empty slots
            this.equipment.put(x, null);
        }
        this.validWeaponTypes = new ArrayList<>();
        this.validArmorTypes = new ArrayList<>();
    }

    public abstract void levelUp();
    public abstract void equip(Weapon a) throws InvalidWeaponException;
    public abstract void equip(Armor a) throws InvalidArmorException;

    public abstract int getDamagingAttribute();

    //Method to calculate the totalAttribute of a Hero because an Armor influences the total attributes of a Hero.
    public HeroAttribute totalAttributes() {
        HeroAttribute total = this.levelAttributes.clone();

        //Iterate over all equipment items
        for (Item itemPerSlot: this.equipment.values()){
            //Test if the current equip is of Type Armor and sum its properties to the total
            if (itemPerSlot != null && (itemPerSlot instanceof Armor)) {
                HeroAttribute itemAttributes = ((Armor) itemPerSlot).getArmorAttribute();
                total.increaseStrength(itemAttributes.getStrength());
                total.increaseDexterity(itemAttributes.getDexterity());
                total.increaseIntelligence(itemAttributes.getIntelligence());
            }
        }
        return total;
    }

    //Method to calculate the weapon Damage. This method returns 1 if the Hero has no equipped weapon.
    public int getWeaponDamage(){
        Weapon equipedWeapon = (Weapon) this.equipment.get(SlotEnum.Weapon);
        int weaponDamage = 0;
        if(equipedWeapon == null)   {
            weaponDamage = 1;
        }   else    {
            weaponDamage = equipedWeapon.getWeaponDamage();
        }
        return weaponDamage;
    }

    //Method to calculate the total damage of a Hero. Remember the damaging attribute is influenced by the an attribute (str, dex or int depending on the hero).
    //The getDamagingAttribute does this calculation.
    public double damage(){
        int weaponDamage = this.getWeaponDamage();
        int damagingAttribute = this.getDamagingAttribute();

        return (weaponDamage * (1 + (double) damagingAttribute/100));
    }

    @Override
    public String toString() {
        StringBuilder displayHero;
        displayHero = new StringBuilder();
        displayHero.append("Name:" + name);
        displayHero.append("  Class:" + this.getClass().getSimpleName());
        displayHero.append("  Level:" + level);
        displayHero.append("  Attributes:  " + levelAttributes.getStrength() + "Strength  "
                + levelAttributes.getDexterity() + "Dexterity  " + levelAttributes.getIntelligence() +
                "Intelligence");
        displayHero.append("  Damage:" + damage() + "\n");
        return displayHero.toString();
    }
}
