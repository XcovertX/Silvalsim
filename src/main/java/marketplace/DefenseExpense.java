package main.java.marketplace;

/**
 * DefenseExpense.java
 * Package: main.java.marketplace
 * Description: The Defense Expense class generates an Expense of type 'Defense Expense'
 * 
 * Defense Expenses are deducted from marketShare
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class DefenseExpense extends Expense {
    
    public DefenseExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Defense Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }

}
