package main.java.marketplace;

import java.math.BigDecimal;
import java.util.Random;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;
import main.java.world.World;

public class Attack {
    
    private StartUp attacker;
    private StartUp defender;
    
    public Attack() {
        
    }
    
    public void talentDrain(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        int strength = calculateAttackStrength(attacker);
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {
            
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
                
                defender.setXP(defender.getXP() / 2);
                
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
        
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to to drain the talent of their competition, but");
            
            if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
        
    
    public void tradeSecretTheft(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
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
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to steal trade secrets, but");
            
            if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
    
    public void politicalBribery(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
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
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("to bribe a corrupt politician, but");

            if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }      
    }
    
    public void undercutPrices(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
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
                Printer.println(" their prices. ");
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName());
                Printer.print(" service cost is now $");
                Printer.print(Printer.ANSI_RED, Double.toString(attacker.getServiceCost()));
                Printer.println(".");
            }
           
        } else {
            
            Printer.print(Printer.ANSI_CYAN, attacker.getName());
            Printer.print(Printer.ANSI_RED, " attempts ");
            Printer.print("attempts to undercut thier prices, but");

            if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
    
    private int calculateAttackStrength(StartUp attacker) {
        
        int strength;
        int min = attacker.getLevel().getXPMin();
        int max = attacker.getLevel().getXPMax();;
        strength = RandomNumber.getRandomBetween(min, max);
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
    private boolean calculateAttackSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = 5 + offset;
        int role = RandomNumber.getRandomBetween(min, max);
        
        System.out.println("attack success: role: " + role + " prob: " + probability);
        
        if (role <= probability) {
            
            return true;
        }
        return false;    
    }
    
    private boolean calculateCriticalAttackSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = attacker.getLevelNumber() - defender.getLevelNumber();
        int probability = 5 + offset;
        int role = RandomNumber.getRandomBetween(min, max);
        
        if (role <= probability) {
            return true;
        }
        return false; 
    }
    
    private void printDodge() {
        
        Printer.print(Printer.ANSI_CYAN, " " + attacker.getName());
        Printer.print(Printer.ANSI_GREEN, " DODGES");
        Printer.println(" the attack!!!");
        defender.setDodge(false);
    }
}
