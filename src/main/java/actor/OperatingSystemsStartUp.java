package main.java.actor;

import java.math.BigDecimal;

import main.java.world.Location;
import main.java.world.RandomNumber;

public class OperatingSystemsStartUp extends StartUp {

    public OperatingSystemsStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("OperatingSystems");

    }

}
