package main.java.actor;

public class Customer extends Actor {
    
    public final static double LOW_INCOME_AVAILABLE_FUNDS = 50.00;
    public final static double MEDIUM_INCOME_AVAILABLE_FUNDS = 150.00;
    public final static double HIGH_INCOME_AVAILABLE_FUNDS = 1500.00;
    
    private double availableFunds;
    
    public Customer(double availFunds) {
        
        this.availableFunds = availFunds;     
    }
    

    public double getAvailableFunds() {
        return availableFunds;
    }

    public void setAvailableFunds(double availableFunds) {
        this.availableFunds = availableFunds;
    }

}
