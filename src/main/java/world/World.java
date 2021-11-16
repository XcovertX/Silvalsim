package main.java.world;

import java.util.ArrayList;

import main.java.actor.Actor;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.Competition;
import main.java.marketplace.MarketPlace;

public class World {
    
    final static int FIRST_OF_THE_MONTH = 0;
    
    private ArrayList<Actor> actors;
    private Quarter currentQuarter;
    private MarketPlace marketPlace;
    
    public World() {
        
        actors = new ArrayList<Actor>();
        currentQuarter = new Quarter(0, 0);
        marketPlace = new MarketPlace();
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork());

        StartUp su2 = new StartUp("Myspace", "Jenky Pictures", new Washington());
        
        su1.setRevenue(100.00);
        su2.setRevenue(100.00);
        
        tg1.getStartups().add(su1);
        tg1.getStartups().add(su2);
        
        actors.add(tg1);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {
        
        TechGiant meta = ((TechGiant) actors.get(0));
        StartUp instagram = meta.getStartups().get(0);
        StartUp myspace = meta.getStartups().get(1);
        if (this.currentQuarter.getCurrentDay() == FIRST_OF_THE_MONTH) {

            this.currentQuarter.applyFinancialEvents(instagram);
            this.currentQuarter.applyFinancialEvents(instagram);
            
            new Competition(instagram, myspace);
        }
              
    }

    public Quarter getCurrentQuarter() {
        return currentQuarter;
    }

    public void setCurrentQuarter(Quarter currentQuarter) {
        this.currentQuarter = currentQuarter;
    }

    public MarketPlace getMarketPalce() {
        return marketPlace;
    }

    public void setMarketPalce(MarketPlace marketPalce) {
        this.marketPlace = marketPalce;
    }
}
