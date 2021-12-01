package main.java.actor;

import main.java.world.Location;

/**
 * OperaingSystemsStartUp.java
 * Package: main.java.actor
 * Description: Operating Systems are subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 */
public class OperatingSystemsStartUp extends StartUp {

    /**
     * Description: Operating Systems constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of startup
     * @param description - descr of startup
     * @param location - location of startup
     * @param techGiant - tg who owns the startup
     */
    public OperatingSystemsStartUp(String name, String description, 
            Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("OperatingSystems");
    }

}
