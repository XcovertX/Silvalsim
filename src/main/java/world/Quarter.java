package main.java.world;

import java.math.BigDecimal;

import java.math.RoundingMode;
import java.util.Random;

/**
 * Quarter.java
 * Package: main.java.world
 * Description: Quarter keeps track of time.
 * 
 * @author James Covert
 * @version 1.0
 */

import main.java.actor.StartUp;

public class Quarter {
    
    static final int Q1 = 1;
    static final int Q2 = 2;
    static final int Q3 = 3;
    static final int Q4 = 4;
    
    static final int FIRST_OF_THE_MONTH = 1;
    static final int LAST_OF_THE_MONTH = 30;
    static final int FIRST_MONTH_OF_THE_QUARTER = 1;
    static final int LAST_MONTH_OF_THE_QUARTER = 3;

    private int currentCycle;
    private int currentQuarter; 
    private int currentDay; 
    private int currentMonth;
    private boolean isEven;
    private boolean isFirstDayOfQuarter;
    private boolean isLastDayOfMonth;
    private boolean finalMoment;
    
    private BigDecimal taxCutPercent;
    
    /**
     * Description: Quarter constructor set the current Quarter, Month, and Day.
     * 
     * @author James Covert
     * @version 1.0
     * @param currentQuarter - quarter number
     * @param currentMonth - month number
     * @param currentDay - day number
     */
    public Quarter(int currentQuarter, int currentMonth, int currentDay) {

        setCurrentCycle(0);
        setCurrentQuarter(currentQuarter);
        setCurrentMonth(currentMonth);
        setCurrentDay(currentDay);
        setFirstDayOfQuarter(true);
        calculateCorporateTaxCutPercent();
        Printer.println("");
        Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
    }
    
    /**
     * Description:This method calculates Tax Cut Percent to be applied when tax cuts are granted.
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     */
    private void calculateCorporateTaxCutPercent() {
        
        Random r = new Random();
        double rangeMin = 1.01;
        double rangeMax = 1.05;
        taxCutPercent = new BigDecimal(rangeMin + (rangeMax - rangeMin) * r.nextDouble());     
    }

    /**
     * Description:This method calculates Tax Cut Percent to be applied when tax cuts are granted.
     * 
     * @author James Covert
     * @version 1.0
     * @param startup - startup to apply tax write off to
     */
    public void applyFinancialEvents(StartUp startup) {
        
        if (isFirstDayOfQuarter()) {
            
            BigDecimal adjustedRevenue = startup.getRevenue();
            BigDecimal taxRate = startup.getLocation().getTaxRate();
            
            if (currentQuarter == Q1) {
                
                calculateCorporateTaxCutPercent();
                taxRate = applyCorporateTaxCuts(taxRate);   
            }
    
            adjustedRevenue = (deductTaxes(adjustedRevenue, taxRate)
                    .setScale(2, RoundingMode.DOWN));  
            
            startup.setRevenue(adjustedRevenue);
        }
    } 
    
    /**
     * Description:This method deducts the taxes.
     * 
     * @author James Covert
     * @version 1.0
     * @param adjustedRevenue - revenue to have taxes withdrawn from
     * @param taxRate - deduction rate
     * @return BigDecimal - revenue minus taxes
     */
    private BigDecimal deductTaxes(BigDecimal adjustedRevenue, BigDecimal taxRate) {
        
        return adjustedRevenue.subtract((adjustedRevenue.multiply((
                taxRate.multiply(new BigDecimal(0.01))))));
        
    }
    
    /**
     * Description:This method applies corporate tax cuts.
     * 
     * @author James Covert
     * @version 1.0
     * @param taxRate - current deduction rate
     * @return BigDecimal - new tax rate
     */
    private BigDecimal applyCorporateTaxCuts(BigDecimal taxRate) {
        
        BigDecimal adjustedTaxRate = taxRate.subtract(taxCutPercent.subtract(new BigDecimal(1)));
        return adjustedTaxRate;     
    }

    /**
     * Description:This method increments the quarter.
     * It also prints the appropriate message when the quarter changes.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void incrementQuarter() {
        
        if (currentQuarter >= Q4) {
            
            Printer.println("");
            Printer.print(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has ended and ");
            currentQuarter = Q1;
            currentCycle++;
            Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
            
        } else {
            
            Printer.print(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has ended and ");
            currentQuarter++;
            Printer.println(Printer.ANSI_YELLOW, "QUARTER " + currentQuarter + " has begun.");
        }
        
        setFirstDayOfQuarter(true);
    }
    
    /**
     * Description:This method increments the month.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void incrementMonth() {
        
        if (currentMonth >= LAST_MONTH_OF_THE_QUARTER) {
            
            currentMonth = FIRST_MONTH_OF_THE_QUARTER;
            incrementQuarter();
            
        } else {
            
            currentMonth++;
        }
    }
    
    /**
     * Description:This method increments the day.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void incrementDay() {
        
        if (currentDay >= LAST_OF_THE_MONTH) {
            
            World.world.setPrintTime(true);
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
    
    /**
     * Description: This method prints a time stamp.
     * It also prints the appropriate message when the quarter changes.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void printTimeStamp() {
        
        Printer.print("Cycle: " + currentCycle);
        Printer.print(" Quarter: " + currentQuarter);
        Printer.print(" Month: " + currentMonth);
        Printer.println(" Day: " + currentDay);
    }
    
    // getters and setters
    
    private void setCurrentDay(int currentDay) {
        
        if (!(currentDay < FIRST_OF_THE_MONTH || currentDay >= LAST_OF_THE_MONTH)) {
            
            this.currentDay = currentDay; 
            
        } else {
            
            this.currentDay = FIRST_OF_THE_MONTH;
        }    
    }

    private void setCurrentQuarter(int currentQuarter) {
        
        if (!(currentQuarter < Q1 || currentQuarter >= Q4)) {
            
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

        if ((this.currentQuarter % 2) == 0) {
            
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

    public int getCurrentCycle() {
        return currentCycle;
    }

    public void setCurrentCycle(int currentCycle) {
        this.currentCycle = currentCycle;
    }
}
