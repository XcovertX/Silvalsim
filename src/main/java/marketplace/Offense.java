package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.RandomNumber;

/**
 * Offense.java
 * Package: main.java.marketplace
 * Description: The Offense class is a controller. 
 * This class builds all attacks.
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class Offense {
    
    private StartUp attacker;
    private StartUp recipient;
    
    public Offense(StartUp attacker, StartUp recipient) {
        
        setAttacker(attacker);
        setRecipient(recipient);
    }
    
    /**
     * Description: This method executes a randomly selected attackCommand.
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    public void attack() {
        
        int attackSelection = selectAttack();
        
        if (attackSelection == 0) {
        
            new BribePoliticianCommand(attacker, recipient).execute();
            
        } else if (attackSelection == 1) {
            
            new StealTradeSecretCommand(attacker, recipient).execute();
            
        } else if (attackSelection == 2) {
            
            new DrainTalentCommand(attacker, recipient).execute();
            
        } else if (attackSelection == 3) {
            
            new UndercutPricesCommand(attacker, recipient).execute();
        }
    }
    
    /**
     * Description: This method produces a random selection
     * 
     * @author James Covert
     * @version 1.0
     * @return int - number between 0-3
     *-----------------------------------------------------
     */
    public int selectAttack() {
        
        int min = 0;
        int max = 3;
        int randomNumber = RandomNumber.getRandomBetween(min, max);
        
        return randomNumber;
    }

    // getters and setters
    
    public StartUp getAttacker() {
        
        return attacker;
    }

    public void setAttacker(StartUp attacker) {
        
        this.attacker = attacker;
    }

    public StartUp getRecipient() {
        
        return recipient;
    }

    public void setRecipient(StartUp recipient) {
        
        this.recipient = recipient;
    }
}
