package main.java.marketplace;

/**
 * GeneralExpense.java
 * Package: main.java.marketplace
 * Description: The General Expense class generates an Expense of type 'General Expense'
 * General Expenses are deducted from Revenue
 * 
 * @author James Covert
 * @version 1.0
 */

public class GeneralExpense extends Expense {

    /**
     * Description: constructor.
     * 
     * @author James Covert
     * @version 1.0
     */
    public GeneralExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("General Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }
}
