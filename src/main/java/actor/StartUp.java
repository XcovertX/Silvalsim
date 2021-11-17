package main.java.actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

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
        setXP(0);
        setNetIncome(0);
        setRevenue(0);
        setMarketShare(0);
        setSpeed(0);
        
        devs = new ArrayList<Developer>();
        
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

    private void setSpeed(int speed) {
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
        this.speed = devs.size();
        this.devs = devs;
    }
    
    public Developer getDev(int index) {
        return devs.get(index);
    }
    
    public void removeDev(Developer dev) {
        
        for(int i = 0; i < devs.size(); i++) {
            if (devs.get(i).equals(dev)) {
                devs.remove(i);
                this.speed--;
            }
        }
    }
    
    public void removeTopDev() {
        
        Collections.sort(devs, new Comparator<Developer>() {
            
            @Override
            public int compare(Developer d1, Developer d2) {
                
                if (d1.getTalent() > d2.getTalent()) {
                    return 1;
                }
                
                if (d1.getTalent() < d2.getTalent()) {
                    return -1;
                }
                return 0;
            }
        });
        
        devs.remove(0);
        this.speed--;
    }
    
    public void removeLowestDev() {
        
        Collections.sort(devs, new Comparator<Developer>() {
            
            @Override
            public int compare(Developer d1, Developer d2) {
                
                if (d1.getTalent() < d2.getTalent()) {
                    return 1;
                }
                
                if (d1.getTalent() > d2.getTalent()) {
                    return -1;
                }
                return 0;
            }
        });
        
        devs.remove(0);
        this.speed--;
    }
    
    public void addDev(Developer dev) {
        
        devs.add(dev);
        this.speed++;
    }
    



}
