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

    /**
     * Description: Game Tech constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of startup
     * @param description - descr of startup
     * @param location - location of startup
     * @param techGiant - tg who owns the startup
     */
    public GameTechStartUp(String name, String description, 
            Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("GameTech");
    }

}
