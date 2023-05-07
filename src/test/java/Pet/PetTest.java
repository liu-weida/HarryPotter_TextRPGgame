package Pet;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

public class PetTest {
    @Test
    public void testChoosePet() {
        Assertions.assertEquals(Pet.OWL, Pet.choosePet(1));
        Assertions.assertEquals(Pet.RAT, Pet.choosePet(2));
        Assertions.assertEquals(Pet.CAT, Pet.choosePet(3));
        Assertions.assertEquals(Pet.TOAD, Pet.choosePet(4));
        Assertions.assertNull(Pet.choosePet(5));
    }

}
