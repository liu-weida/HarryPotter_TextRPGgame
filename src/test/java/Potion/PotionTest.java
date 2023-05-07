package Potion;


import org.junit.Test;

import static org.junit.jupiter.api.Assertions.*;

class PotionTest {

    @Test
    void testGetName() {
        Potion potion = Potion.choosePotion(1);
        assertEquals("Invigoration Draught", potion.getName());
    }

    @Test
    void testChoosePotion() {
        Potion potion1 = Potion.choosePotion(1);
        Potion potion2 = Potion.choosePotion(2);
        Potion potion3 = Potion.choosePotion(3);
        Potion potion4 = Potion.choosePotion(4);

        assertEquals("Invigoration Draught", potion1.getName());
        assertEquals(20, potion1.getAddHP());
        assertEquals("Invigoration Draught", potion1.toString());

        assertEquals("Bruise Bealing", potion2.getName());
        assertEquals(40, potion2.getAddHP());
        assertEquals("Bruise Bealing", potion2.toString());

        assertEquals("Blood Replenishing", potion3.getName());
        assertEquals(60, potion3.getAddHP());
        assertEquals("Blood Replenishing", potion3.toString());

        assertEquals("Skele Gro", potion4.getName());
        assertEquals(100, potion4.getAddHP());
        assertEquals("Skele Gro", potion4.toString());
    }

    @Test
    void testToString() {
        Potion potion = Potion.choosePotion(1);
        assertEquals("Invigoration Draught", potion.toString());
    }
}
