package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * DrainTalentCommand.java
 * Package: main.java.marketplace
 * Description: The DrainTalent Command implements Command
 * and calls attack.DrainTalent
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */
public class DrainTalentCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    /**
     * Description: The DrainTalen constructor builds a new Attack()
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param Startup attacker - the startup deploying a attack
     * @param StartUp defender - the startup receiving the attack
     *-----------------------------------------------------
     */
    public DrainTalentCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the DrainTalent offense
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    @Override
    public void execute() {
        
        attack.talentDrain(attacker, recipient);
        
    }
}
