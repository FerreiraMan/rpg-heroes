package tp1;

public class HeroAttribute {
    private int strength;
    private int dexterity;
    private int intelligence;

    public HeroAttribute(int strength, int dexterity, int intelligence) {
        this.strength = strength;
        this.dexterity = dexterity;
        this.intelligence = intelligence;
    }
    public HeroAttribute(HeroAttribute objCopy){
        this.strength = objCopy.strength;
        this.dexterity = objCopy.dexterity;
        this.intelligence = objCopy.intelligence;
    }

    public void increaseStrength (int amount) {

        strength += amount;
    }
    public void increaseDexterity (int amount) {

        dexterity += amount;
    }
    public void increaseIntelligence (int amount) {
        intelligence += amount;
    }
    public int getStrength() {

        return strength;
    }
    public int getDexterity() {

        return dexterity;
    }
    public int getIntelligence() {

        return intelligence;
    }

    public HeroAttribute clone(){

        return new HeroAttribute(this);
    }

    // Method created in order to test the correct incrementation of the attributes when leveling up.
    // The equals method enables us to compare the attributes.
    // Please see the test 'testLevelingUpAttributes' in each 'Heroclass'Test folder.
    public boolean equals(Object otherObj) {
        if (otherObj == null || !(otherObj instanceof HeroAttribute)) {
            return false;
        }
        HeroAttribute otherHeroAttribute = (HeroAttribute) otherObj;
        return this.strength == otherHeroAttribute.strength
                && this.dexterity == otherHeroAttribute.dexterity
                && this.intelligence == otherHeroAttribute.intelligence;
    }
}
