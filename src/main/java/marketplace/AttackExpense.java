package main.java.marketplace;

public class AttackExpense extends Expense {
    
    public AttackExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Attack Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }

}
