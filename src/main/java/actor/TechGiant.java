package main.java.actor;

import java.util.ArrayList;

public class TechGiant extends Actor {
    
    private ArrayList<StartUp> startups;
    
    public TechGiant(String name, String description) {
        setName(name);
        setDescription(description);
        startups = new ArrayList<StartUp>();
        setAlive(true);
    }

    // getters and setters
    
    public ArrayList<StartUp> getStartups() {
        return startups;
    }

    public void setStartups(ArrayList<StartUp> startups) {
        this.startups = startups;
    }

}
