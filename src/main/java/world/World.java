package main.java.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import main.java.actor.Actor;
import main.java.actor.Customer;
import main.java.actor.Developer;
import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.Competition;
import main.java.marketplace.MarketPlace;

public class World {
    
    final static int FIRST_OF_THE_MONTH = 1;
    
    private ArrayList<TechGiant> techGiants;
    private Quarter currentQuarter;
    private MarketPlace marketPlace;
    private Competition currentCompetition;
    
    public int Icounter = 0;
    public int Mcounter = 0;
    
    public World() {
        
        techGiants = new ArrayList<TechGiant>();
        currentQuarter = new Quarter(1, 1, 1);
        marketPlace = new MarketPlace();
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        TechGiant tg2 = new TechGiant("Microhard", "Very tiny; Super hard.");
        
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork());
        StartUp su2 = new StartUp("Myspace", "Jenky Pictures", new Washington());
        
        su1.addJuniorDevs(10);
        su1.addExperiencedDevs(8);
        su1.addSeniorDevs(4);
        
        su2.addJuniorDevs(14);
        su2.addExperiencedDevs(2);
        su2.addSeniorDevs(3);
        
        su1.addLowIncomeCustomers(30000);
        su1.addMediumIncomeCustomers(150);
        su1.addHighIncomeCustomers(10);
        
        su2.addLowIncomeCustomers(30);
        su2.addMediumIncomeCustomers(15);
        su2.addHighIncomeCustomers(10);
        
        su1.setServiceCost(15.99);
        su2.setServiceCost(13.99);
        
        su1.setRevenue(new BigDecimal(100.00));
        su2.setRevenue(new BigDecimal(100.00));
        
        tg1.getStartups().add(su1);
        tg2.getStartups().add(su2);
        
        techGiants.add(tg1);
        techGiants.add(tg2);
        
        this.updateStartUps();
        
        currentCompetition = new Competition(this, su1, su2);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {

        if (techGiants.get(0).getStartups().get(0).getRevenue().compareTo(new BigDecimal(10000000)) > 0) {
            System.exit(1);
        }
        
        if (Icounter > 100000) {
            System.exit(1);
        }
        
        updateCustomers();
        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();

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
                
                BigDecimal tempRevenue = su.getRevenue();
                for(int k = 0; k < su.getDevs().size(); k++) {
                    
                    
                    if (currentQuarter.getCurrentDay() == 1 ||
                        currentQuarter.getCurrentDay() == 15) {
                        
                        Developer dev = su.getDevs().get(k);
                        tempRevenue = su.payDev(tempRevenue, dev);
                    }
                }
//                su.increaseNetIncome(tempRevenue);
                su.addFinancialRecord();
            }
        }
    }
    
    private void updateCustomers() {

        for(int i = 0; i < techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
                for(int k = 0; k < su.getCustomers().size(); k++) {
                    
                    Customer customer = su.getCustomers().get(k);
                    
                    if (currentQuarter.getCurrentDay() == 1) {
                        
                        customer.payDay();
                    }
                    
                    
                    
                    if (customer.getDueDate() == currentQuarter.getCurrentDay() ) {
                        
                        su.collectPayment(customer);
                        
//                        if (su.getName().equals("Instagram")) {
//                            Icounter++;
//                        }
//                        
//                        if (su.getName().equals("Myspace")) {
//                            Mcounter++;
//                        }
                    }
                }
//                if (su.getName().equals("Instagram")) {
//                    System.out.println(su.getName() + " has made " + Icounter + " collections by day: " + this.getCurrentQuarter().getCurrentDay() + ". rev: " + su.getRevenue());
//                }
//                
//                if (su.getName().equals("Myspace")) {
//                    System.out.println(su.getName() + " has made " + Mcounter + " collections by day: " + this.getCurrentQuarter().getCurrentDay() + ". rev: " + su.getRevenue());
//                }
                
                su.addFinancialRecord();
            }
        }
    }
    
    private void updateMarketPlace() {
        
        if (currentCompetition != null) {
            
            currentCompetition.combatCycle();
        }
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
    
    public void setCurrentCompetition(Competition competition) {
        
        this.currentCompetition = competition;
    }
    
    public Competition getCurrentCompetition() {
        
        return this.currentCompetition;
    }
}
