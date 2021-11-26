package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.RandomNumber;

public class Defense {
    
    private StartUp defender;
    private StartUp recipient;
    
    public Defense(StartUp defender, StartUp recipient) {
        
        setDefender(defender);
        setRecipient(recipient);
    }
    
    public void Defend() {
        
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
    
    public int selectDefense() {
        
        int min = 0;
        int max = 3;
        int randomNumber = RandomNumber.getRandomBetween(min, max);
        
        return randomNumber;
    }
}
