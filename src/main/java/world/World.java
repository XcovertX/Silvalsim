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
    
    public static World world;
    
    final static int FIRST_OF_THE_MONTH = 1;
    
    private ArrayList<TechGiant> techGiants;
    private Quarter currentQuarter;
    private int currentDay;
    private MarketPlace marketPlace;
    private Competition currentCompetition;
    private boolean printTime;
    
    public int Icounter = 0;
    public int Mcounter = 0;
    
    public World() {
        
        world = this;
        
        techGiants = new ArrayList<TechGiant>();
        currentQuarter = new Quarter(this, 1, 1, 1);
        marketPlace = new MarketPlace();
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        TechGiant tg2 = new TechGiant("Microhard", "Very tiny; Super hard.");
        
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork());
        StartUp su2 = new StartUp("Myssspace", "Jenky Pictures", new Washington());
        
        su1.addJuniorDevs(1);
        su1.addExperiencedDevs(2);
        su1.addSeniorDevs(1);
        
        su2.addJuniorDevs(2);
        su2.addExperiencedDevs(2);
        su2.addSeniorDevs(3);
        
        su1.addLowIncomeCustomers(30000);
        su1.addMediumIncomeCustomers(1500);
        su1.addHighIncomeCustomers(1000);
        
        su2.addLowIncomeCustomers(20000);
        su2.addMediumIncomeCustomers(12000);
        su2.addHighIncomeCustomers(10300);
        
        su1.setServiceCost(15.99);
        su2.setServiceCost(20.99);
        
        su1.setRevenue(new BigDecimal(1000000.00));
        su2.setRevenue(new BigDecimal(1000000.00));
        
        su1.addExpense("fee", "Fee", 1500, 5, 24);
        su1.addExpense("fee", "Fee", 7500, 7, 24);
        su1.addExpense("fee", "Fee", 1000, 2, 3);
        su1.addExpense("fee", "Fee", 5000, 14, 36);
        
        su2.addExpense("fee", "Fee", 1000, 9, 24);
        su2.addExpense("fee", "Fee", 7500, 21, 24);
        su2.addExpense("fee", "Fee", 800, 22, 3);
        su2.addExpense("fee", "Fee", 50000, 29, 36);
        
        su1.setDesirability(100);
        su2.setDesirability(100);
        
        tg1.getStartups().add(su1);
        tg2.getStartups().add(su2);
        
        techGiants.add(tg1);
        techGiants.add(tg2);
        
        this.updateStartUps();
        
        currentCompetition = new Competition(this, su1, su2);
        setCurrentDay(0);
        
    }

    public void updateWorld(int currentQuarter, int currentDay) {

        setCurrentDay(currentDay);
        
        updateCustomers();
        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();
        
//        if (this.currentCompetition == null) {
//            System.exit(1);
//        }
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
                    
                    if (currentQuarter.getCurrentDay() == 1 ||
                        currentQuarter.getCurrentDay() == 15) {
                        
                        Developer dev = su.getDevs().get(k);
                        su.decreaseRevenue(dev.getPaycheck());
                    }
                }
                su.deductExpenses();
                su.addFinancialRecord();
            }
        }
    }
    
    private void updateCustomers() {

        for(int i = 0; i < techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
//                for(int k = 0; k < su.getCustomers().size(); k++) {
                int k = 0;
                while (k < su.getCustomers().size()) {
                    
//                    System.out.println("k = " + k);
                    Customer customer = su.getCustomers().get(k);
                    
                    if (currentQuarter.getCurrentDay() == 1) {
                        
                        customer.payDay();
                    }
                    
                    if (customer.getDueDate() == currentQuarter.getCurrentDay() ) {
                        
                        if (su.equals(currentCompetition.getOpponentOne())) {

                            boolean shouldSwitchService = customer.assessSubscription(currentCompetition.getOpponentTwo());
                        
                            if (shouldSwitchService) {
                                
                                Customer transferingCustomer = su.getCustomers().remove(k);
                                currentCompetition.getOpponentTwo().addCustomer(transferingCustomer);
                                k--;
                                
                            }
                            
                        } else if (su.equals(currentCompetition.getOpponentTwo())) {
                            
                            boolean shouldSwitchService = customer.assessSubscription(currentCompetition.getOpponentOne());
                           
                            if (shouldSwitchService) {
                                
                                Customer transferingCustomer = su.getCustomers().remove(k);
                                currentCompetition.getOpponentOne().addCustomer(transferingCustomer);
                                k--;
                                
                            }
                        
                        }
                    }
                    su.collectPayment(customer);
                    k++; 
                }
                su.addFinancialRecord();
            }
        }
    }
    
    public void updateMarketPlace() {
        
        if (currentCompetition != null) {
                
            currentCompetition.combatCycle();
            
            if (isPrintTime()) {
                
                Printer.println("");
                Printer.println(Printer.ANSI_PURPLE, "*************************************************");
                Printer.println(Printer.ANSI_PURPLE, "*                Monthly Summary                *");
                Printer.println(Printer.ANSI_PURPLE, "*************************************************");
                
                currentCompetition.printScore(currentCompetition.getOpponentOne());
                currentCompetition.printScore(currentCompetition.getOpponentTwo());
                Printer.println(Printer.ANSI_PURPLE, "*************************************************");
                Printer.println("");
                setPrintTime(false);
                
            }
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

    public boolean isPrintTime() {
        return printTime;
    }

    public void setPrintTime(boolean printTime) {
        this.printTime = printTime;
    }

    public int getCurrentDay() {
        return currentDay;
    }

    public void setCurrentDay(int currentDay) {
        this.currentDay = currentDay;
    }
}
