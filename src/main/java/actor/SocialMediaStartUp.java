package main.java.actor;

import main.java.world.Location;

/**
 * SocialMediaStartUp.java
 * Package: main.java.actor
 * Description: Social Media is a subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class SocialMediaStartUp extends StartUp {

    public SocialMediaStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("SocialMedia");
    }
}
