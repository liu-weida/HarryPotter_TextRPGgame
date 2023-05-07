package House;


import org.junit.jupiter.api.Test;

import static org.junit.Assert.*;

public class SortingHatTest {

    @Test
    public void testGetRandomHome() {
        for (int i = 0; i < 100; i++) {
            House house = SortingHat.getRandomHome();
            assertNotNull(house);
            assertTrue(house == House.Hufflepuff ||
                    house == House.Slytherin ||
                    house == House.Gryffindor ||
                    house == House.Ravenclaw);
        }
    }

}

