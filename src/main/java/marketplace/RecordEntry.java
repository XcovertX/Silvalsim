package main.java.marketplace;

import java.math.BigDecimal;

public class RecordEntry {
    
    private BigDecimal netIncome;
    private BigDecimal revenue;
    private BigDecimal marketShare; 
    private int numberOfCustomers;
    
    public RecordEntry(BigDecimal netIncome, BigDecimal revenue, BigDecimal marketShare, int numOfCustomers) {
        
        this.netIncome = netIncome;
        this.revenue = revenue;
        this.marketShare = marketShare;
        this.numberOfCustomers = numOfCustomers;
    }
    
    // getters and setters
    
    public BigDecimal getNetIncome() {
        
        return netIncome;
    }
    
    public void setNetIncome(BigDecimal netIncome) {
        
        this.netIncome = netIncome;
    }
    
    public BigDecimal getRevenue() {
        
        return revenue;
    }
    
    public void setRevenue(BigDecimal revenue) {
        
        this.revenue = revenue;
    }
    
    public BigDecimal getMarketShare() {
        
        return marketShare;
    }
    
    public void setMarketShare(BigDecimal marketShare) {
        
        this.marketShare = marketShare;
    }

    public int getNumberOfCustomers() {
        
        return numberOfCustomers;
    }

    public void setNumberOfCustomers(int numberOfCustomers) {
        
        this.numberOfCustomers = numberOfCustomers;
    }
}
