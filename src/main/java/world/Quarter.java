package main.java.world;

public class Quarter {
    
    final static int Q1 = 0;
    final static int Q2 = 1;
    final static int Q3 = 2;
    final static int Q4 = 3;
    
    private int currentQuarter; 
    private int currentDay; 
    private boolean isEven;
    
    public Quarter(int currentQuarter, int currentDay) {
        
        setCurrentQuarter(currentQuarter);
        setCurrentDay(currentDay);
    }
    
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
    
    public int getCurrentQuarter() {
        
        return this.currentQuarter;
    }

    public int getCurrentDay() {
        
        return this.currentDay;
    }

    public boolean isEven() {
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
