package main.java.world;

import java.util.ArrayList;

import main.java.actor.Actor;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;

public class World {
    
    final static int FIRST_OF_THE_MONTH = 0;
    
    private ArrayList<Actor> actors;
    private Quarter currentQuarter;
    
    public World() {
        
        actors = new ArrayList<Actor>();
        currentQuarter = new Quarter(0, 0);
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork());
        
        su1.setRevenue(100.00);
        
        tg1.getStartups().add(su1);
        
        actors.add(tg1);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {
        
//        System.out.println("Quarter: " + currentQuarter + " Day: " + currentDay);
        TechGiant meta = ((TechGiant) actors.get(0));
        StartUp instagram = meta.getStartups().get(0);
        if (this.currentQuarter.getCurrentDay() == FIRST_OF_THE_MONTH) {

            this.currentQuarter.applyFinancialEvents(instagram);
        }
              
    }

    public Quarter getCurrentQuarter() {
        return currentQuarter;
    }

    public void setCurrentQuarter(Quarter currentQuarter) {
        this.currentQuarter = currentQuarter;
    }
}
