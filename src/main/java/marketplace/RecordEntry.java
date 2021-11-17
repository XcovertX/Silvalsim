package main.java.marketplace;

public class RecordEntry {
    
    private double netIncome;
    private double revenue;
    private double marketShare;
    
    public RecordEntry(double netIncome, double revenue, double marketShare) {
        
        this.netIncome = netIncome;
        this.revenue = revenue;
        this.marketShare = marketShare;
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
