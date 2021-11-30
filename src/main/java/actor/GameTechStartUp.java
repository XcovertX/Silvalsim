package main.java.actor;

import main.java.world.Location;

/**
 * GameTechStartUp.java
 * Package: main.java.actor
 * Description: GameTech are subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 */

public class GameTechStartUp extends StartUp {

    public GameTechStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("GameTech");
    }

}
