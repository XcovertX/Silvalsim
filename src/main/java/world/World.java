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
        
        setCurrentDay(0);
        
        TechGiant tg1 = new TechGiant("Meta", "Taking over the world one face at a time.");
        TechGiant tg2 = new TechGiant("Microhard", "Very tiny; Super hard.");
        
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork(), tg1);
        StartUp su2 = new StartUp("Myssspace", "Jenky Pictures", new Washington(), tg2);
        StartUp su3 = new StartUp("DunderMif", "Blank pictures", new California(), tg2);
        StartUp su4 = new StartUp("Faceybook", "Everyone pictures", new NewYork(), tg1);
        
        // adding devs to startups
        su1.addJuniorDevs(10);
        su1.addExperiencedDevs(22);
        su1.addSeniorDevs(13);
        
        su2.addJuniorDevs(2);
        su2.addExperiencedDevs(14);
        su2.addSeniorDevs(3);
        
        su3.addJuniorDevs(11);
        su3.addExperiencedDevs(12);
        su3.addSeniorDevs(3);
        
        su4.addJuniorDevs(19);
        su4.addExperiencedDevs(20);
        su4.addSeniorDevs(13);
        
        // adding customers to startups
        su1.addLowIncomeCustomers(30000);
        su1.addMediumIncomeCustomers(1500);
        su1.addHighIncomeCustomers(1000);
        
        su2.addLowIncomeCustomers(20000);
        su2.addMediumIncomeCustomers(12000);
        su2.addHighIncomeCustomers(10300);
        
        su3.addLowIncomeCustomers(10000);
        su3.addMediumIncomeCustomers(330);
        su3.addHighIncomeCustomers(1200);
        
        su4.addLowIncomeCustomers(50000);
        su4.addMediumIncomeCustomers(2304);
        su4.addHighIncomeCustomers(1205);
        
        // setting up initial service costs for startups
        su1.setServiceCost(15.99);
        su2.setServiceCost(30.99);
        su3.setServiceCost(5.99);
        su4.setServiceCost(20.99);
        
        // setting initial revenue level
        su1.setRevenue(new BigDecimal(1000000.00));
        su2.setRevenue(new BigDecimal(1000000.00));
        su3.setRevenue(new BigDecimal(1000000.00));
        su4.setRevenue(new BigDecimal(1000000.00));
        
        // setting initial expenses
        su1.addExpense("fee", "Fee", 1500, 5, 24);
        su1.addExpense("fee", "Fee", 7500, 7, 24);
        su1.addExpense("fee", "Fee", 1000, 2, 3);
        su1.addExpense("fee", "Fee", 5000, 14, 36);
        su1.addExpense("fee", "Fee", 1000, 2, 3);
        su1.addExpense("fee", "Fee", 5000, 14, 36);
        
        su2.addExpense("fee", "Fee", 1000, 9, 24);
        su2.addExpense("fee", "Fee", 7500, 21, 24);
        su2.addExpense("fee", "Fee", 800, 22, 3);
        su2.addExpense("fee", "Fee", 50000, 29, 36);
        
        su3.addExpense("fee", "Fee", 1500, 5, 24);
        su3.addExpense("fee", "Fee", 7500, 7, 24);
        su3.addExpense("fee", "Fee", 1000, 2, 3);
        su3.addExpense("fee", "Fee", 5000, 14, 36);
        
        su4.addExpense("fee", "Fee", 1000, 9, 24);
        su4.addExpense("fee", "Fee", 7500, 21, 24);
        su4.addExpense("fee", "Fee", 800, 22, 3);
        su4.addExpense("fee", "Fee", 50000, 29, 36);
        su4.addExpense("fee", "Fee", 1000, 9, 24);
        su4.addExpense("fee", "Fee", 7500, 21, 24);
        su4.addExpense("fee", "Fee", 800, 22, 3);
        su4.addExpense("fee", "Fee", 50000, 29, 36);
        su4.addExpense("fee", "Fee", 1000, 9, 24);
        su4.addExpense("fee", "Fee", 7500, 21, 24);
        su4.addExpense("fee", "Fee", 800, 22, 3);
        su4.addExpense("fee", "Fee", 50000, 29, 36);
        
        su1.setDesirability(100);
        su2.setDesirability(100);
        su3.setDesirability(100);
        su4.setDesirability(100);
        
        tg1.getStartups().add(su1);
        tg2.getStartups().add(su2);
        tg1.getStartups().add(su3);
        tg2.getStartups().add(su4);
        
        techGiants.add(tg1);
        techGiants.add(tg2);
        
        this.updateStartUps();
        
        findCompetitors();
   
    }

    public void updateWorld(int currentQuarter, int currentDay) {

        setCurrentDay(currentDay);
        
        updateCustomers();
        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();
    
        if (this.currentCompetition == null) {
      
            findCompetitors();
        }
//        if (this.currentCompetition == null) {
//            System.exit(1);
//        }
    }

    private void findCompetitors() {
        
        StartUp su1 = null;
        StartUp su2 = null;
        
        for(int i = 0; i < this.techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                if (!tg.getStartups().isEmpty()) {
                    
                    StartUp su = tg.getStartups().get(j);
                    
                    if ((su1 == null)) {
                        
                        su1 = su;
                        break;
                        
                    } else if ((su2 == null)) {
                        
                        su2 = su;
                        break;
                    }
                }
            }
        }
        
        if (su2 == null) {
            
            Printer.println("");
            Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
            Printer.println(Printer.ANSI_PURPLE, "*                       Total Domination Achieved                              *");
            Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
            
            Printer.println("");

            Printer.print(Printer.ANSI_CYAN, su1.getTechGiant().getName());
            Printer.println(Printer.ANSI_YELLOW, " now owns all startups... exiting the matrix......");
            Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
            
            System.exit(1);
        
        } else {
            
            
            currentCompetition = new Competition(this, su1, su2);
        }
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
                su.addFinancialRecord();
            }
        }
    }
    
    public void updateMarketPlace() {
        
        if (currentCompetition != null) {
                
            currentCompetition.combatCycle();
            
            if (isPrintTime()) {
                
                Printer.println("");
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
                Printer.println(Printer.ANSI_PURPLE, "*                              Monthly Summary                                 *");
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
                
                currentCompetition.printScore(currentCompetition.getOpponentOne());
                currentCompetition.printScore(currentCompetition.getOpponentTwo());
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
