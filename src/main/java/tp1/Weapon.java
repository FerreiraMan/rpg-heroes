package tp1;
import tp1.Enum.SlotEnum;
import tp1.Enum.WeaponTypeEnum;

public class Weapon extends Item {
    private WeaponTypeEnum type;
    private int weaponDamage;

    public Weapon(String name, int requiredLevel, SlotEnum slot, WeaponTypeEnum type, int weaponDamage) {
        super(name, requiredLevel, slot);
        this.type = type;
        this.weaponDamage = weaponDamage;
    }

    public WeaponTypeEnum getType() {
        return type;
    }

    public void setType(WeaponTypeEnum type) {
        this.type = type;
    }

    public int getWeaponDamage() {
        return weaponDamage;
    }

    public void setWeaponDamage(int weaponDamage) {
        this.weaponDamage = weaponDamage;
    }
}
