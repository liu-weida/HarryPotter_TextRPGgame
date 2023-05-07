package House;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class HouseTest {

    @Test
    void testGetPharmacyBonus() {
        assertEquals(0, House.getPharmacyBonus());
    }

    @Test
    void testGetAttackBonus() {
        assertEquals(0, House.Slytherin.getAttackBonus());
    }

    @Test
    void testGetDefenseBonus() {
        assertEquals(0, House.Gryffindor.getDefenseBonus());
    }

    @Test
    void testGetPreciseBonus() {
        assertEquals(10, House.Ravenclaw.getPreciseBonus());
    }

    @Test
    void testToString() {
        assertEquals("Hufflepuff", House.Hufflepuff.toString());
        assertEquals("Slytherin", House.Slytherin.toString());
        assertEquals("Gryffindor", House.Gryffindor.toString());
        assertEquals("Ravenclaw", House.Ravenclaw.toString());
    }
}
