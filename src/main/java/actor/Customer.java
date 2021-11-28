package main.java.actor;

import main.java.world.RandomNumber;

public class Customer extends Actor {
    
    public final static double LOW_INCOME_AVAILABLE_FUNDS = 50.00;
    public final static double MEDIUM_INCOME_AVAILABLE_FUNDS = 150.00;
    public final static double HIGH_INCOME_AVAILABLE_FUNDS = 1500.00;
    
    private StartUp subscription;
    
    private double availableFunds;
    private double payAmount;
    private int dueDate;
    
    public Customer(StartUp subscribedTo, double availFunds, int dueDate) {
        
        this.setSubscription(subscribedTo);
        this.availableFunds = availFunds;  
        this.payAmount = availFunds; 
        this.dueDate = dueDate;
    }
    
    public boolean assessSubscription(StartUp competition) {

        int priceDifference = determinePriceDifference(competition);
        int desirability = determineDesirability(competition);
        int talent = determineTalent(competition);
        int total = priceDifference + talent + desirability;
        
        int chance = total * 20;
        int min = 1;
        int max = 100;
        
        int randomNumber = RandomNumber.getRandomBetween(min, max);
        
        if (randomNumber < chance) {
            
            return true;
        }
        return false;
    }
    
    private int determinePriceDifference(StartUp competition) {
        
        return (int) Math.round(subscription.getServiceCost() / competition.getServiceCost());
    }
    
    private int determineDesirability(StartUp competition) {
        
        return (int) Math.round(subscription.getDesirability() / competition.getDesirability());
    }
    
    private int determineTalent(StartUp competition) {
        
        int competitionTalent = competition.getTalentMultiplier();
        
        if (competitionTalent <= 0) {
            
            competitionTalent = 1;
        }
        return (int) Math.round(subscription.getTalentMultiplier() / competitionTalent);
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

    public StartUp getSubscription() {
        
        return subscription;
    }

    public void setSubscription(StartUp subscription) {
        
        this.subscription = subscription;
    }
    
    
}
