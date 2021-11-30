package main.java.world;

import java.util.ArrayList;
import main.java.actor.Customer;
import main.java.actor.Developer;
import main.java.actor.StartUp;
import main.java.actor.StartUpFactory;
import main.java.actor.TechGiant;
import main.java.actor.TechGiantFactory;
import main.java.marketplace.Competition;

/**
 * World.java
 * Package: main.java.world
 * Description: The StartUp class is the main stage class. This class houses
 * the current competition and it updates every object within the world.
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class World {
    
    public static World world;
    
    final static int FIRST_OF_THE_MONTH = 1;
    final static int FIRST_PAYDAY = 1;
    final static int SECOND_PAYDAY = 15;
    
    private ArrayList<TechGiant> techGiants;    // all TechGiants
    private Quarter currentQuarter;             // time tracking
    private int currentDay;                     // current day of the month
    private Competition currentCompetition;     // current competition
    private boolean printTime;                  // ready to print
    
    /**
     * Description: The world constructor instantiates the ArrayList holding all TechGiants
     * It then uses TechGiantfactory to generate TechGiants
     * and a startUpFactory to generate an assortment of different StartUps
     * 
     * @author James Covert
     * @version 1.0
     *-----------------------------------------------------
     */
    public World() {
        
        world = this;
        
        techGiants = new ArrayList<TechGiant>();
        currentQuarter = new Quarter(1, 1, 1);
        
        setCurrentDay(0);
        
        TechGiantFactory tgf = new TechGiantFactory();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        tgf.generateTechGiant();
        
        StartUpFactory suf = new StartUpFactory();
        suf.generateStartUp("PhoneTech");
        suf.generateStartUp("PhoneTech");
        suf.generateStartUp("OperatingSystems");
        suf.generateStartUp("GameTech");
        suf.generateStartUp("SocialMedia");
        suf.generateStartUp("GameTech");
        suf.generateStartUp("PhoneTech");
        suf.generateStartUp("OperatingSystems");
        suf.generateStartUp("GameTech");
        suf.generateStartUp("FinancialTech");
        suf.generateStartUp("FinancialTech");
    }

    /**
     * Description: This method is used to update everything within the world.
     * Once a day, it calls updateCustomers(), updateFinancialEvents(),
     * updateStartUps(), updateMarketPlace()
     * 
     * @author James Covert
     * @version 1.0
     * @param int currentDay - use to update the current day
     * @return void
     *-----------------------------------------------------
     */
    public void updateWorld(int currentDay) {

        setCurrentDay(currentDay);
        
        updateCustomers();
        updateFinancialEvents();
        updateStartUps();
        updateMarketPlace();
    }

    /**
     * Description: This method is called if the currentCompetions is found to be null;
     * It find new competitors among the existing TechGiants. 
     * If a single TechGiant owns all of the startups, the ends the simulation
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
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

                currentCompetition = new Competition(su1, su2);
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
                int counter = 0;
                for (int j = 0; j < tg.getStartups().size(); j++) {
                    
                    StartUp su = tg.getStartups().get(j);
                    
                    Printer.print(Printer.ANSI_CYAN, su.getName());
                    if ( 1 + j < tg.getStartups().size()) {
                      
                        Printer.print(", ");
                    }
                    
                    if (counter > 2) {
                        
                        Printer.println("");
                        counter = 0;
                        
                    } else {
                        
                        counter++;
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
    
    /**
     * Description: This method retrieves a StartUp from a TechGiant.
     * If a TechGiant does not have a startup, it returns null.
     * 
     * @author James Covert
     * @version 1.0
     * @param TechGiant tg - TechGiant owning the startup
     * @return StartUp - first StartUp in the collection
     * @return null - if  collection is empty
     *-----------------------------------------------------
     */
    private StartUp getCompetitor(TechGiant tg) {
        
        if (tg.getStartups().isEmpty()) {
            return null;
        }
        
        return tg.getStartups().get(0);
    }

    /**
     * Description: This method applies any scheduled 
     * financial events to the StartUp.
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
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
    
    /**
     * Description: This method updates each StartUp in the world.
     * It pays all devs on payDays
     * It deducts expenses owed.
     * It tracks all income via Financial Record Entries
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void updateStartUps() {

        for(int i = 0; i < techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
                for(int k = 0; k < su.getDevs().size(); k++) {
                    
                    if (currentQuarter.getCurrentDay() == FIRST_PAYDAY ||
                        currentQuarter.getCurrentDay() == SECOND_PAYDAY) {
                        
                        Developer dev = su.getDevs().get(k);
                        su.decreaseNetIncome(dev.getPaycheck());
                    }
                }
                su.deductExpenses(); 
                su.addFinancialRecord();
            }
        }
    }
    
    /**
     * Description: This method updates each Customer in the world.
     * It simulates a pay day for the customer.
     * If a customers subscription payment is due, it causes the customer to assess
     * whether they should switch to a competitor or not.
     * It collects all payments for the subscription (revenue)
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void updateCustomers() {

        for(int i = 0; i < techGiants.size(); i++) {
            
            TechGiant tg = techGiants.get(i);
            
            for(int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
                int k = 0;
                while (k < su.getCustomers().size()) {
                    
                    Customer customer = su.getCustomers().get(k);
                    
                    if (currentQuarter.getCurrentDay() == FIRST_PAYDAY ||
                        currentQuarter.getCurrentDay() == SECOND_PAYDAY ) {
                        
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
    
    /**
     * Description: This method the MarketPlace (competitions).
     * if there is no competition taking place, it calls findCompetitors();
     * It updates in progress competitions.
     * It prints a daily competition summary of the events
     * It removes dead TechGiants
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    public void updateMarketPlace() {
        
        if (this.currentCompetition == null) {
            
            findCompetitors();
        }
    
        if (currentCompetition != null) {
            
            currentCompetition.combatCycle();
        }
        
        if (currentCompetition != null) {
                
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
