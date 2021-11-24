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
                    developers++;
                    
                } else {
                    
                    attacker.addDev(defender.removeLowestDev());
                    developers++;
                }
            }
        }

        if (critical) {
            
            attacker.getCurrentCompetition().awardCriticalXP(attacker, defender);
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(" delivers a  ");
            Printer.print(Printer.ANSI_RED, "CRITICAL");
            Printer.print(" blow by ");
            Printer.print(Printer.ANSI_RED, "DRAINING");
            Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
            Printer.print(" of valuable talent through stealing ");
            Printer.print(Printer.ANSI_RED, Integer.toString(developers));
            Printer.println(" senior developers!!");
            
        } else {
            
            attacker.getCurrentCompetition().awardXP(attacker, defender);
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
            Printer.print(Printer.ANSI_RED, "DRAINS");
            Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
            Printer.print(" of talent by stealing ");
            Printer.print(Printer.ANSI_RED, Integer.toString(developers));
            Printer.println(" junior developers!!");
        }
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName());
        Printer.print(" now has ");
        Printer.print(Printer.ANSI_GREEN, Integer.toString(attacker.getDevs().size()));
        Printer.print(" developers. ");
        
        Printer.print(Printer.ANSI_CYAN, defender.getName());
        Printer.print(" now has ");
        Printer.print(Printer.ANSI_RED, Integer.toString(defender.getDevs().size()));
        Printer.println(" developers.");
    }
    
    public void tradeSecretTheft(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {
        
            int strength = calculateAttackStrength(attacker);
            int desirability = defender.getDesirability() / 2;
            attacker.increaseDesirability(desirability);
            defender.decreaseDesirability(desirability);
            
            boolean critical = calculateCriticalAttackSuccess();
            
                if (critical) {
                
                int amount = strength * 10000000;
                int duration = strength * 19;
                
                defender.addExpense("Trade Theft", "Legal Battle Expense", strength, 
                        World.world.getCurrentQuarter().getCurrentDay(), duration);
                
                attacker.getCurrentCompetition().awardCriticalXP(attacker, defender);
        
                Printer.print(Printer.ANSI_CYAN, attacker.getName()); 
                Printer.print(" delivers a ");
                Printer.print(Printer.ANSI_RED, "CRITICAL");
                Printer.print(" attack by ");
                Printer.print(Printer.ANSI_RED, "STEALING");
                Printer.print(" a vital ");
                Printer.print(Printer.ANSI_RED, "TRADE SECRET");
                Printer.print(" from ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.println("!!");
                
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" will have to pay monthly legal expenses of ");
                Printer.print(Printer.ANSI_RED, "$" + Integer.toString(amount));
                Printer.print(" for the next ");
                Printer.print(Printer.ANSI_RED, Integer.toString(duration));
                Printer.println(" months!!");
                
            } else {
                
                int amount = strength * 1000000;
                int duration = strength * 7;
                
                defender.addExpense("Trade Theft", "Legal Battle Expense", strength, 
                        World.world.getCurrentQuarter().getCurrentDay(), duration);
                
                attacker.getCurrentCompetition().awardXP(attacker, defender);
        
                Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
                Printer.print(Printer.ANSI_RED, "STEALS");
                Printer.print(" a vital ");
                Printer.print(Printer.ANSI_RED, "TRADE SECRET");
                Printer.print(" from ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.println("!!");
                
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" will have to pay monthly legal expenses of ");
                Printer.print(Printer.ANSI_RED, "$" + Integer.toString(amount));
                Printer.print(" for the next ");
                Printer.print(Printer.ANSI_RED, Integer.toString(duration));
                Printer.println(" months!!");
            }
            
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(" attempts to steal trade secrets,");
            Printer.println(" but fails.");
        }
        
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
                int duration = strength * 19;
                defender.decreaseDesirability(defender.getLevel().getLevelNumber() + 1);
                
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(2)));
                defender.setServiceCost(Math.floor(defender.getServiceCost() * 2));
                defender.addExpense("fee", "Fee", amount,World.world.getCurrentDay(), duration);
                
                attacker.getCurrentCompetition().awardCriticalXP(attacker, defender);
                
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
                
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(4)));
                defender.setServiceCost(Math.floor(defender.getServiceCost() * 1.4));
                defender.addExpense("fee", "Fee", amount, World.world.getCurrentDay(), duration);
                
                attacker.getCurrentCompetition().awardXP(attacker, defender);
                
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
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(" attempts to bribe a corrupt politician,");
            Printer.println(" but fails.");
        }      
    }
    
    public void undercutPrices(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        calculateAttackOutcome();
        
        boolean success = calculateAttackSuccess();
        
        if (success) {
            
            boolean critical = calculateCriticalAttackSuccess();
            
            if (critical) {
                
                attacker.setServiceCost(Math.floor(defender.getServiceCost() / 10) + .99);
                
                attacker.getCurrentCompetition().awardCriticalXP(attacker, defender);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" lands a ");
                Printer.print(Printer.ANSI_RED, "CRITICAL");
                Printer.print(" attack by ");
                Printer.print(Printer.ANSI_RED, "UNDERCUTTING");
                Printer.print(" their prices, gouging");
                Printer.print(" the overall revenue of ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.println("!!");
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" service cost is now $");
                Printer.print(Printer.ANSI_RED, Double.toString(attacker.getServiceCost()));
                Printer.println(".");
                
            } else {
                
                attacker.setServiceCost(Math.floor(defender.getServiceCost() - (defender.getServiceCost() / 5)) + .99);
                
                attacker.getCurrentCompetition().awardXP(attacker, defender);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" attacks ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" by ");
                Printer.print(Printer.ANSI_RED, "UNDERCUTTING");
                Printer.print(" their prices. ");
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" service cost is now $");
                Printer.print(Printer.ANSI_RED, Double.toString(attacker.getServiceCost()));
                Printer.println(".");
            }
           
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(" attempts to undercut thier prices, but");
            Printer.println(" abandons the measure midway through the effort.");
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
