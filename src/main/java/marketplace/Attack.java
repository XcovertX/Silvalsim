package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Attack {
    
    public Attack() {
        
    }
    
    public void talentDrain(StartUp startupStriker, StartUp startupRecipient) {
        
        int developers = 2;
        
        Printer.print(Printer.ANSI_BLUE, startupStriker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "DRAINS");
        Printer.print(Printer.ANSI_BLUE, " " + startupRecipient.getName());
        Printer.print(" of valuable talent by stealing ");
        Printer.print(Printer.ANSI_RED, Integer.toString(developers));
        Printer.println(" key developers!!");
        
    }
    
    public void tradeSecretTheft(StartUp startupStriker, StartUp startupRecipient) {

        Printer.print(Printer.ANSI_BLUE, startupStriker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "STEALS");
        Printer.print(" a vital ");
        Printer.print(Printer.ANSI_RED, "TRADE SECRET");
        Printer.print(" from ");
        Printer.print(Printer.ANSI_BLUE, " " + startupRecipient.getName());
        Printer.println("!!");
        
    }
    
    public void politicalBribery(StartUp startupStriker, StartUp startupRecipient) {
        
        Printer.print(Printer.ANSI_BLUE, startupStriker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "BRIBES");
        Printer.print(" a corrupt politician, ");
        Printer.print(Printer.ANSI_RED, "TEMPORARILY RESTRICTING");
        Printer.print(Printer.ANSI_BLUE, " " + startupRecipient.getName());
        Printer.println(" from utilizing their corporate tax deductions!!");
        
    }
    
    public void undercutPrices(StartUp startupStriker, StartUp startupRecipient) {
        
        Printer.print(Printer.ANSI_BLUE, startupStriker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "UNDERCUTS");
        Printer.print(" their prices, ");
        Printer.print(Printer.ANSI_RED, "TEMPORARILY REDUCING");
        Printer.println(" sales of ");
        Printer.print(Printer.ANSI_BLUE, " " + startupRecipient.getName());
        Printer.println("!!");
        
    }

}
