import org.junit.jupiter.api.Test;
import tp1.Heroes.Warrior;

import static org.junit.jupiter.api.Assertions.*;

public class DisplayTest {
    final String DUMMY_HERO_NAME = "Name";

    //TEST TO SEE THE DISPLAY TEMPLATE. THIS CODE VERIFIES IF THE DISPLAY CONTAINS THE FOLLOWING STRINGS.

    @Test
    void testDisplay(){
        // arrange
        Warrior w = new Warrior(DUMMY_HERO_NAME);
        String displayHero = w.toString();

        // act
        Boolean cond1 = displayHero.contains("Name:");
        Boolean cond2 = displayHero.contains("Class:");
        Boolean cond3 = displayHero.contains("Level:");
        Boolean cond4 = displayHero.contains("Attributes:");
        Boolean cond5 = displayHero.contains("Strength");
        Boolean cond6 = displayHero.contains("Dexterity");
        Boolean cond7 = displayHero.contains("Intelligence");
        Boolean cond8 = displayHero.contains("Damage:");

        //assert
        assertEquals(true,cond1);
        assertEquals(true,cond2);
        assertEquals(true,cond3);
        assertEquals(true,cond4);
        assertEquals(true,cond5);
        assertEquals(true,cond6);
        assertEquals(true,cond7);
        assertEquals(true,cond8);
    }
}
