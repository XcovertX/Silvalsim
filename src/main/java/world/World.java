package main.java.world;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Random;

import main.java.actor.Actor;
import main.java.actor.Customer;
import main.java.actor.Developer;
import main.java.actor.StartUp;
import main.java.actor.StartUpFactory;
import main.java.actor.TechGiant;
import main.java.actor.TechGiantFactory;
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
        
        setCurrentDay(0);
        
        TechGiantFactory tgf = new TechGiantFactory();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        
        StartUpFactory suf = new StartUpFactory();
        suf.generateStartUp("PhoneTech");
//        suf.generateStartUp("PhoneTech");
//        suf.generateStartUp("OperatingSystems");
        suf.generateStartUp("GameTech");
        suf.generateStartUp("SocialMedia");
//        suf.generateStartUp("GameTech");
        suf.generateStartUp("PhoneTech");
        suf.generateStartUp("OperatingSystems");
//        suf.generateStartUp("GameTech");
        suf.generateStartUp("FinancialTech");
//        suf.generateStartUp("FinancialTech");
        
        this.updateStartUps();
    }

    public void updateWorld(int currentQuarter, int currentDay) {

        setCurrentDay(currentDay);
        
        updateCustomers();
        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();
    }

    private void findCompetitors() {
        
        StartUp su1 = null;
        StartUp su2 = null;
        
        for (int i = 0; i < this.techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            if (!tg.getStartups().isEmpty()) {

                if ((su1 == null)) {
                    
                    su1 = getCompetitor(tg);
                    
                } else if ((su2 == null)) {
                    
                    su2 = getCompetitor(tg);
                }
            }
            
            if (su1 != null && su2 != null) {
                
                Printer.println("");
                Printer.println("Finding new competitors...");
                
                for (int j = 0; j < 75; j++) {
                    
                    Printer.print("=");
                    try {
                        
                        Thread.sleep(50);
                        
                    } catch (InterruptedException e) {
                        
                        e.printStackTrace();
                    }
                }
                Printer.println(" Match FOUND!");

                currentCompetition = new Competition(this, su1, su2);
                return;
            }
        }
   
        Printer.println("");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        Printer.print(Printer.ANSI_PURPLE, "*");
        Printer.print                        ("                         Total Domination Achieved                            ");
        Printer.println(Printer.ANSI_PURPLE, "*");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        for (int i = 0; i < world.getTechGiants().size(); i++) {
            
            TechGiant tg = world.getTechGiants().get(i);
            if (tg.getStartups().size() > 0) {
                Printer.print(Printer.ANSI_CYAN, tg.getName());
                Printer.println(" is the WINNER!!");

                Printer.print(Printer.ANSI_CYAN, tg.getName());
                Printer.println(" owns every startup: ");
                for (int j = 0; j < tg.getStartups().size(); j++) {
                    
                    StartUp su = tg.getStartups().get(j);
                    
                    Printer.print(Printer.ANSI_CYAN, su.getName());
                    if ( 1 + j < tg.getStartups().size()) {
                      
                        Printer.print(", ");
                    }
                }
                Printer.println("");
            }
        }  

        Printer.println("");
        Printer.println("Exiting SILVALSIM......");
        Printer.println("");
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        
        System.exit(0);
        
    }
    
    private StartUp getCompetitor(TechGiant tg) {
        
        if (tg.getStartups().isEmpty()) {
            return null;
        }
        
        return tg.getStartups().get(0);
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
                        su.decreaseNetIncome(dev.getPaycheck());
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
                
                int k = 0;
                while (k < su.getCustomers().size()) {
                    
                    Customer customer = su.getCustomers().get(k);
                    
                    if (currentQuarter.getCurrentDay() == 1) {
                        
                        customer.payDay();
                    }
                    
                    if (customer.getDueDate() == currentQuarter.getCurrentDay() ) {
                        
                        if (!(su.getCurrentCompetition() == null)) {
                            
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
                    }
                    su.collectPayment(customer);
                    k++; 
                }
            }
        }
    }
    
    public void updateMarketPlace() {
        
        if (this.currentCompetition == null) {
            
            findCompetitors();
        }
    
        if (currentCompetition != null) {
            
            currentCompetition.combatCycle();
        }
        
        if (currentCompetition != null) {
            
//            if (isPrintTime()) {
                
                
                
                Printer.println("");
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
                Printer.print(Printer.ANSI_PURPLE, "*");
                Printer.print                        ("                                   Summary                                    ");
                Printer.println(Printer.ANSI_PURPLE, "*");
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
                
                Printer.print("Cycle: " + getCurrentQuarter().getCurrentCycle());
                Printer.print(" Quarter: " + getCurrentQuarter().getCurrentQuarter());
                Printer.print(" Month: " + getCurrentQuarter().getCurrentMonth());
                Printer.println(" Day: " + getCurrentQuarter().getCurrentDay());
                
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");

                currentCompetition.printScore(currentCompetition.getOpponentOne());
                currentCompetition.printScore(currentCompetition.getOpponentTwo());
                Printer.println("");
                setPrintTime(false);  
//            }
        }
        
        int i = 0;
        while (i < techGiants.size()) {
            
            if (techGiants.get(i).isAlive() == false) {

                techGiants.remove(i);
                
            } else {
                
                i++;
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
    
    public ArrayList<TechGiant> getTechGiants() {
        
        return this.techGiants;
    }
}
