package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * AdvertiseCommand.java
 * Package: main.java.marketplace
 * Description: The Advertise Command implements Command
 * and calls defend.advertise
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class AdvertiseCommand implements Command{
    
    private Defend defend;
    private StartUp defender;
    private StartUp attacker;
    
    /**
     * Description: The Advertise constructor builds a new Defend()
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param Startup defender - the startup deploying a defense
     * @param StartUp attacker - the startup receiving the defense
     *-----------------------------------------------------
     */
    public AdvertiseCommand(StartUp defender, StartUp attacker) {
        
        this.defend = new Defend();
        this.defender = defender;
        this.attacker = attacker;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the advertise defense
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    @Override
    public void execute() {
        
        defend.advertise(defender, attacker);
    }
}
