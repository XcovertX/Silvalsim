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
        TechGiant tg3 = new TechGiant("Saber", "Sab-rey, printers and paper.");
        
        StartUp su1 = new StartUp("Instagram", "Addicting Pictures", new NewYork(), tg1);
        StartUp su2 = new StartUp("Myssspace", "Jenky Pictures", new Washington(), tg1);
        StartUp su3 = new StartUp("Ticky-Tok", "Rapid pictures", new California(), tg2);
        StartUp su4 = new StartUp("Faceybook", "Everyone pictures", new NewYork(), tg2);
        StartUp su5 = new StartUp("DunderMif", "Blank pictures", new Washington(), tg3);
        StartUp su6 = new StartUp("MSPaperCo", "Blank pictures", new California(), tg3);
        
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
        
        su5.addJuniorDevs(12);
        su5.addExperiencedDevs(3);
        su5.addSeniorDevs(2);
        
        su6.addJuniorDevs(1);
        su6.addExperiencedDevs(1);
        su6.addSeniorDevs(3);
        
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
        
        su5.addLowIncomeCustomers(10340);
        su5.addMediumIncomeCustomers(334);
        su5.addHighIncomeCustomers(205);
        
        su6.addLowIncomeCustomers(30011);
        su6.addMediumIncomeCustomers(4315);
        su6.addHighIncomeCustomers(2905);
        
        // setting up initial service costs for startups
        su1.setServiceCost(15.99);
        su2.setServiceCost(30.99);
        su3.setServiceCost(5.99);
        su4.setServiceCost(20.99);
        su5.setServiceCost(1.99);
        su6.setServiceCost(40.99);
        
        // setting initial revenue level
        su1.setRevenue(new BigDecimal(1000000.00));
        su2.setRevenue(new BigDecimal(1000000.00));
        su3.setRevenue(new BigDecimal(1000000.00));
        su4.setRevenue(new BigDecimal(1000000.00));
        su5.setRevenue(new BigDecimal(1000000.00));
        su6.setRevenue(new BigDecimal(1000000.00));
        
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
        
        su5.addExpense("fee", "Fee", 1500, 51, 24);
        su5.addExpense("fee", "Fee", 3000, 7, 24);
        su5.addExpense("fee", "Fee", 12000, 2, 3);
        su5.addExpense("fee", "Fee", 2000, 11, 36);
        
        su6.addExpense("fee", "Fee", 2500, 15, 24);
        su6.addExpense("fee", "Fee", 7900, 7, 24);
        su6.addExpense("fee", "Fee", 6000, 70, 3);
        su6.addExpense("fee", "Fee", 5000, 14, 36);
        
        //setting initial desirability
        su1.setDesirability(100);
        su2.setDesirability(100);
        su3.setDesirability(100);
        su4.setDesirability(100);
        su5.setDesirability(100);
        su6.setDesirability(100);
        
        tg1.getStartups().add(su1);
        tg1.getStartups().add(su2);
        tg2.getStartups().add(su3);
        tg2.getStartups().add(su4);
        tg3.getStartups().add(su5);
        tg3.getStartups().add(su6);
        
        techGiants.add(tg1);
        techGiants.add(tg2);
        techGiants.add(tg3);
        
        this.updateStartUps();
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
        Printer.println(Printer.ANSI_PURPLE, "*                       Total Domination Achieved                              *");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        
        Printer.println("");
        for (int i = 0; i < world.getTechGiants().size(); i++) {
            
            TechGiant tg = world.getTechGiants().get(i);
            if (tg.getStartups().size() > 0) {
                Printer.print(Printer.ANSI_CYAN, tg.getName());
                Printer.println(" is the WINNER!!");

                Printer.print(Printer.ANSI_CYAN, tg.getName());
                Printer.println(" owns every startup: ");
                for (int j = 0; j < tg.getStartups().size(); j++) {
                    
                    StartUp su = tg.getStartups().get(j);
                    
                    if ( 1 + j <= tg.getStartups().size()) {
                      
                        Printer.print(Printer.ANSI_CYAN, su.getName() + ", ");
                    }
                }
                Printer.println("");
            }
        }  

        Printer.println(Printer.ANSI_YELLOW, "Exiting SILVALSIM......");
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
                
                Printer.print("Cycle: " + getCurrentQuarter().getCurrentCycle());
                Printer.print(" Quarter: " + getCurrentQuarter().getCurrentQuarter());
                Printer.print(" Month: " + getCurrentQuarter().getCurrentMonth());
                Printer.println(" Day: " + getCurrentQuarter().getCurrentDay());
                
                Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");

                currentCompetition.printScore(currentCompetition.getOpponentOne());
                currentCompetition.printScore(currentCompetition.getOpponentTwo());
                Printer.println("");
                setPrintTime(false);  
            }
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
