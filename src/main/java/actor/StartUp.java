package main.java.actor;

import java.util.ArrayList;

import main.java.marketplace.Competition;
import main.java.world.Location;
import main.java.world.NewYork;

public class StartUp extends Actor {
    
    // Stats ///////////////////////
    private int xp;
    private double netIncome;               // hit points
    private double revenue;                 // health points
    private double marketShare;             // defense points
    private int speed;                      // action speed
    
    // Devs ////////////////////////
    private ArrayList<Developer> devs;      // dev talent
    private Location location;              // company location
    
    private boolean engagedInCompetition;
    private Competition currentCompetition;

    
    public StartUp(String name, String description, Location location) {
        
        setName(name);
        setDescription(description);
        setLocation(location);
        
    }
    
    // getters and setters

    public double getNetIncome() {
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        this.netIncome = netIncome;
    }

    public double getRevenue() {
        return revenue;
    }

    public void setRevenue(double revenue) {
        this.revenue = revenue;
    }

    public double getMarketShare() {
        return marketShare;
    }

    public void setMarketShare(double marketShare) {
        this.marketShare = marketShare;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    public boolean isEngagedInCompetition() {
        return engagedInCompetition;
    }

    public void setEngagedInCompetition(boolean engagedInCompetition) {
        this.engagedInCompetition = engagedInCompetition;
    }

    public Competition getCurrentCompetition() {
        return currentCompetition;
    }

    public void setCurrentCompetition(Competition currentCompetition) {
        this.currentCompetition = currentCompetition;
    }

    public int getSpeed() {
        return speed;
    }

    public void setSpeed(int speed) {
        this.speed = speed;
    }

    public int getXP() {
        return xp;
    }

    public void setXP(int xp) {
        this.xp = xp;
    }

    public ArrayList<Developer> getDevs() {
        return devs;
    }

    public void setDevs(ArrayList<Developer> devs) {
        this.devs = devs;
    }
    
    public Developer getDev(int index) {
        return devs.get(index);
    }
    
    public void addDev(Developer dev) {
        devs.add(dev);
    }

}
