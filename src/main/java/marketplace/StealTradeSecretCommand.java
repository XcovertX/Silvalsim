package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * StealTradeSecretCommand.java
 * Package: main.java.marketplace
 * Description: The StealTradeSecret Command implements
 * and calls defend.stealTradeSecret
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class StealTradeSecretCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    /**
     * Description: The StealTradeSecret constructor builds a new Attack()
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param Startup attacker - the startup deploying an attack
     * @param StartUp defender - the startup receiving the attack
     *-----------------------------------------------------
     */
    public StealTradeSecretCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the StealtradeSecret offense
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    @Override
    public void execute() {
        
        attack.tradeSecretTheft(attacker, recipient);
        
    }

}
