package main.java.marketplace;

import java.math.BigDecimal;
import java.util.Random;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.World;

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
        
        int strength = calculateAttackStrength(attacker);
        boolean critical = calculateCriticalAttackSuccess();
        
        int developers = 0;
        
        for(int i = 0; i < strength; i++) {
            
            if (defender.getDevs().size() > 1) {
                if (critical) {
                    
                    attacker.addDev(defender.removeTopDev());
                    attacker.awardXP();
                    developers++;
                    
                } else {
                    
                    attacker.addDev(defender.removeLowestDev());
                    attacker.awardXP();
                    developers++;
                }
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
        Printer.print(" developers. ");
        
        Printer.print(Printer.ANSI_CYAN, defender.getName());
        Printer.print(" now has ");
        Printer.print(Printer.ANSI_RED, Integer.toString(defender.getDevs().size()));
        Printer.println(" developers.");
        
        developers = 0;
        
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
        
        int strength = calculateAttackStrength(attacker);
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {
            
            boolean attackCritical = calculateCriticalAttackSuccess();
            
            if (attackCritical) {
                
                int amount = strength * 10000000;
                int duration = strength * 10;
                
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(2)));
                defender.setServiceCost(defender.getServiceCost() * 2);
                defender.addExpense("fee", "Fee", amount,World.world.getCurrentDay(), duration);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" delivers a ");
                Printer.print(Printer.ANSI_RED, "CRITICAL");
                Printer.print(" attack by ");
                Printer.print(Printer.ANSI_RED, "BRIBING");
                Printer.println(" a corrupt politician! ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" will now have to pay monthly fees in the amount of ");
                Printer.print(Printer.ANSI_RED, "$" + amount);
                Printer.print(" for a total of ");
                Printer.print(Printer.ANSI_RED, Integer.toString(duration));
                Printer.println(" months!!");
                
            } else {
                
                int amount = strength * 1000000;
                int duration = strength * 5;
                
                System.out.println("Strength: " + strength);
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(4)));
                defender.setServiceCost(defender.getServiceCost() * 1.4);
                defender.addExpense("fee", "Fee", amount, World.world.getCurrentDay(), duration);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" delivers a ");
                Printer.print(Printer.ANSI_RED, "CRITICAL");
                Printer.print(" attack by ");
                Printer.print(Printer.ANSI_RED, "BRIBING");
                Printer.println(" a corrupt politician! ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" will now have to pay monthly fees in the amount of ");
                Printer.print(Printer.ANSI_RED, "$" + amount);
                Printer.print(" for a total of ");
                Printer.print(Printer.ANSI_RED, Integer.toString(duration));
                Printer.println(" months!!");
            }
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
            Printer.print(" attempts to bribe a corrupt politician, ");
            Printer.println(" but fails.");
        }
        

        
    }
    
    public void undercutPrices(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        boolean success = calculateAttackSuccess();
        
        if (success) {
            
            int strength = calculateAttackStrength(attacker);
            boolean critical = calculateCriticalAttackSuccess();
            
            if (critical) {
                
                strength = calculateCriticalAttack(strength);
                
                attacker.setServiceCost(defender.getServiceCost() / 2);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
                Printer.print(Printer.ANSI_RED, "UNDERCUTS");
                Printer.print(" their prices, ");
                Printer.print(Printer.ANSI_RED, "GOUGING");
                Printer.print(" the overall revenue of ");
                Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
                Printer.println("!!");
                
            } else {
                
                attacker.setServiceCost(defender.getServiceCost() - (defender.getServiceCost() / 4));
                Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
                Printer.print(Printer.ANSI_RED, "UNDERCUTS");
                Printer.print(" their prices, ");
                Printer.print(Printer.ANSI_RED, "GOUGING");
                Printer.print(" the overall revenue of ");
                Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
                Printer.println("!!");
            }
            

            
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print( " attempts to undercut thier prieces but,");
            Printer.print( " the maneuver has no effect on");
            Printer.print(" the revenue of ");
            Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
            Printer.println(".");
        }
        
    }
    
    private void calculateAttackOutcome() {

//        results[0] = calculateAttackStrength();
//        results[1] = calculateCriticalAttack();
//        results[2] = calculateDefenseStrength();
//        results[3] = calculateDodgeStrength();
         
    }
    
    private int calculateAttackStrength(StartUp attacker) {
        
        int strength;
        
        Random rand = new Random();
        int min = attacker.getLevel().getXPMin();
        int max = attacker.getLevel().getXPMax();;
        strength = rand.nextInt(max + 1 - min) + min;
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
    private int calculateCriticalAttack(int attackStrength) {
        
        return attackStrength * 2;
    }
    
//    private int calculateDefenseStrength() {
//        
//    }
//    
//    private int calculateDodgeStrength() {
//        
//    }
    
    private boolean calculateAttackSuccess() {
        
        Random rand = new Random();
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = attacker.getAttackSuccessMultiplier() + offset;
        int role = rand.nextInt(max + 1 - min) + min + offset;
        
        if (role <= probability) {
            return true;
        }
        return false;    
    }
    
    private boolean calculateCriticalAttackSuccess() {
        
        Random rand = new Random();
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = attacker.getAttackSuccessMultiplier() + offset;
        int role = rand.nextInt(max + 1 - min) + min + offset;
        
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
