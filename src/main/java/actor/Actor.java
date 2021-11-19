package main.java.actor;

import main.java.world.Printer;

public abstract class Actor {

    private String name;
    private String description;
    private boolean isAlive;
    
    public void die() {
        setAlive(false);
        Printer.print(Printer.ANSI_RED, getName());
        Printer.println(Printer.ANSI_RED, " has been defeated!!");
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
