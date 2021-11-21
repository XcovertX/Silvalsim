package main.java.marketplace;

import java.util.Random;

import main.java.actor.StartUp;

public class Defense {
    
    private StartUp defender;
    private StartUp recipient;
    
    public Defense(StartUp defender, StartUp recipient) {
        
        setDefender(defender);
        setRecipient(recipient);
    }
    
    public void Defend() {
        
        int defenseSelection = selectDefense();
        
        if (defenseSelection >= 0 || defenseSelection < 3) {
        
            new AdvertiseCommand(defender, recipient).execute();
            
        } else if (defenseSelection >= 3 || defenseSelection < 6) {
            
            new RecruitTalentCommand(defender, recipient).execute();
            
        } else if (defenseSelection == 7) {
            
            new LiquidateCommand(defender, recipient).execute();
            
        } else if (defenseSelection > 7) {
            
//            new AdvertiseCommand(defender).execute();
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
        int max = 14;
        Random rand = new Random();
        int randomNumber = rand.nextInt(max + 1 - min) + min;
        
        return randomNumber;
    }
}
