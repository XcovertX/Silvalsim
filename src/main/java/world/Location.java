package main.java.world;

import java.math.BigDecimal;

/**
 * Location.java
 * Package: main.java.world
 * Description: Location abstract class sets the framework location subclasses.
 * The this class provides the given tax rate use for any startup in this location.
 * 
 * @author James Covert
 * @version 1.0
 */

public abstract class Location {
    
    private String stateName;
    private String stateAbbreviation;
    private BigDecimal taxRate;
    
    // getters and setters
    
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
