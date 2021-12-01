package main.java.world;

/**
 * Printer.java
 * Package: main.java.world
 * Description: This is a static utility class to retrieve random numbers.
 * 
 * @author James Covert
 * @version 1.0
 */
import java.util.Random;

public final class RandomNumber {

    /**
     * Description: This is a static method to retrieve.
     * int between two given ints.
     * 
     * @author James Covert
     * @version 1.0
     * @param min - min int
     * @param max - max int
     * @return int - randomly selected int between the two given ints
     */
    public static int getRandomBetween(int min, int max) {
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        return randomNumber;   
    }
}
