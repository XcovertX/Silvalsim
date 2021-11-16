package main.java.world;

import java.awt.Color;
import java.util.ArrayList;

import main.java.actor.Actor;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.MarketPlace;

public class World {
    
    public static final String ANSI_RESET = "\u001B[0m";
    public static final String ANSI_BLACK = "\u001B[30m";
    public static final String ANSI_RED = "\u001B[31m";
    public static final String ANSI_GREEN = "\u001B[32m";
    public static final String ANSI_YELLOW = "\u001B[33m";
    public static final String ANSI_BLUE = "\u001B[34m";
    public static final String ANSI_PURPLE = "\u001B[35m";
    public static final String ANSI_CYAN = "\u001B[36m";
    public static final String ANSI_WHITE = "\u001B[37m";
    
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
        
        su1.setRevenue(100.00);
        
        tg1.getStartups().add(su1);
        
        actors.add(tg1);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {
        
//        System.out.println("Quarter: " + currentQuarter + " Day: " + currentDay);
        print(ANSI_RED, "This is working.");
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

    public MarketPlace getMarketPalce() {
        return marketPlace;
    }

    public void setMarketPalce(MarketPlace marketPalce) {
        this.marketPlace = marketPalce;
    }
    
    public void print(String color, String s) {
        
        System.out.println(color + s + ANSI_RESET);  
    }
    
    public void print(String s) {
        
        System.out.print(s);
    }
    
    public void println(String color, String s) {
        
        System.out.println(color + s + ANSI_RESET);
    }
    
    public void println(String s) {
        
        System.out.println(s);
    }
    

}
