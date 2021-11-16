package main.java.actor;

import main.java.marketplace.Competition;
import main.java.world.Location;
import main.java.world.NewYork;

public class StartUp extends Actor {
    
    private double netIncome;
    private double revenue;
    private double marketShare;
    private Location location;
    
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

}
