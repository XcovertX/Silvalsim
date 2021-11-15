package main.java.actor;

public class StartUp extends Actor {
    
    private double netIncome;
    private double revenue;
    private double marketShare;
    
    public StartUp(String name, String description) {
        setName(name);
        setDescription(description);
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

}
