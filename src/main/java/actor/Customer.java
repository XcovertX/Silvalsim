package main.java.actor;

import main.java.world.RandomNumber;

/**
 * Customer.java
 * Package: main.java.actor
 * Description: Customers provide the source for revenue. Startups
 * compete for Customers to subscribe to their service.
 * 
 * @author James Covert
 * @version 1.0
 */

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
    
    /**
     * Description: If startup the customer is subscribed to is competing,
     * This method is called once a month on the subscription due date.
     * It allows the customer to determine to whether they would like to pay the subscription cost
     * or switch to the competetor's service. It does this by weighing the 
     * price difference, desirability difference and talent difference
     * 
     * @author James Covert
     * @version 1.0
     * @param competition - competition startUp
     * @return boolean - true is customer should switch
     */
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
    
    /**
     * Description: calculates price difference
     * 
     * @author James Covert
     * @version 1.0
     * @param competition - comp startup
     * @return int -difference
     */
    private int determinePriceDifference(StartUp competition) {
        
        return (int) Math.round(subscription.getServiceCost() / competition.getServiceCost());
    }
    
    /**
     * Description: calculates desirability difference
     * 
     * @author James Covert
     * @version 1.0
     * @param competition - comp startup
     * @return int - difference
     */
    private int determineDesirability(StartUp competition) {
        
        return (int) Math.round(subscription.getDesirability() / competition.getDesirability());
    }
    
    /**
     * Description: calculates talent difference
     * 
     * @author James Covert
     * @version 1.0
     * @param competition -competition strup
     * @return int - difference
     */
    private int determineTalent(StartUp competition) {
        
        int competitionTalent = competition.getTalentMultiplier();
        
        if (competitionTalent <= 0) {
            
            competitionTalent = 1;
        }
        return (int) Math.round(subscription.getTalentMultiplier() / competitionTalent);
    }
    
    /**
     * Description: simulates customer income
     * 
     * @author James Covert
     * @version 1.0
     */
    public void payDay() {
        
        this.availableFunds += this.payAmount;  
    }
    
    // getters and setters
    
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

    public StartUp getSubscription() {
        
        return subscription;
    }

    public void setSubscription(StartUp subscription) {
        
        this.subscription = subscription;
    }  
}
