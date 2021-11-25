package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.RandomNumber;

public class Offense {
    
    private StartUp attacker;
    private StartUp recipient;
    
    public Offense(StartUp attacker, StartUp recipient) {
        
        setAttacker(attacker);
        setRecipient(recipient);
    }
    
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
    
    public int selectAttack() {
        
        int min = 0;
        int max = 3;
        int randomNumber = RandomNumber.getRandomBetween(min, max);
        
        return randomNumber;
    }
}
