package main.java.marketplace;

import main.java.actor.StartUp;

public class DrainTalentCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    public DrainTalentCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    @Override
    public void execute() {
        
        attack.talentDrain(attacker, recipient);
        
    }
}
