package main.java.world;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.Random;

import main.java.actor.StartUp;

public class Quarter {
    
    final static int Q1 = 1;
    final static int Q2 = 2;
    final static int Q3 = 3;
    final static int Q4 = 4;
    
    final static int FIRST_OF_THE_MONTH = 1;
    final static int LAST_OF_THE_MONTH = 30;
    final static int FIRST_MONTH_OF_THE_QUARTER = 1;
    final static int LAST_MONTH_OF_THE_QUARTER = 3;
    
    private World world;
    
    private int currentQuarter; 
    private int currentDay; 
    private int currentMonth;
    private boolean isEven;
    private boolean isFirstDayOfQuarter;
    private boolean isLastDayOfMonth;
    private boolean finalMoment;
    
    private BigDecimal taxCutPercent;
    
    public Quarter(World world, int currentQuarter, int currentMonth, int currentDay) {
        
        setWorld(world);
        setCurrentQuarter(currentQuarter);
        setCurrentMonth(currentMonth);
        setCurrentDay(currentDay);
        setFirstDayOfQuarter(true);
        calculateCorporateTaxCutPercent();
        Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
    }
    
    private void calculateCorporateTaxCutPercent() {
        
        Random r = new Random();
        double rangeMin = 1.01;
        double rangeMax = 1.05;
        taxCutPercent = new BigDecimal(rangeMin + (rangeMax - rangeMin) * r.nextDouble());     
    }

    public void applyFinancialEvents(StartUp startup){
        
        if (isFirstDayOfQuarter()) {
            
            BigDecimal adjustedRevenue = startup.getRevenue();
            BigDecimal taxRate = startup.getLocation().getTaxRate();
            
            if (currentQuarter == Q1) {
                
                calculateCorporateTaxCutPercent();
                taxRate = applyCorporateTaxCuts(taxRate);   
            }
    
            adjustedRevenue = (deductTaxes(adjustedRevenue, taxRate).setScale(2, RoundingMode.DOWN));  
            
            startup.setRevenue(adjustedRevenue);
        }
    } 
    
    private BigDecimal deductTaxes(BigDecimal adjustedRevenue, BigDecimal taxRate) {
        
        return adjustedRevenue.subtract((adjustedRevenue.multiply((taxRate.multiply(new BigDecimal(0.01))))));
        
    }
    
    private BigDecimal applyCorporateTaxCuts(BigDecimal taxRate) {
        
        BigDecimal adjustedTaxRate = taxRate.subtract(taxCutPercent.subtract(new BigDecimal(1)));
        return adjustedTaxRate;     
    }

    private void incrementQuarter() {
        
        if(currentQuarter >= Q4) {
            
            Printer.print(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has ended and ");
            currentQuarter = Q1;
            Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
            
        } else {
            
            Printer.print(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has ended and ");
            currentQuarter++;
            Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
        }
        
        setFirstDayOfQuarter(true);
    }
    
    private void incrementMonth() {
        
        if (currentMonth >= LAST_MONTH_OF_THE_QUARTER) {
            
            currentMonth = FIRST_MONTH_OF_THE_QUARTER;
            incrementQuarter();
            
        } else {
            
            currentMonth++;
        }
    }
    
    public void incrementDay() {
        
        if(currentDay >= LAST_OF_THE_MONTH) {
            
            getWorld().setPrintTime(true);
            currentDay = FIRST_OF_THE_MONTH;
            incrementMonth();
            this.setLastDayOfMonth(false);
            
        } else {
            
            if (currentDay + 1 >= LAST_OF_THE_MONTH) {
                
                this.setLastDayOfMonth(true);
            }
            
            currentDay++;
            setFirstDayOfQuarter(false);
        }
        
    }
    
    // getters and setters
    
    private void setCurrentDay(int currentDay) {
        
        if(!(currentDay < FIRST_OF_THE_MONTH || currentDay >= LAST_OF_THE_MONTH)) {
            
            this.currentDay = currentDay; 
            
        } else {
            
            this.currentDay = FIRST_OF_THE_MONTH;
        }    
    }

    private void setCurrentQuarter(int currentQuarter) {
        
        if(!(currentQuarter < Q1 || currentQuarter >= Q4)) {
            
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

    public int getCurrentMonth() {
        
        return currentMonth;
    }

    public void setCurrentMonth(int currentMonth) {
        
        this.currentMonth = currentMonth;
    }

    public boolean isFirstDayOfQuarter() {
        
        return isFirstDayOfQuarter;
    }

    public void setFirstDayOfQuarter(boolean isFisrtDayOfQuarter) {
        
        this.isFirstDayOfQuarter = isFisrtDayOfQuarter;
    }

    public boolean isLastDayOfMonth() {
        return isLastDayOfMonth;
    }

    public void setLastDayOfMonth(boolean isLastDayOfMonth) {
        this.isLastDayOfMonth = isLastDayOfMonth;
    }

    public boolean isFinalMoment() {
        return finalMoment;
    }

    public void setFinalMoment(boolean finalMoment) {
        this.finalMoment = finalMoment;
    }

    public World getWorld() {
        return world;
    }

    public void setWorld(World world) {
        this.world = world;
    }
}
