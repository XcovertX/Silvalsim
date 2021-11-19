package main.java.marketplace;

import java.math.BigDecimal;

public class RecordEntry {
    
    private double netIncome;
    private BigDecimal revenue;
    private double marketShare; 
    private int numberOfCustomers;
    
    public RecordEntry(double netIncome, BigDecimal revenue, double marketShare, int numOfCustomers) {
        
        this.netIncome = netIncome;
        this.revenue = revenue;
        this.marketShare = marketShare;
        this.numberOfCustomers = numOfCustomers;
    }
    
    // getters and setters
    
    public double getNetIncome() {
        
        return netIncome;
    }
    
    public void setNetIncome(double netIncome) {
        
        this.netIncome = netIncome;
    }
    
    public BigDecimal getRevenue() {
        
        return revenue;
    }
    
    public void setRevenue(BigDecimal revenue) {
        
        this.revenue = revenue;
    }
    
    public double getMarketShare() {
        
        return marketShare;
    }
    
    public void setMarketShare(double marketShare) {
        
        this.marketShare = marketShare;
    }

    public int getNumberOfCustomers() {
        
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        
        this.numberOfCustomers = numberOfCustomers;
    }
}
