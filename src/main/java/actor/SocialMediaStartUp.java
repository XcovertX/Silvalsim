package main.java.actor;

import java.math.BigDecimal;

import main.java.world.Location;
import main.java.world.RandomNumber;

public class SocialMediaStartUp extends StartUp {

    public SocialMediaStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("SocialMedia");

    }

}
