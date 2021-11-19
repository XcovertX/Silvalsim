package main.java.actor;

public class Customer extends Actor {
    
    public final static double LOW_INCOME_AVAILABLE_FUNDS = 50.00;
    public final static double MEDIUM_INCOME_AVAILABLE_FUNDS = 150.00;
    public final static double HIGH_INCOME_AVAILABLE_FUNDS = 1500.00;
    
    private double availableFunds;
    private double payAmount;
    private int dueDate;
    
    public Customer(double availFunds, int dueDate) {
        
        this.availableFunds = availFunds;  
        this.payAmount = availFunds; 
        this.dueDate = dueDate;
    }
    
    public double getAvailableFunds() {
        
        return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        
        this.availableFunds = availableFunds;
    }

    public int getDueDate() {
        
        return dueDate;
    }

    public void setDueDate(int dueDate) {
        
        this.dueDate = dueDate;
    }
    
    public void payDay() {
        
        this.availableFunds += this.payAmount;
        
    }
    
    
}
