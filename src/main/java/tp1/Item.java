package tp1;
import tp1.Enum.SlotEnum;

public abstract class Item {
    private String name;
    private int requiredLevel;
    private SlotEnum slot;

    public Item(String name, int requiredLevel, SlotEnum slot) {
        this.name = name;
        this.requiredLevel = requiredLevel;
        this.slot = slot;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getRequiredLevel() {
        return requiredLevel;
    }

    public void setRequiredLevel(int requiredLevel) {
        this.requiredLevel = requiredLevel;
    }

    public SlotEnum getSlot() {
        return slot;
    }

    public void setSlot(SlotEnum slot) {
        this.slot = slot;
    }
}
