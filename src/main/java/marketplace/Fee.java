package main.java.marketplace;

public class Fee extends Expense {
    
    public Fee(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Fee");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }
}
