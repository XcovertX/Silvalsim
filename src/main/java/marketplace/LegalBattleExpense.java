package main.java.marketplace;

public class LegalBattleExpense extends Expense {
    
    public LegalBattleExpense(String name, double amount, int dueDate, int duration) {
        
        this.setName(name);
        this.setType("Legal Battle Expense");
        this.setCost(amount);
        this.setDueDate(dueDate);
        this.setDuration(duration);
        this.setNumberOfTimesPaid(0);
    }

}
