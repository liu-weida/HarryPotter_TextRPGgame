package House;

import java.util.Random;

public class SortingHat {


    public static House getRandomHome() {
        Random random = new Random();
        int randomNumber = random.nextInt(4);
        switch (randomNumber) {
            case 0:
                return House.Hufflepuff;
            case 1:
                return House.Slytherin;
            case 2:
                return House.Gryffindor;
            case 3:
                return House.Ravenclaw;
            default:
                return null;
        }
    }
}

