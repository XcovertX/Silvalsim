package main.java.marketplace;

public class Fee extends Expense {
    
    public Fee(String name, String type, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType(type);
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
    }
}
