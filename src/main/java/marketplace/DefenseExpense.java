package main.java.marketplace;

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
