package main.java.marketplace;

import java.math.BigDecimal;
import java.util.Random;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;
import main.java.world.World;

public class Defend {
    private StartUp attacker;
    private StartUp defender;
    
    private int[] results = new int[4];
    
    public Defend() {
        
    }
    
    public void advertise(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        calculateAttackOutcome();
        
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
            
            Printer.print(Printer.ANSI_CYAN, defender.getName());
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to defend against inbound attacks");
            Printer.print(" but the defense ");
            Printer.print(Printer.ANSI_RED, "fails");
            Printer.println(".");
        }
    }
    public void recruitTalent(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            int strength = calculateDefenseStrength(defender) * defender.getTalentMultiplier();
                
            defender.addJuniorDevs(strength / 2);
            defender.addExperiencedDevs(strength / 4);
            defender.addSeniorDevs(strength / 4);
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by recruiting ");
            Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
            Printer.println(" new developers!!");
        
        } else {

            Printer.print(Printer.ANSI_CYAN, defender.getName());
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to defend against inbound attacks");
            Printer.print(" but the defense ");
            Printer.print(Printer.ANSI_RED, "fails");
            Printer.println(".");
        }
    }
    
    public void liquidate(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            int strength = calculateDefenseStrength(defender) * defender.getTalentMultiplier();
                
            for(int i = 0; i < defender.getDevs().size(); i++) {
                
                defender.removeTopDev();
            }
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by liquidating assets and laying off ");
            Printer.print(Printer.ANSI_RED, Integer.toString(strength));
            Printer.println(" developers!!");
        
        } else {
            
            Printer.print(Printer.ANSI_CYAN, defender.getName());
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to defend against inbound attacks");
            Printer.print(" but the defense ");
            Printer.print(Printer.ANSI_RED, "fails");
            Printer.println(".");
        }
    }
    
    private void calculateAttackOutcome() {

//        results[0] = calculateAttackStrength();
//        results[1] = calculateCriticalAttack();
//        results[2] = calculateDefenseStrength();
//        results[3] = calculateDodgeStrength();
         
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
    
    private int calculateCriticalDefenseStrength(int defenseStrength) {
        
        return defenseStrength * RandomNumber.getRandomBetween(1, 3);
    }
    
//    private int calculateDefenseStrength() {
//        
//    }
//    
//    private int calculateDodgeStrength() {
//        
//    }
    
    private boolean calculateDefenseSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = attacker.getAttackSuccessMultiplier() + offset;
        int role = RandomNumber.getRandomBetween(min, max) + offset;
        
        if (role <= probability) {
            return true;
        }
        return false;    
    }
    
    private boolean calculateCriticalAttackSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = attacker.getAttackSuccessMultiplier() + offset;
        int role = RandomNumber.getRandomBetween(min, max) + offset;
        
        if (role <= probability) {
            return true;
        }
        return false; 
    }
    
//    private boolean calculateDefenseSuccess() {
//        
//    }
//    
//    private boolean calculateDodgeSuccess() {
//        
//    }
}
