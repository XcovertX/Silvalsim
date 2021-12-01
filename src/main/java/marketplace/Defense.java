package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.RandomNumber;

/**
 * Offense.java
 * Package: main.java.marketplace
 * Description: The Defense class is a controller. 
 * This class builds all defenses.
 * 
 * @author James Covert
 * @version 1.0
 */

public class Defense {
    
    private StartUp defender;
    private StartUp recipient;
    
    /**
     * Description: Defense constructor.
     * 
     * @author James Covert
     * @version 1.0
     * @param defender - su deploying the defense
     * @param recipient - su receiving the defense
     */
    public Defense(StartUp defender, StartUp recipient) {
        
        setDefender(defender);
        setRecipient(recipient);
    }
    
    /**
     * Description: This method executes a randomly selected defenseCommand.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void defend() {
        
        int defenseSelection = selectDefense();
        
        if (defenseSelection == 0) {
        
            new AdvertiseCommand(defender, recipient).execute();
            
        } else if (defenseSelection == 1) {
            
            new RecruitTalentCommand(defender, recipient).execute();
            
        } else if (defenseSelection == 2) {
            
            new LiquidateCommand(defender, recipient).execute();
            
        } else if (defenseSelection == 3) {
            
            new DodgeCommand(defender, recipient).execute();
        }
    }
    
    /**
     * Description: This method produces a random selection.
     * 
     * @author James Covert
     * @version 1.0
     * @return int - number between 0-3
     */
    public int selectDefense() {
        
        int min = 0;
        int max = 3;
        int randomNumber = RandomNumber.getRandomBetween(min, max);
        
        return randomNumber;
    }

    // getters and setters
    
    public StartUp getDefender() {
        
        return defender;
    }

    public void setDefender(StartUp defender) {
        
        this.defender = defender;
    }

    public StartUp getRecipient() {
        
        return recipient;
    }

    public void setRecipient(StartUp recipient) {
        
        this.recipient = recipient;
    }
}
