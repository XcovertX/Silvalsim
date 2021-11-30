package main.java.actor;

import java.math.BigDecimal;

/**
 * Developer.java
 * Package: main.java.actor
 * Description: Developers effect a startup's speed and desirability.
 * The more developers a startup has, the slower they will be
 * but the more desirable the startup will be to attract new customers
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class Developer extends Actor {
    
    public final static int JUNIOR_DEV_TALENT = 1;
    public final static int EXPERIENCED_DEV_TALENT = 5;
    public final static int SENIOR_DEV_TALENT = 10;
    
    private int talent;
    private double salary;
    private double paycheck; 
    
    public Developer(int talent, double salary) {

        this.talent = talent;
        this.salary = salary;
        this.paycheck = Math.floor((salary / 24) * 100) / 100;
    }
    
    // getters and setter

    public int getTalent() {
        
        return talent;
    }

    public void setTalent(int talent) {
        
        this.talent = talent;
    }

    public double getSalary() {
        
        return salary;
    }

    public void setSalary(double salary) {
        
        this.salary = salary;
    }

    public BigDecimal getPaycheck() {
        
        return new BigDecimal(paycheck);
    }

    public void setPaycheck(double paycheck) {
        
        this.paycheck = paycheck;
    }

}
