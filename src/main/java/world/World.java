package main.java.world;

import java.util.ArrayList;

import main.java.actor.Actor;
import main.java.actor.Developer;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.Competition;
import main.java.marketplace.MarketPlace;

public class World {
    
    final static int FIRST_OF_THE_MONTH = 0;
    
    private ArrayList<TechGiant> techGiants;
    private Quarter currentQuarter;
    private MarketPlace marketPlace;
    private Competition currentCompetition;
    
    public World() {
        
        techGiants = new ArrayList<TechGiant>();
        currentQuarter = new Quarter(0, 0);
        marketPlace = new MarketPlace();
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        TechGiant tg2 = new TechGiant("Microhard", "Very tiny; Super hard.");
        
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork());
        StartUp su2 = new StartUp("Myspace", "Jenky Pictures", new Washington());
        
        Developer seniorDev1 = new Developer("Steve", "Has grey hair", 10);
        Developer seniorDev2 = new Developer("James", "Has grey hair", 10);
        Developer seniorDev3 = new Developer("Bill", "Has grey hair", 10);
        Developer seniorDev4 = new Developer("Tony", "Has grey hair", 10);
        
        Developer juniorDev1 = new Developer("Steve", "Has grey hair", 1);
        Developer juniorDev2 = new Developer("James", "Has grey hair", 3);
        Developer juniorDev3 = new Developer("Bill", "Has grey hair", 2);
        Developer juniorDev4 = new Developer("Tony", "Has grey hair", 2);
        
        su1.setRevenue(100.00);
        su1.addDev(seniorDev1);
        su1.addDev(seniorDev2);
        su1.addDev(seniorDev3);
        su1.addDev(juniorDev1);
        su1.setRevenue(200.00);
        
        su2.addDev(seniorDev4);
        su2.addDev(juniorDev2);
        su2.addDev(juniorDev3);
        su2.addDev(juniorDev4);
        su2.setRevenue(100.00);
        
        
        tg1.getStartups().add(su1);
        tg2.getStartups().add(su2);
        
        techGiants.add(tg1);
        techGiants.add(tg2);
        
        currentCompetition = new Competition(su1, su2);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {

        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();
        
        printScore(currentCompetition.getOpponentOne());
        printScore(currentCompetition.getOpponentTwo());
    }

    private void updateFinancialEvents() {
        
        if (this.currentQuarter.getCurrentDay() == FIRST_OF_THE_MONTH) {

            for(int i = 0; i < techGiants.size(); i++) {
                
                TechGiant tg = techGiants.get(i);
                
                for(int j = 0; j < tg.getStartups().size(); j++) {
                    
                    StartUp su = tg.getStartups().get(j);
                    
                    this.currentQuarter.applyFinancialEvents(su);
                    
                }
            }
        }
    }
    
    private void updateStartUps() {

        for(int i = 0; i < techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
                for(int k = 0; k < su.getDevs().size(); k++) {
                    
                    Developer dev = su.getDevs().get(k);
                    su.increaseRevenue(dev);
                    su.increaseNetIncome(dev);
                    
                }
                
                su.addFinancialRecord();
            }
        }
    }
    
    private void updateMarketPlace() {
        
        if (currentCompetition != null) {
            
            currentCompetition.combatCycle();
        }
    }
    
    private void printScore(StartUp su) {
        
        Printer.println("");
        Printer.print(Printer.ANSI_CYAN, su.getName());
        Printer.print(" Revenue: ");
        
    }
    
    // getters and setters
    
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
