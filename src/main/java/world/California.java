package main.java.world;

import java.math.BigDecimal;

public class California extends Location {
    
    public California() {
        
        this.setStateName("California");
        this.setStateAbbreviation("CA");
        this.setTaxRate(new BigDecimal(1.088));
    }

}
