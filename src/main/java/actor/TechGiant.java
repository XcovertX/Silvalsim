package main.java.actor;

import java.util.ArrayList;

/**
 * TechGiant.java
 * Package: main.java.actor
 * Description: The TechGiant class is an Actor that holds a collection of StartUps.
 * 
 * @author James Covert
 * @version 1.0
 */
public class TechGiant extends Actor {
    
    private ArrayList<StartUp> startups;    // StartUps owned by the TechGiant
    
    /**
     * Description: The TechGiant constructor assigns the name and description
     * as well as generates the new ArrayList for holding the owned StartUps.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of the TechGiant
     * @param description - general description of the TechGiant
     */
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
