package main.java.actor;

import java.util.ArrayList;

public class TechGiant extends Actor {
    
    private ArrayList<Actor> startups;
    
    public TechGiant(String name, String description) {
        setName(name);
        setDescription(description);
    }

    // getters and setters
    
    public ArrayList<Actor> getStartups() {
        return startups;
    }

    public void setStartups(ArrayList<Actor> startups) {
        this.startups = startups;
    }

}
