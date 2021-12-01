package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * BribePoliticianCommand.java
 * Package: main.java.marketplace
 * Description: The BribePolitician Command implements Command
 * and calls defend.politicalBribery
 * 
 * @author James Covert
 * @version 1.0
 */

public class BribePoliticianCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    /**
     * Description: The BribePoliticianCommand constructor builds a new Attack().
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying an attack
     * @param recipient - the startup receiving the attack
     */
    public BribePoliticianCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the politicalBribery offense
     * 
     * @author James Covert
     * @version 1.0
     */
    @Override
    public void execute() {
        
        attack.politicalBribery(attacker, recipient);  
    }
}
