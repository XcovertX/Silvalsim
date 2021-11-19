package main.java.world;

import java.math.BigDecimal;

public class Washington extends Location {
    
    public Washington() {
        
        this.setStateName("Washington");
        this.setStateAbbreviation("WA");
        this.setTaxRate(new BigDecimal(1.065));
    }

}
