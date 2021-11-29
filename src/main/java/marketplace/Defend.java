package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;
import main.java.world.World;

public class Defend {
    
    private StartUp attacker;
    private StartUp defender; 
    private boolean hailMary;
    
    public Defend() {
        
    }
    
    public void advertise(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            boolean critical = calculateCriticalDefenseSuccess();
            
            if (critical) {
            
                int strength = calculateDefenseStrength(defender)
                        * defender.getLevelNumber() + defender.getDesirability();
                    
                defender.addMediumIncomeCustomers(strength);
                
                generateDefenseExpense();
                
                Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
                Printer.print(Printer.ANSI_GREEN, "DEFENDS");
                Printer.print(" by deploying an aggressive add campaign obtaining ");
                Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
                Printer.println(" new customers!!");
                
            } else {
                
                int strength = calculateDefenseStrength(defender) * defender.getLevelNumber();
                
                defender.addMediumIncomeCustomers(strength);
                
                generateDefenseExpense();
                
                Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
                Printer.print(Printer.ANSI_GREEN, "DEFENDS");
                Printer.print(" by deploying an aggressive add campaign obtaining ");
                Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
                Printer.println(" new customers!!");
                
            }
        
        } else {
            
            if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentDefenseFunds();
                
            } else {
            
                printFail();
            
            }
        }
    }
    public void recruitTalent(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defender.getDevs().size() > defender.getLevelNumber()) {
            
            defenseSuccess = false;
        }
        
        if (defenseSuccess) {
            
            boolean critical = calculateCriticalDefenseSuccess();
            
            if (critical) {
            
                int strength = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
                
                
                defender.addExperiencedDevs(strength / 2);
                defender.addSeniorDevs(strength / 2);
                
                generateDefenseExpense();
                
                Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
                Printer.print(Printer.ANSI_GREEN, "DEFENDS");
                Printer.print(" by recruiting ");
                Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
                Printer.println(" new developers!!");
            
            } else {
                
                int strength = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
                
                defender.addJuniorDevs(strength / 2);
                defender.addExperiencedDevs(strength / 4);
                defender.addSeniorDevs(strength / 4);
                
                generateDefenseExpense();
                
                Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
                Printer.print(Printer.ANSI_GREEN, "DEFENDS");
                Printer.print(" by recruiting ");
                Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
                Printer.println(" new developers!!");
                
            }
        
        } else {
            
            if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentDefenseFunds();
                
            } else {
            
                printFail();
            
            }
        }
    }
    
    public void liquidate(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess || isHailMary()) {
            
            int strength = 0;
            if (isHailMary()) {
                
                strength = RandomNumber.getRandomBetween(1, defender.getDevs().size());
                defender.removeExpenses(defender.getLevelNumber() + 2, "Fee");
                defender.removeExpenses(defender.getLevelNumber() + 2, "Legal Battle Expense");
                
            } else {
                
                int max = (defender.getDevs().size() / 4);
                
                if (max < 1) {
                    
                    max = 1;
                }
                strength = RandomNumber.getRandomBetween(1, max);

                defender.removeExpenses(defender.getLevelNumber(), "Fee");
                defender.removeExpenses(defender.getLevelNumber(), "Legal Battle Expense");
            }
            
            int counter = 0;
            for(int i = 0; i < defender.getDevs().size(); i++) {
    
                if (counter < strength) {
                    
                    if (isHailMary()) {
                        
                        defender.removeTopDev();
                        counter++;
                        
                    } else {
                        
                        defender.removeLowestDev();
                        counter++;
                    }
                    
                } else {
                    
                    break;
                }
            }
            
            generateDefenseExpense();
            
            Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
            Printer.print(Printer.ANSI_GREEN, "DEFENDS");
            Printer.print(" by liquidating assets and laying off ");
            Printer.print(Printer.ANSI_RED, Integer.toString(strength));
            Printer.println(" developers!!");
        
        } else {
            
            if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentDefenseFunds();
                
            } else {
            
                printFail();
            
            }
        }
    }
    
    public void dodge(StartUp defender, StartUp attacker) {
        
        this.defender = defender;
        this.attacker = attacker;
        
        boolean defenseSuccess = calculateDefenseSuccess();
        
        if (defenseSuccess) {
            
            defender.setDodge(true);
            
            generateDefenseExpense();
            
            Printer.print(Printer.ANSI_CYAN, defender.getName());
            Printer.print(" positions themselves to ");
            Printer.print(Printer.ANSI_GREEN, "DEFEND");
            Printer.println(" against the next attack!!");
        
        } else {
            
            if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentDefenseFunds();
                
            } else {
            
                printFail();
            
            }
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
    
    private boolean calculateCriticalDefenseSuccess() {
        
        int min = 0;
        int max = 10;
        int offset = defender.getLevelNumber() - attacker.getLevelNumber();
        int probability = 5 + offset;
        int role = RandomNumber.getRandomBetween(min, max);
        
        if (role <= probability) {
            return true;
        }
        return false; 
    }
    
    private boolean calculateDefenseSuccess() {
        
        if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
            
            return false;
        }
        
        int min = 0;
        int max = 10;
        int offset = defender.getLevelNumber() - attacker.getLevelNumber();
        int probability = 5 + offset;
        int role = RandomNumber.getRandomBetween(min, max);
        
//        System.out.println("defense success: role: " + role + " prob: " + probability);
        
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
    
    private void generateDefenseExpense() {
        
        int randomNumber = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
        int duration = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
        double cost = randomNumber * defender.getAttackCostMultiplier() * attacker.getLevelNumber() * 1000000;
        cost = cost / (duration * 30);
        defender.addExpense("defense expense", "Defense Expense", cost, World.world.getCurrentDay(), duration);
    }
    
    private void insufficentDefenseFunds() {
        
        Printer.print(Printer.ANSI_CYAN, " " + defender.getName());
        Printer.print(Printer.ANSI_RED, " LACKS");
        Printer.println(" sufficient funds to defend against the attack!!!");
        
        defender.setServiceCost(defender.getServiceCost() * 2);
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName());
        Printer.print(" service cost is now $");
        Printer.print(Printer.ANSI_GREEN, Double.toString(defender.getServiceCost()));
        Printer.println(".");
        
        setHailMary(true);
        liquidate(defender, attacker); 
        setHailMary(false);
    }

    public boolean isHailMary() {
        
        return hailMary;
    }

    public void setHailMary(boolean hailMary) {
        
        this.hailMary = hailMary;
    }
}
