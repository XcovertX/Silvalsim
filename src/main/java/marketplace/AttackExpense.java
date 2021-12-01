package main.java.marketplace;

/**
 * AttackExpense.java
 * Package: main.java.marketplace
 * Description: The Attack Expense class generates an Expense of type 'Attack Expense'
 * Attack Expense are deducted from netIncome
 * 
 * @author James Covert
 * @version 1.0
 */

public class AttackExpense extends Expense {
    

    /**
     * Description: constructor.
     * 
     * @author James Covert
     * @version 1.0
     */
    public AttackExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Attack Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }

}
