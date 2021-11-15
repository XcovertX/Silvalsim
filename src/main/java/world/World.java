package main.java.world;

import java.util.ArrayList;

import main.java.actor.Actor;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;

public class World {
    
    private ArrayList<Actor> actors;
    
    public World() {
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures");
        
        tg1.getStartups().add(su1);
        
        actors.add(tg1);
        
    }

    public void updateWorld() {
        
        System.out.println("Update");
        
        
    }
}
