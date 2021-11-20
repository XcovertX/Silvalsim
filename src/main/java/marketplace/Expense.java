package main.java.marketplace;

public abstract class Expense {
    
    private String name;
    private String type;
    private double cost;
    private int dueDate;
    private int duration;
    private int numberOfTimesPaid;
    
    
    public void incrementNumberOfTimesApplied() {
        
        this.numberOfTimesPaid++;
    }
    
    public String getType() {
        
        return type;
    }
    
    public void setType(String type) {
        
        this.type = type;
    }
    
    public double getCost() {
        
        return cost;
    }
    
    public void setCost(double cost) {
        
        this.cost = cost;
    }
    
    public String getName() {
        
        return name;
    }
    
    public void setName(String name) {
        
        this.name = name;
    }
    
    public int getDueDate() {
        
        return dueDate;
    }
    
    public void setDueDate(int dueDate) {
        
        this.dueDate = dueDate;
    }
    
    public int getDuration() {
        
        return duration;
    }
    
    public void setDuration(int duration) {
        
        this.duration = duration;
    }

    public int getNumberOfTimesPaid() {
        
        return numberOfTimesPaid;
    }

    public void setNumberOfTimesPaid(int numberOfTimesPaid) {
        
        this.numberOfTimesPaid = numberOfTimesPaid;
    }
}
