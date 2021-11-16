package main.java.world;

import java.util.Random;

import main.java.actor.StartUp;

public class Quarter {
    
    final static int Q1 = 0;
    final static int Q2 = 1;
    final static int Q3 = 2;
    final static int Q4 = 3;
    
    private int currentQuarter; 
    private int currentDay; 
    private boolean isEven;
    
    private double taxCutPercent;
    
    public Quarter(int currentQuarter, int currentDay) {
        
        setCurrentQuarter(currentQuarter);
        setCurrentDay(currentDay);
        calculateCorporateTaxCutPercent();
    }
    
    private void calculateCorporateTaxCutPercent() {
        
        Random r = new Random();
        double rangeMin = 1.01;
        double rangeMax = 1.05;
        taxCutPercent = rangeMin + (rangeMax - rangeMin) * r.nextDouble();
        
    }

    public void applyFinancialEvents(StartUp startup){
        
        
        double adjustedRevenue = startup.getRevenue();
        double taxRate = startup.getLocation().getTaxRate();
        
        if(currentQuarter == Q1) {
            
            calculateCorporateTaxCutPercent();
            taxRate = applyCorporateTaxCuts(taxRate);
             
        }
        
        adjustedRevenue = deductTaxes(adjustedRevenue, taxRate); 
        startup.setRevenue(adjustedRevenue);
    }
    
    private double deductTaxes(double revenue, double taxRate) {
        
        return revenue - (revenue * (taxRate * 0.01));
        
    }
    
    private double applyCorporateTaxCuts(double taxRate) {
        
        double adjustedTaxRate = taxRate - (taxCutPercent - 1);
        return adjustedTaxRate;
        
    }

    public void incrementQuarter() {
        
        if(currentQuarter >= Q4) {
            
            currentQuarter = Q1;
            
        } else {
            
            currentQuarter++;
        }
    }
    
    public void incrementDay() {
        
        if(currentDay >= 90) {
            
            currentDay = 0;
            incrementQuarter();
            
        } else {
            
            currentDay++;
        }
    }
    
    // getters and setters
    
    private void setCurrentDay(int currentDay) {
        
        if(!(currentDay < 0 || currentDay >= 90)) {
            
            this.currentDay = currentDay; 
            
        } else {
            
            this.currentDay = 0;
        }
        
    }

    private void setCurrentQuarter(int currentQuarter) {
        
        if(!(currentQuarter < 0 || currentQuarter >= 3)) {
            
            this.currentQuarter = currentQuarter; 
            
        } else {
            
            this.currentQuarter = Q1;
        }
        
        setEven();
    }
    
    public int getCurrentQuarter() {
        
        return this.currentQuarter;
    }

    public int getCurrentDay() {
        
        return this.currentDay;
    }

    private boolean isEven() {
        return isEven;
    }

    private void setEven() {

        if((this.currentQuarter % 2) == 0) {
            
            this.isEven = true;
            
        } else {
            
            this.isEven = false;
        }
    }
}
