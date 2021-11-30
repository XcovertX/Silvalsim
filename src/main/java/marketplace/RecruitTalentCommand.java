package main.java.marketplace;

import main.java.actor.StartUp;

/**
 * RecruitTalentCommand.java
 * Package: main.java.marketplace
 * Description: The RecruitTalent Command implements Command
 * and calls Defend.recruitTalent
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class RecruitTalentCommand implements Command{
    
    private Defend defend;
    private StartUp defender;
    private StartUp attacker;
    
    /**
     * Description: The RecruitTalentCommand constructor builds a new Defend()
     * and assigns the two competing opponents
     * 
     * @author James Covert
     * @version 1.0
     * @param Startup defender - the startup deploying a defense
     * @param StartUp attacker - the startup receiving the defense
     *-----------------------------------------------------
     */
    public RecruitTalentCommand(StartUp defender, StartUp attacker) {
        
        this.defend = new Defend();
        this.defender = defender;
        this.attacker = attacker;
    }

    /**
     * Description: This method overrides the execute method from the command interface.
     * It calls the recruitTalent defense
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    @Override
    public void execute() {
        
        defend.recruitTalent(defender, attacker);
        
    }

}
