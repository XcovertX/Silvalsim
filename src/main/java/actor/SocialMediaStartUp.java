package main.java.actor;

import main.java.world.Location;

/**
 * SocialMediaStartUp.java
 * Package: main.java.actor
 * Description: Social Media is a subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 */

public class SocialMediaStartUp extends StartUp {

    /**
     * Description: Social Media constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of startup
     * @param description - descr of startup
     * @param location - location of startup
     * @param techGiant - tg who owns the startup
     */
    public SocialMediaStartUp(String name, String description, 
            Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("SocialMedia");
    }
}
