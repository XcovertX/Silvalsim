/*
 * This Java source file was generated by the Gradle 'init' task.
 */
package main.java.start;

import main.java.world.Cycle;
import main.java.world.World;

public class Silvalsim extends Thread {
    
    public String getGreeting() {
        return "Welcome to Silvalsim.";
    }

    public static void main(String[] args) {
        
        System.out.println(new Silvalsim().getGreeting());
        
        World world = new World();
        Thread cycleThread = new Thread(new Cycle(world));
        cycleThread.setName("Cycle_Thread");
        cycleThread.start();
    }
}
