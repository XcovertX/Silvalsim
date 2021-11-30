package main.java.actor;

import main.java.world.Location;

/**
 * PhoneTechStartUp.java
 * Package: main.java.actor
 * Description: PhoneTech are a subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class PhoneTechStartUp extends StartUp {

    public PhoneTechStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("PhoneTech");
    }
}
