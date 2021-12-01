package main.java.actor;

import main.java.world.Location;

/**
 * FinancialTechStartUp.java
 * Package: main.java.actor
 * Description: FinancialTech are subtype of Startup
 * 
 * @author James Covert
 * @version 1.0
 */

public class FinancialTechStartUp extends StartUp {

    /**
     * Description: Financial Tech constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of startup
     * @param description - descr of startup
     * @param location - location of startup
     * @param techGiant - tg who owns the startup
     */
    public FinancialTechStartUp(String name, String description, 
            Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("FinancialTech");
    }

}
