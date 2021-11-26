package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;

public class Defend {
    private StartUp attacker;
    private StartUp defender;
    
    public Defend() {
        
    }
    
    public void advertise(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            int strength = calculateDefenseStrength(defender) * defender.getDesirability();
                
            defender.addMediumIncomeCustomers(strength);
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by deploying an aggressive add campaign obtaining ");
            Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
            Printer.println(" new customers!!");
        
        } else {
            
            printFail();
        }
    }
    public void recruitTalent(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            int strength = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
                
            defender.addJuniorDevs(strength / 2);
            defender.addExperiencedDevs(strength / 4);
            defender.addSeniorDevs(strength / 4);
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by recruiting ");
            Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
            Printer.println(" new developers!!");
        
        }
    }
    
    public void liquidate(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            int strength = RandomNumber.getRandomBetween(1, 3);
            
            int counter = 0;
            for(int i = 0; i < defender.getDevs().size(); i++) {
                
                if (counter < strength) {
                    
                    defender.removeLowestDev();
                    counter++;
                    
                } else {
                    
                    break;
                }
            }
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by liquidating assets and laying off ");
            Printer.print(Printer.ANSI_RED, Integer.toString(strength));
            Printer.println(" developers!!");
        
        } else {
            
            printFail();
        }
    }
    
    public void dodge(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            defender.setDodge(true);
            
            Printer.print(Printer.ANSI_CYAN, defender.getName());
            Printer.print(" positions themselves to ");
            Printer.print(Printer.ANSI_GREEN, "DEFEND");
            Printer.println(" against the next attack!!");
        
        } else {
            
            printFail();
        }
    }
    
    private int calculateDefenseStrength(StartUp attacker) {
        
        int strength;
        
        int min = attacker.getLevel().getXPMin();
        int max = attacker.getLevel().getXPMax();;
        strength = RandomNumber.getRandomBetween(min, max);
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
    private boolean calculateDefenseSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = defender.getLevelNumber() - defender.getLevelNumber();
        int probability = 5 + offset;
        int role = RandomNumber.getRandomBetween(min, max);
        
        System.out.println("defense success: role: " + role + " prob: " + probability);
        
        if (role <= probability) {
            return true;
        }
        return false;    
    }
    
    private void printFail() {
        
        Printer.print(Printer.ANSI_CYAN, defender.getName());
        Printer.print(Printer.ANSI_RED, " attempts ");
        Printer.print("to defend against inbound attacks,");
        Printer.print(" but the defense ");
        Printer.print(Printer.ANSI_RED, "fails");
        Printer.println(".");  
    }
}
