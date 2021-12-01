package main.java.marketplace;

/**
 * Fee.java
 * Package: main.java.marketplace
 * Description: The Fee class generates an Expense of type 'Fee'
 * Fees are deducted from Revenue
 * 
 * @author James Covert
 * @version 1.0
 */

public class Fee extends Expense {
    
    /**
     * Description: constructor.
     * 
     * @author James Covert
     * @version 1.0
     */
    public Fee(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Fee");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }
}
