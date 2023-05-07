package Wand;

import org.junit.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;


import static org.junit.jupiter.api.Assertions.*;

class WandTest {

    @Test
    void testGetCore() {
        Wand wand = Wand.chooseWand(1);
        assertEquals(Core.PHOENIX_FEATHER, wand.getCore());
    }

    @Test
    void testChooseWand() {
        Wand wand1 = Wand.chooseWand(1);
        Wand wand2 = Wand.chooseWand(2);
        Wand wand3 = Wand.chooseWand(3);
        Wand wand4 = Wand.chooseWand(4);

        assertEquals("Holly", wand1.getWood());
        assertEquals(Core.PHOENIX_FEATHER, wand1.getCore());
        assertEquals(11, wand1.getSize());
        assertEquals("Holly  PHOENIX_FEATHER   11 inches", wand1.toString());

        assertEquals("Holly", wand2.getWood());
        assertEquals(Core.DRAGON_HEARTSTRING, wand2.getCore());
        assertEquals(10, wand2.getSize());
        assertEquals("Holly  DRAGON_HEARTSTRING   10 inches", wand2.toString());

        assertEquals("Redwood", wand3.getWood());
        assertEquals(Core.PHOENIX_FEATHER, wand3.getCore());
        assertEquals(11, wand3.getSize());
        assertEquals("Redwood  PHOENIX_FEATHER   11 inches", wand3.toString());

        assertEquals("Redwood", wand4.getWood());
        assertEquals(Core.DRAGON_HEARTSTRING, wand4.getCore());
        assertEquals(10, wand4.getSize());
        assertEquals("Redwood  DRAGON_HEARTSTRING   10 inches", wand4.toString());
    }

    @Test
    void testGetWand() {
        Wand.getWand();
    }

    @Test
    void testToString() {
        Wand wand = Wand.chooseWand(1);
        assertEquals("Wand: Holly  PHOENIX_FEATHER   11 inches", wand.toString());
    }

    @Test
    public void testGetPharmacyBonus() {
        assertEquals(10, Wand.getPharmacyBonus());
    }

    @Test
    public void testGetAttackBonus() {
        assertEquals(5, Wand.getAttackBonus());
    }

    @Test
    public void testGetDefenseBonus() {
        Wand wand1 = Wand.chooseWand(1);
        Wand wand3 = Wand.chooseWand(3);
        assertEquals(5, wand1.getDefenseBonus());
        assertEquals(0, wand3.getDefenseBonus());
    }

    @Test
    public void testGetPreciseBonus() {
        Wand wand2 = Wand.chooseWand(2);
        Wand wand4 = Wand.chooseWand(4);
        assertEquals(5, wand2.getPreciseBonus());
        assertEquals(10, wand4.getPreciseBonus());
    }



}
