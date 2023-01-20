package tp1;
import tp1.Enum.ArmorTypeEnum;
import tp1.Enum.SlotEnum;

public class Armor extends Item {
    private ArmorTypeEnum type;
    private HeroAttribute ArmorAttribute; //Armor can influence the three attributes of a Hero, therefore it is of type HeroAttribute.

    public Armor(String name, int requiredLevel, SlotEnum slot, ArmorTypeEnum type, HeroAttribute ArmorAttribute){
        super(name,requiredLevel,slot);
        this.type = type;
        this.ArmorAttribute = ArmorAttribute;
    }

    public ArmorTypeEnum getType() {

        return type;
    }

    public void setType(ArmorTypeEnum type) {

        this.type = type;
    }

    public HeroAttribute getArmorAttribute() {

        return ArmorAttribute;
    }

    public void setArmorAttribute(HeroAttribute ArmorAttribute) {

        this.ArmorAttribute = ArmorAttribute;
    }
}
