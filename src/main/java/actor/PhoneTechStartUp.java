package main.java.actor;

import java.math.BigDecimal;

import main.java.world.California;
import main.java.world.Location;
import main.java.world.RandomNumber;

public class PhoneTechStartUp extends StartUp {

    public PhoneTechStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("PhoneTech");

    }
}
