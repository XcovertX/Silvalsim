package main.java.marketplace;

/**
 * GarageOffice.java
 * Package: main.java.marketplace
 * Description: The level one for all startups
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */
public class GarageOffice extends Level {
    
    public GarageOffice() {
        
        this.setTitle("Garage Office");
        this.setLevelNumber(1);
        this.setSuccessMultiplier(2);
        this.setAttackCostMultiplier(1);
        this.setDefendCostMultiplier(1);
        this.setBaseNumber(10);
        this.setXPMin(1);
        this.setXPMax(3);
    }

}
