package main.java.world;

import java.math.BigDecimal;

public abstract class Location {
    
    private String stateName;
    private String stateAbbreviation;
    private BigDecimal taxRate;
    
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
    public BigDecimal getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(BigDecimal taxRate) {
        this.taxRate = taxRate;
    }

}
