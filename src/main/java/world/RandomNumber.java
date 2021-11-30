package main.java.world;

/**
 * Printer.java
 * Package: main.java.world
 * Description: This is a static utility class to retrieve random numbers.
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

import java.util.Random;

public final class RandomNumber {

    public static int getRandomBetween(int min, int max) {
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        return randomNumber;   
    }
}
