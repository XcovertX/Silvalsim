package main.java.world;

import java.math.BigDecimal;

/**
 * Washigton.java
 * Package: main.java.world
 * Description: Washington location
 * 
 * @author James Covert
 * @version 1.0
 */

public class Washington extends Location {
    
    /**
     * Description: Washington location.
     * 
     * @author James Covert
     * @version 1.0
     */
    public Washington() {
        
        this.setStateName("Washington");
        this.setStateAbbreviation("WA");
        this.setTaxRate(BigDecimal.valueOf(1.065));
    }

}
