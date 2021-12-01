package main.java.world;

import java.math.BigDecimal;

/**
 * NewYork.java
 * Package: main.java.world
 * Description: New York location
 * 
 * @author James Covert
 * @version 1.0
 */

public class NewYork extends Location {
    
    /**
     * Description: New York location.
     * 
     * @author James Covert
     * @version 1.0
     */
    public NewYork() {
        
        this.setStateName("New York");
        this.setStateAbbreviation("NY");
        this.setTaxRate(BigDecimal.valueOf(1.085));
    }

}
