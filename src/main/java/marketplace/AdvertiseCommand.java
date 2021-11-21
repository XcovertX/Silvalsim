package main.java.marketplace;

import main.java.actor.StartUp;

public class AdvertiseCommand implements Command{
    
    private Defend defend;
    private StartUp defender;
    private StartUp attacker;
    
    public AdvertiseCommand(StartUp defender, StartUp attacker) {
        
        this.defend = new Defend();
        this.defender = defender;
        this.attacker = attacker;
    }

    @Override
    public void execute() {
        
        defend.advertise(defender, attacker);
        
    }

}
