package main.java.marketplace;

import main.java.actor.StartUp;

public class Defense {
    
    private StartUp defender;
    private StartUp aggressor;
    
    public Defense(StartUp defender, StartUp aggressor) {
        
        setDefender(defender);
        setAggressor(aggressor);
    }
    
    public void defend() {
        
    }

    // getters and setters
    public StartUp getDefender() {
        return this.defender;
    }

    public void setDefender(StartUp defender) {
        this.defender = defender;
    }

    public StartUp getAggressor() {
        return this.aggressor;
    }

    public void setAggressor(StartUp aggressor) {
        this.aggressor = aggressor;
    }
}
