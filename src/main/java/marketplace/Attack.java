package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Attack {
    
    public Attack() {
        
    }
    
    public void talentDrain(StartUp startupStriker, StartUp startupRecipient) {
        
        int developers = 2;
        
        Printer.print(startupStriker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "DRAINS");
        Printer.print(" " + startupRecipient.getName() + " of valuable talent by stealing ");
        Printer.print(Printer.ANSI_RED, Integer.toString(developers));
        Printer.println(" key developers!!");
        
    }
    
    public void tradeSecretTheft() {
        
    }
    
    public void politicalBribery() {
        
    }
    
    public void underCutPrices() {
        
    }

}
