package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;
import main.java.world.World;

/**
 * Defend.java
 * Package: main.java.marketplace
 * Description: The defend class is used by an defensive StartUp in competition
 * to defend against their opposition
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class Defend {
    
    private StartUp attacker;
    private StartUp defender; 
    private boolean hailMary;
    
    public Defend() {
        
    }
    
    /**
     * Description: This method deploys an advertising campaign to attract new customers
     * 
     * It then calculates if the defense is successful
     * If the defense is successful it determines if the defense is critical
     * If defense is critical, it calculates it's strengeth
     * and adds strength number of new customer to the defender
     * It then adds desirability to defender
     * It then generates the dense expense (deducted from marketShare)
     * If defense is not critical, it calculates it's strengeth
     * and adds strength number of new customer to the defender
     * It then adds desirability to defender
     * It then generates the dense expense,
     * deducting funds from the defender's marketShare to finance the defense.
     * If the defender lacks sufficient funds (marketShare) to finance the defense, the defense will fail.
     * Likewise, the defense will fail if the defenderSuccess returns false
     * It then prints the appropriate message for resulting defense
     * 
     * @author James Covert
     * @version 1.0
     * @param StartUp defender - the startup deploying the defense
     * @param StartUp attacker - the startup receiving the defense
     * @return void
     *-----------------------------------------------------
     */
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
                
                defender.increaseDesirability(defender.getLevelNumber() * 10);
                
                generateDefenseExpense();
                
                Printer.print(Printer.ANSI_CYAN, defender.getName() + " ");
                Printer.print(Printer.ANSI_GREEN, "DEFENDS");
                Printer.print(" by deploying an aggressive add campaign obtaining ");
                Printer.print(Printer.ANSI_GREEN, Integer.toString(strength));
                Printer.println(" new customers!!");
                
            } else {
                
                int strength = calculateDefenseStrength(defender) * defender.getLevelNumber();
                
                defender.addMediumIncomeCustomers(strength);
                
                defender.increaseDesirability(defender.getLevelNumber() * 5);
                
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
    
    /**
     * Description: This method deploys an recruiting campaign to attract new devs.
     * 
     * It calculates if the defense is successful
     * If the defense is successful it determines if the defense is critical
     * If defense is critical, it calculates it's strength
     * and adds strength number of new senior and experienced devs to the defender
     * It then generates the dense expense (deducted from marketShare)
     * If defense is not critical, it calculates it's strengeth
     * and adds strength number of new junior and experienced devs to the defender
     * It then generates the dense expense,
     * deducting funds from the defender's marketShare to finance the defense.
     * If the defender lacks sufficient funds (marketShare) to finance the defense, the defense will fail.
     * Likewise, the defense will fail if the defenderSuccess returns false
     * It then prints the appropriate message for resulting defense
     * 
     * @author James Covert
     * @version 1.0
     * @param StartUp defender - the startup deploying the defense
     * @param StartUp attacker - the startup receiving the defense
     * @return void
     *-----------------------------------------------------
     */
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
    
    /**
     * Description: This method liquidates assets
     * 
     * It then calculates if the defense is successful
     * If hailMary is set to true, the liquidate will be successful
     * It calculates it's strength
     * It will then remove some expenses and fees
     * It then will reduce Devs to 1 devs
     * If not hailmary, it will calculate strength
     * It will then remove some expenses and fees
     * It then will reduce Devs to 1/4 the number of devs
     * It then generates the dense expense,
     * deducting funds from the defender's marketShare to finance the defense.
     * If the defender lacks sufficient funds (marketShare) to finance the defense, the defense will fail.
     * Likewise, the defense will fail if the defenderSuccess returns false
     * It then prints the appropriate message for resulting defense
     * 
     * @author James Covert
     * @version 1.0
     * @param StartUp defender - the startup deploying the defense
     * @param StartUp attacker - the startup receiving the defense
     * @return void
     *-----------------------------------------------------
     */
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
    
    /**
     * Description: This method activates a dodge for the defender.
     * next time an attack is made against the defender, the defender will dodge it.
     * 
     * @author James Covert
     * @version 1.0
     * @param StartUp defender - the startup deploying the defense
     * @param StartUp attacker - the startup receiving the defense
     * @return void
     *-----------------------------------------------------
     */
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
    
    /**
     * Description: This method calculates the defense strength
     * 
     * The method will not allow an defense strength to be less that 1

     * @author James Covert
     * @version 1.0
     * @param StartUp defender - the startup deploying the defense
     * @return int - strength of the defense
     *-----------------------------------------------------
     */
    private int calculateDefenseStrength(StartUp defender) {
        
        int strength;
        
        int min = defender.getLevel().getXPMin();
        int max = defender.getLevel().getXPMax();;
        strength = RandomNumber.getRandomBetween(min, max);
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
    /**
     * Description: This method calculates if the defense is critical or not
     * 
     * @author James Covert
     * @version 1.0
     * @return boolean - true if role <= probability
     *-----------------------------------------------------
     */
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
    
    /**
     * Description: This method calculates if the defense is successful or not
     * 
     * @author James Covert
     * @version 1.0
     * @return boolean - true if netIncome > 0 and role <= probability
     *-----------------------------------------------------
     */
    private boolean calculateDefenseSuccess() {
        
        if (defender.getMarketShare().compareTo(new BigDecimal(0)) <= 0) {
            
            return false;
        }
        
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
    
    /**
     * Description: This method prints message if defense fails
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void printFail() {
        
        Printer.print(Printer.ANSI_CYAN, defender.getName());
        Printer.print(Printer.ANSI_RED, " attempts ");
        Printer.print("to defend against inbound attacks,");
        Printer.print(" but the defense ");
        Printer.print(Printer.ANSI_RED, "fails");
        Printer.println(".");  
    }
    
    /**
     * Description: This method generates defense expenses (deducted from MarketShare)
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void generateDefenseExpense() {
        
        int randomNumber = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
        int duration = RandomNumber.getRandomBetween(defender.getXPMin(), defender.getXPMax());
        double cost = randomNumber * defender.getAttackCostMultiplier() * attacker.getLevelNumber() * 1000000;
        cost = cost / (duration * 30);
        defender.addExpense("defense expense", "Defense Expense", cost, World.world.getCurrentDay(), duration);
    }
    
    /**
     * Description: This method prints message if the defense has 
     * insufficient funds (marketShare) to deploy a successful defense
     * 
     * If insufficient funds are detected, hailmary is set to true
     *  and the liquidate command is automatically called
     * a
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
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
