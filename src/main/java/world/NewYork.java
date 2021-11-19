package main.java.world;

import java.math.BigDecimal;

public class NewYork extends Location {
    
    public NewYork() {
        
        this.setStateName("New York");
        this.setStateAbbreviation("NY");
        this.setTaxRate(new BigDecimal(1.085));
    }

}
