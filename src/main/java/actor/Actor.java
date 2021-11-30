package main.java.actor;
/**
 * Actor.java
 * Package: main.java.actor
 * Description: The is an abstract class that is the basis for
 * all actors: techgiants, startups, customers, developers
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public abstract class Actor {

    private String name;
    private String description;
    private boolean isAlive;
    
    /**
     * This marks the actor as loser in a competition
     */
    public void die() {
        setAlive(false);
    }
    
    // getters and setters
    
    public String getName() {
        return name;
    }
    
    public void setName(String name) {
        this.name = name;
    }
    
    public String getDescription() {
        return description;
    }
    
    public void setDescription(String description) {
        this.description = description;
    }

    public boolean isAlive() {
        return isAlive;
    }

    public void setAlive(boolean isAlive) {
        this.isAlive = isAlive;
    }
}
