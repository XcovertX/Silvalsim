package main.java.actor;

import main.java.world.Location;

/**
 * PhoneTechStartUp.java
 * Package: main.java.actor
 * Description: PhoneTech are a subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 */

public class PhoneTechStartUp extends StartUp {

    /**
     * Description: Phone Tech constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of startup
     * @param description - descr of startup
     * @param location - location of startup
     * @param techGiant - tg who owns the startup
     */
    public PhoneTechStartUp(String name, String description, 
            Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("PhoneTech");
    }
}
