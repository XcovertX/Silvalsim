package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.world.Printer;
import main.java.world.RandomNumber;
import main.java.world.World;

/**
 * Attack.java
 * Package: main.java.marketplace
 * Description: The Attack class is used by an offensive StartUp in competition
 * to attack their opposition
 * 
 * @author James Covert
 */

public class Attack {
    
    private StartUp attacker;   // offensive StartUp
    private StartUp defender;   // defensive StartUp
    
    public Attack() {
        
    }
    
    /**
     * Description: This method removes talented developers from the competition.
     * and adds them to the attacker's staff.
     * This decreases potential the amount of xp the opponent can gain through attacks and battles.
     * This also decreases the opponents overall desirability, effecting customer gains.
     * However, a negative part of this attack is that it will increase the opponents speed,
     * allowing the opponent to retailed with numerous attacks.
     * It first calculates the strength of the attack
     * It then calculates if the attack is successful
     * If the attack is successful it determines if the attack is critical
     * If attack is critical, it removes Senior devs from opponent
     * and reduces opponent xp to it's level's base xp
     * and awards critical xp to attacker
     * If attack is not critical, it removes junior devs from opponent
     * and awards xp to attacker
     * It then adds an attack expense to the attacker, 
     * deducting funds from the attackers netIncome to finance the attack.
     * If the attacker lacks sufficient funds (netIncome)
     * to finance the attack, the attack will fail.
     * Likewise, the attack will fail if the attacker if attackSucces is false
     * It then prints the appropriate message for resulting attack
     * 
     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying the attack
     * @param defender - the startup receiving the attack
     */
    public void talentDrain(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        int strength = calculateAttackStrength(attacker);
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {
            
            boolean critical = calculateCriticalAttackSuccess();
            
            int developers = 0;
            
            for (int i = 0; i < strength; i++) {
                
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
                
                defender.setXp(defender.getLevel().getBaseNumber());
                
                attacker.getCurrentCompetition().awardCriticalXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {
                    
                    generateAttackExpense();
                }
                
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
                
                attacker.getCurrentCompetition().awardXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {
                    
                    generateAttackExpense();
                }
                
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
            
            if (attacker.getNetIncome().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentAttackFunds();
                
            } else if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
        
    /**
     * Description: This method 'steals' a trade secret from it's competitor.
     * This has the effect immediately decreasing the opponents revenue.
     * It first calculates if the attack is successful
     * It then calculates the strength of the attack
     * If the attack is successful it determines if the attack is critical
     * If the attack is critical, it removes desirability 1/2 of the opponents desirability
     * It then add a strong amount of legal expenses to the opponents expense list
     * It then awards critical xp to the attacker
     * If the attack is not critical, it removes desirability 1/4 of the opponents desirability
     * It then add a less strong amount of legal expenses to the opponents expense list
     * It then awards xp to the attacker
     * It then prints the appropriate message
     * It then adds an attack expense to the attacker, 
     * deducting funds from the attackers netIncome to finance the attack.
     * If the attacker lacks sufficient funds (netIncome)
     * to finance the attack, the attack will fail.
     * Likewise, the attack will fail if the attacker if attackSucces is false
     * It then prints the appropriate message for resulting attack
     * 
     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying the attack
     * @param defender - the startup receiving the attack
     */
    public void tradeSecretTheft(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {
        
            int strength = calculateAttackStrength(attacker);
            
            boolean critical = calculateCriticalAttackSuccess();
            
            if (critical) {
                
                int desirability = defender.getDesirability() / 2;
                attacker.increaseDesirability(desirability);
                defender.decreaseDesirability(desirability);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());

                int duration = strength * 19;
                for (int i = 0; i < numberOfExpenses; i++) {
                    
                    defender.addExpense("Trade Theft", "Legal Battle Expense", strength, 
                            World.world.getCurrentQuarter().getCurrentDay(), duration);
                    generateAttackExpense();
                }
                
                attacker.getCurrentCompetition().awardCriticalXp(attacker, defender);
                
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
                
                int amount = strength * 1000000;
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.print(" will have to pay monthly legal expenses of ");
                Printer.print(Printer.ANSI_RED, "$" + Integer.toString(amount));
                Printer.print(" for the next ");
                Printer.print(Printer.ANSI_RED, Integer.toString(duration));
                Printer.println(" months!!");
                
            } else {
                
                int desirability = defender.getDesirability() / 4;
                attacker.increaseDesirability(desirability);
                defender.decreaseDesirability(desirability);
                
                int duration = strength * 7;

                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {
                    
                    defender.addExpense("Trade Theft", "Legal Battle Expense", strength, 
                            World.world.getCurrentQuarter().getCurrentDay(), duration);
                    generateAttackExpense();
                }
                
                attacker.getCurrentCompetition().awardXp(attacker, defender);
                
                Printer.print(Printer.ANSI_CYAN, attacker.getName() + " ");
                Printer.print(Printer.ANSI_RED, "STEALS");
                Printer.print(" a vital ");
                Printer.print(Printer.ANSI_RED, "TRADE SECRET");
                Printer.print(" from ");
                Printer.print(Printer.ANSI_CYAN, defender.getName());
                Printer.println("!!");
                
                int amount = strength * 100000;
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
            
            if (attacker.getNetIncome().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentAttackFunds();
                
            } else if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
    
    /**
     * Description: This method 'bribes' a corrupt politician which adds.
     * fees to the opponent
     * It first calculates if the attack is successful
     * It then calculates the strength of the attack
     * If the attack is successful it determines if the attack is critical
     * If the attack is critical, it reduces opponent's desirability by attackers desirability
     * It then add a strong amount of legal expenses to the opponents expense list
     * It then reduces opponent's revenue by 1/2
     * It then increases opponent's service cost by 2
     * It then awards critical xp to the attacker
     * If the attack is not critical, it reduces desirability by 5x the attcker's level number
     * It then reduces opponent's revenue by 1/4
     * It then increases opponent's service cost by 1.4
     * It then awards xp to the attacker
     * It then prints the appropriate message
     * It then adds an attack expense to the attacker, 
     * deducting funds from the attackers netIncome to finance the attack.
     * If the attacker lacks sufficient funds (netIncome)
     * to finance the attack, the attack will fail.
     * Likewise, the attack will fail if the attacker if attackSucces is false
     * It then prints the appropriate message for resulting attack
     * 
     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying the attack
     * @param defender - the startup receiving the attack
     */
    public void politicalBribery(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        
        boolean attackSuccess = calculateAttackSuccess();
        
        if (attackSuccess) {

            int strength = calculateAttackStrength(attacker);
            boolean attackCritical = calculateCriticalAttackSuccess();
            
            if (attackCritical) {
                
                int amount = strength * 1000000;
                int duration = strength * 19;
                
                defender.decreaseDesirability(attacker.getLevel().getLevelNumber() * 10);
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(2)));
                defender.setServiceCost(Math.floor(defender.getServiceCost() * 2));
                
                attacker.getCurrentCompetition().awardCriticalXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {

                    defender.addExpense("fee", "Fee", 
                            amount, World.world.getCurrentDay(), duration);
                    generateAttackExpense();
                }
                
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
                
                int amount = strength * 100000;
                int duration = strength * 5;
                
                defender.decreaseDesirability(attacker.getLevel().getLevelNumber() * 5);
                defender.decreaseRevenue(defender.getRevenue().divide(new BigDecimal(4)));
                defender.setServiceCost(Math.floor(defender.getServiceCost() * 1.4));
                
                attacker.getCurrentCompetition().awardXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {

                    defender.addExpense("fee", "Fee", 
                            amount, World.world.getCurrentDay(), duration);
                    generateAttackExpense();
                }
                
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

            if (attacker.getNetIncome().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentAttackFunds();
                
            } else if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }      
    }

    /**
     * Description: This method undercuts the attackers service cost. 
     * to attract more customers from the opponent
     * It first calculates if the attack is successful
     * It then calculates the strength of the attack
     * If the attack is successful it determines if the attack is critical
     * If the attack is critical, it reduces attacker's service cost to 1/10
     * of the opponent's service cost
     * It then awards critical xp to the attacker
     * If the attack is not critical, it reduces attacker's service cost to 1/5
     * of the opponent's service cost
     * It then awards xp to the attacker
     * It then prints the appropriate message
     * It then adds an attack expense to the attacker, 
     * deducting funds from the attackers netIncome to finance the attack.
     * If the attacker lacks sufficient funds (netIncome)
     * to finance the attack, the attack will fail.
     * Likewise, the attack will fail if the attacker if attackSucces is false
     * It then prints the appropriate message for resulting attack
     * 
     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying the attack
     * @param defender - the startup receiving the attack
     */
    public void undercutPrices(StartUp attacker, StartUp defender) {
        
        this.attacker = attacker;
        this.defender = defender;
        boolean success = calculateAttackSuccess();
        
        if (success) {
            
            boolean critical = calculateCriticalAttackSuccess();
            
            if (critical) {
                
                attacker.setServiceCost(Math.floor(defender.getServiceCost() / 10) + .99);
                
                attacker.getCurrentCompetition().awardCriticalXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {
                    int newRevenue = RandomNumber
                            .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                    attacker.increaseRevenue(new BigDecimal(100000 * newRevenue));
                    generateAttackExpense();
                }
                
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
                
                attacker.setServiceCost(Math.floor(defender.getServiceCost() 
                        - (defender.getServiceCost() / 5)) + .99);
                
                attacker.getCurrentCompetition().awardXp(attacker, defender);
                
                int numberOfExpenses = RandomNumber
                        .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                
                for (int i = 0; i < numberOfExpenses; i++) {
                    int newRevenue = RandomNumber
                            .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
                    attacker.increaseRevenue(new BigDecimal(10000 * newRevenue));
                    generateAttackExpense();
                }
                
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

            if (attacker.getNetIncome().compareTo(new BigDecimal(0)) <= 0) {
                
                insufficentAttackFunds();
                
            } else if (defender.dodgeSuccess()) {
                
                printDodge();
            
            } else {
                
                Printer.print(Printer.ANSI_RED, " fails");
                Printer.println(".");
            }
        }
        
    }
    
    /**
     * Description: This method calculates the attack strength.
     * The method will not allow an attack strength to be less that 1

     * @author James Covert
     * @version 1.0
     * @param attacker - the startup deploying the attack
     * @return int - strength of the attack
     */
    private int calculateAttackStrength(StartUp attacker) {
        
        int strength;
        int min = attacker.getLevel().getXpMin();
        int max = attacker.getLevel().getXpMax();;
        strength = RandomNumber.getRandomBetween(min, max);
        
        if (strength < 1) {
            
            strength = 1;
        }
        
        return strength;
        
    }
    
    /**
     * Description: This method calculates if the attack is successful or not.
     * 
     * @author James Covert
     * @version 1.0
     * @return boolean - true if netIncome > 0 and role <= probability
     */
    private boolean calculateAttackSuccess() {
        
        if (attacker.getNetIncome().compareTo(new BigDecimal(0)) <= 0) {
            
            return false;
        }
        
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
    
    /**
     * Description: This method calculates if the attack is critical or not.
     * 
     * @author James Covert
     * @version 1.0
     * @return boolean - true if role <= probability
     */
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
    
    /**
     * Description: This method prints message if the opponent dodges the attack.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void printDodge() {
        
        Printer.print(Printer.ANSI_CYAN, " " + attacker.getName());
        Printer.print(Printer.ANSI_GREEN, " DODGES");
        Printer.println(" the attack!!!");
        defender.setDodge(false);
    }
    
    /**
     * Description: This method generates attack expenses (deducted from netIncome).
     * 
     * @author James Covert
     * @version 1.0
     */
    private void generateAttackExpense() {
        
        int randomNumber = RandomNumber
                .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
        int duration = RandomNumber
                .getRandomBetween(attacker.getXpMin(), attacker.getXpMax());
        double cost = randomNumber * attacker.getAttackCostMultiplier() 
                * defender.getLevelNumber() * 1000000;
        cost = cost / (duration * 30);
        attacker.addExpense("attack expense", "Attack Expense", 
                cost, World.world.getCurrentDay(), duration);
    }
    
    /**
     * Description: This method prints message if the attacker has.
     * insufficient funds (netIncome) to deploy a successful attack
     * If insufficient funds are detected, liquidate command is automatically called
     * 
     * @author James Covert
     * @version 1.0
     */
    private void insufficentAttackFunds() {
        
        Printer.print(Printer.ANSI_CYAN, " " + attacker.getName());
        Printer.print(Printer.ANSI_RED, " LACKS");
        Printer.println(" sufficient funds to attack!!!");
        
        attacker.setServiceCost(attacker.getServiceCost() * 2);
        
        Printer.print(Printer.ANSI_CYAN, attacker.getName());
        Printer.print(" service cost is now $");
        Printer.print(Printer.ANSI_GREEN, Double.toString(attacker.getServiceCost()));
        Printer.println(".");
        
        new LiquidateCommand(attacker, defender).execute();  
    }
}
