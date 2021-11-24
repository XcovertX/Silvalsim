package main.java.marketplace;

import java.math.BigDecimal;

public class RecordEntry {
    
    private BigDecimal netIncome;
    private BigDecimal monthlyRevenue;
    private BigDecimal totalRevenue;
    private BigDecimal marketShare; 
    private int numberOfCustomers;
    private int numberOfDevs;
    
    public RecordEntry(BigDecimal netIncome, BigDecimal monthlyRevenue, 
            BigDecimal totalRevenue, BigDecimal marketShare, int numOfCustomers, int numOfDevs) {
        
        this.netIncome = netIncome;
        this.monthlyRevenue = monthlyRevenue;
        this.totalRevenue = totalRevenue;
        this.marketShare = marketShare;
        this.numberOfCustomers = numOfCustomers;
        this.numberOfDevs = numOfDevs;
    }
    
    // getters and setters
    
    public BigDecimal getNetIncome() {
        
        return netIncome;
    }
    
    public void setNetIncome(BigDecimal netIncome) {
        
        this.netIncome = netIncome;
    }
    
    public BigDecimal getMonthlyRevenue() {
        
        return monthlyRevenue;
    }
    
    public void setMonthlyRevenue(BigDecimal revenue) {
        
        this.monthlyRevenue = revenue;
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

    public BigDecimal getTotalRevenue() {
        
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        
        this.totalRevenue = totalRevenue;
    }

    public int getNumberOfDevs() {
        return numberOfDevs;
    }

    public void setNumberOfDevs(int numberOfDevs) {
        this.numberOfDevs = numberOfDevs;
    }
}
