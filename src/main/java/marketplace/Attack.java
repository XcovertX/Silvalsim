package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Attack {
    
    private StartUp attacker;
    private StartUp defender;
    
    private int[] results = new int[4];
    
    public Attack() {
        
    }
    
    public void talentDrain(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        int strength = calculateAttackStrength();
        boolean critical = calculateCriticalAttackSuccess();
        
        int developers = 0;
        
        for(int i = 0; i < strength; i++) {
            
            if (critical) {
                
                attacker.addDev(defender.removeTopDev());
                
            } else {
                
                attacker.addDev(defender.removeLowestDev());
            }
        }
        
        
        
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "DRAINS");
        Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
        Printer.print(" of valuable talent by stealing ");
        Printer.print(Printer.ANSI_RED, Integer.toString(developers));
        Printer.println(" key developers!!");
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName());
        Printer.print(" now has ");
        Printer.print(Printer.ANSI_GREEN, Integer.toString(attacker.getDevs().size()));
        Printer.println(" developers.");
        
        Printer.print(Printer.ANSI_CYAN, defender.getName());
        Printer.print(" now has ");
        Printer.print(Printer.ANSI_RED, Integer.toString(defender.getDevs().size()));
        Printer.println(" developers.");
        
    }
    
    public void tradeSecretTheft(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();

        Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "STEALS");
        Printer.print(" a vital ");
        Printer.print(Printer.ANSI_RED, "TRADE SECRET");
        Printer.print(" from ");
        Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
        Printer.println("!!");
        
    }
    
    public void politicalBribery(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "BRIBES");
        Printer.print(" a corrupt politician, ");
        Printer.print(Printer.ANSI_RED, "TEMPORARILY RESTRICTING");
        Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
        Printer.println(" from utilizing their corporate tax deductions!!");
        
    }
    
    public void undercutPrices(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
        Printer.print(Printer.ANSI_RED, "UNDERCUTS");
        Printer.print(" their prices, ");
        Printer.print(Printer.ANSI_RED, "TEMPORARILY REDUCING");
        Printer.print(" sales of ");
        Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
        Printer.println("!!");
        
    }
    
    private void calculateAttackOutcome() {

//        results[0] = calculateAttackStrength();
//        results[1] = calculateCriticalAttack();
//        results[2] = calculateDefenseStrength();
//        results[3] = calculateDodgeStrength();
         
    }
    
    private int calculateAttackStrength() {
        
        int strength = (int) Math.round(attacker.getNetIncome() / 1000000.00);
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
//    private int calculateCriticalAttack() {
//        
//    }
//    
//    private int calculateDefenseStrength() {
//        
//    }
//    
//    private int calculateDodgeStrength() {
//        
//    }
//    
//    private boolean calculateAttackSuccess() {
//        
//    }
    
    private boolean calculateCriticalAttackSuccess() {
        
        return true;
        
    }
    
//    private boolean calculateDefenseSuccess() {
//        
//    }
//    
//    private boolean calculateDodgeSuccess() {
//        
//    }
}
