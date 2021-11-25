package main.java.marketplace;

public class GeneralExpense extends Expense {

    public GeneralExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("General Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }
}
