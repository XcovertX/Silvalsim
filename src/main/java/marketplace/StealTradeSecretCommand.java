package main.java.marketplace;

import main.java.actor.StartUp;

public class StealTradeSecretCommand implements Command {
    
    private Attack attack;
    private StartUp attacker;
    private StartUp recipient;
    
    public StealTradeSecretCommand(StartUp attacker, StartUp recipient) {
        
        this.attack = new Attack();
        this.attacker = attacker;
        this.recipient = recipient;
    }

    @Override
    public void execute() {
        
        attack.tradeSecretTheft(attacker, recipient);
        
    }

}
