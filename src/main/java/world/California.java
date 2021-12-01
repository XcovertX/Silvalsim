package main.java.world;

import java.math.BigDecimal;

/**
 * California.java
 * Package: main.java.world
 * Description: California location
 * 
 * @author James Covert
 * @version 1.0
 */

public class California extends Location {
    
    /**
     * Description: California location.
     * 
     * @author James Covert
     * @version 1.0
     */
    public California() {
        
        this.setStateName("California");
        this.setStateAbbreviation("CA");
        this.setTaxRate(new BigDecimal(1.088));
    }

}
