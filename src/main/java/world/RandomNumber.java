package main.java.world;

import java.util.Random;

public final class RandomNumber {

    public static int getRandomBetween(int min, int max) {
        
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        return randomNumber;   
    }
}
