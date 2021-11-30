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

    public FinancialTechStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("FinancialTech");
    }

}
