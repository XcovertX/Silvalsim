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

    public OperatingSystemsStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("OperatingSystems");
    }

}
