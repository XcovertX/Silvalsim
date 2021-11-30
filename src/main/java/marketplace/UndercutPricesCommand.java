package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * UndercutPricesCommand.java
 * Package: main.java.marketplace
 * Description: The UndeructPrices Command implements Command
 * and calls defend.undercutPrices
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */
public class UndercutPricesCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    /**
     * Description: The UndercutPricesCommand constructor builds a new Attack()
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param Startup attacker - the startup deploying an attack
     * @param StartUp defender - the startup receiving the attack
     *-----------------------------------------------------
     */
    public UndercutPricesCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the UndercutPrices offense
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    @Override
    public void execute() {
        
        attack.undercutPrices(attacker, recipient);
    }
}
