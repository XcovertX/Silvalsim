package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * DodgeCommand.java
 * Package: main.java.marketplace
 * Description: The Dodge Command extends Command
 * and calls defend.advertise
 * 
 * @author James Covert
 * @version 1.0
 */
public class DodgeCommand implements Command {

    private Defend defend;
    private StartUp defender;
    private StartUp attacker;
    
    /**
     * Description: The DodgeCommand constructor builds a new Defend().
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param defender - the startup deploying a defense
     * @param attacker - the startup receiving the defense
     */
    public DodgeCommand(StartUp defender, StartUp attacker) {
        
        this.defend = new Defend();
        this.defender = defender;
        this.attacker = attacker;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the dodge defense
     * 
     * @author James Covert
     * @version 1.0
     */
    @Override
    public void execute() {
        
        defend.dodge(defender, attacker);
        
    }
}
