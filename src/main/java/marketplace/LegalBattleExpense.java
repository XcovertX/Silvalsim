package main.java.marketplace;

/**
 * LegalBattleExpenseExpense.java
 * Package: main.java.marketplace
 * Description: The Legal Battle Expense class generates an 
 * Expense of type 'Legal Battle Expense'
 * Legal Battle Expenses are deducted from Revenue
 * 
 * @author James Covert
 * @version 1.0
 */

public class LegalBattleExpense extends Expense {
    

    /**
     * Description: constructor.
     * 
     * @author James Covert
     * @version 1.0
     */
    public LegalBattleExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Legal Battle Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }

}
