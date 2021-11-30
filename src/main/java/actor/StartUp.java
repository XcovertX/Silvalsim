package main.java.actor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

import main.java.marketplace.AttackExpense;
import main.java.marketplace.Competition;
import main.java.marketplace.DefenseExpense;
import main.java.marketplace.Expense;
import main.java.marketplace.Fee;
import main.java.marketplace.GeneralExpense;
import main.java.marketplace.LegalBattleExpense;
import main.java.marketplace.Level;
import main.java.marketplace.Levels;
import main.java.marketplace.RecordEntry;
import main.java.world.Location;
import main.java.world.RandomNumber;
import main.java.world.World;

/**
 * StartUp.java
 * Package: main.java.actor
 * Description: The StartUp class is an abstract class that provides
 * all the components required to compete in competitions.
 * This actor is the primary actor used for competing
 * 
 * @author James Covert
 * @version 1.0
 */

public abstract class StartUp extends Actor {
    
    private TechGiant techGiant;                    // techgiant that owns the startup
    private String type;                            // type used to identify for factory build
    
    // Stats ///////////////////////
    private Levels levels;                          // all possible levels
    private Level level;                            // current level
    private int levelNumber;                        // current level number
    private int xp;                                 // experience points
    private int xpMin;                              // min awarded xp for successful attacks
    private int xpMax;                              // max awarded xp for successful attacks
    private int xpToNextLevel;                      // xp needed to level up
    private BigDecimal totalRevenue;                // for track total revenue collected
    private BigDecimal netIncome;                   // hit points
    private BigDecimal revenue;                     // health points
    private BigDecimal marketShare;                 // defense points
    
    // Variables ///////////////////
    private int speed;                              // action speed
    private int attackSuccessMultiplier;            // for determining attack success
    private int attackCostMultiplier;               // for determining the cost to attack
    private int defendCostMultiplier;               // for determining the cost to defend
    private int talentMultiplier;                   // for adjusting xp gains
    private double serviceCost;                     // cost to use the service
    private int desirability;                       // det desire level, effects customer gains
    private boolean dodge;                          // determines if next attack will be dodged
    private Location location;                      // company location, holds tax info
    private ArrayList<Expense> expenses;            // costs for running business
    private ArrayList<RecordEntry> financialRecord; // log of finances
    
    // Devs ////////////////////////
    private ArrayList<Developer> devs;              // devs employed
    
    // Customers ///////////////////
    private ArrayList<Customer> customers;          // number of customers
    
    private boolean engagedInCompetition;           // signifies if su is engaged in competition
    private Competition currentCompetition;         // current competition

    
    /**
     * Description: The StartUp constructor builds a startup and generates random stats.
     * 
     * @author James Covert
     * @param name - the name of the startup
     * @param description - description of the startup
     * @param location - where the startup is located (for taxes)
     * @param techGiant - the techGiant that owns the startup
     * @version 1.0
     */
    public StartUp(String name, String description, Location location, TechGiant techGiant) {
        
        setName(name);
        setDescription(description);
        setTechGiant(techGiant);
        setAlive(true);
        setType(type);
        
        setLocation(location);
        setXp(0);
        setNetIncome(new BigDecimal(0.00));
        setRevenue(new BigDecimal(0.00));
        setTotalRevenue(new BigDecimal(0.00));
        setMarketShare(new BigDecimal(0.00));
        setSpeed(0);
        setServiceCost(0.00);
        
        setLevels(new Levels(this));
        levels.setLevel(1);
        devs = new ArrayList<Developer>();
        financialRecord = new ArrayList<RecordEntry>();
        customers = new ArrayList<Customer>();
        expenses =  new ArrayList<Expense>(); 
        
        buildRandomStats();
    }
    
    /**
     * Description: This method adds new junior developers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfDevs - number of junior devs to add
     */
    public void addJuniorDevs(int numOfDevs) {

        int max = 5;
        int min = 0;
        int offset;
        for (int i = 0; i < numOfDevs; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            double salary = 100000;
            for (int j = 0; j < offset; j++) {
                salary += 1000;
            }
            Developer dev = new Developer(Developer.JUNIOR_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }   
    }
    
    /**
     * Description: This method adds new experienced developers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfDevs - number of experienced devs to add
     */
    public void addExperiencedDevs(int numOfDevs) {

        int max = 5;
        int min = 0;
        int offset;
        for (int i = 0; i < numOfDevs; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            double salary = 120000;
            
            for (int j = 0; j < offset; j++) {
                
                salary += 1000;
            }
            Developer dev = new Developer(Developer.EXPERIENCED_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }
    }
    
    /**
     * Description: This method adds new senior developers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfDevs - number of senior devs to add
     */
    public void addSeniorDevs(int numOfDevs) {

        int max = 5;
        int min = 0;
        int offset;
        for (int i = 0; i < numOfDevs; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            double salary = 150000;
            
            for (int j = 0; j < offset; j++) {
                
                salary += 1000;
            }
            Developer dev = new Developer(Developer.SENIOR_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }
    }
    
    /**
     * Description: This method adds new low income customers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfCustomers - number of low income customers to add
     */
    public void addLowIncomeCustomers(int numOfCustomers) {

        int max = 10;
        int min = 0;
        int offset;
        int dueDate;
        for (int i = 0; i < numOfCustomers; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            max = 30;
            min = 1;
            dueDate = RandomNumber.getRandomBetween(min, max);
            Customer customer = new Customer(this, 
                    Customer.LOW_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
            
        }   
    }
    
    /**
     * Description: This method adds new medium income customers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfCustomers - number of medium income customers to add
     */
    public void addMediumIncomeCustomers(int numOfCustomers) {

        int max = 200;
        int min = 0;
        int offset;
        int dueDate;
        for (int i = 0; i < numOfCustomers; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            max = 30;
            min = 1;
            dueDate = RandomNumber.getRandomBetween(min, max);
            Customer customer = new Customer(this, 
                    Customer.MEDIUM_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
        }
    }
    
    /**
     * Description: This method adds new high income customers to the startup staff.
     * 
     * @author James Covert
     * @version 1.0
     * @param numOfCustomers - number of high income customers to add
     */
    public void addHighIncomeCustomers(int numOfCustomers) {

        int max = 1000;
        int min = 0;
        int offset;
        int dueDate;
        for (int i = 0; i < numOfCustomers; i++) {
            
            offset = RandomNumber.getRandomBetween(min, max);
            max = 30;
            min = 1;
            dueDate = RandomNumber.getRandomBetween(min, max);
            Customer customer = new Customer(this, 
                    Customer.HIGH_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
        }
    }
    
    /**
     * Description: This method removes a given customer from the startup.
     * 
     * @author James Covert
     * @version 1.0
     * @param customer - customer to be removed
     */
    public void removeCustomer(Customer customer) {
        
        for (int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customer)) {
                customers.remove(i);
            }
        }
    }
    
    /**
     * Description: This method is called once a day for every startup alive.
     * It cycles through all expenses held by the startup.
     * It then determines they type of expense and casts to to that type.
     * It then checks if the expense is due. 
     * If the expense is found to be due, the amount is subtracted from 
     * the appropriate catagory: revenue, netincome or marketshare.
     * It then increments the number of payments received.
     * Lastly, calls removeExpiredExpenses() to remove the expenses
     * that have been paid in full.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void deductExpenses() {
        
        for (int i = 0; i < expenses.size(); i++) {
            
            Expense expense = expenses.get(i);

            if (expense.getType().equals("Fee")) {
                
                Fee fee = (Fee) expense;
                decreaseRevenue(new BigDecimal(fee.getCost()));
                if (expense.getDueDate() == World.world.getCurrentDay()) {

                    fee.incrementNumberOfTimesApplied();
                }
            }
            
            if (expense.getType().equals("Legal Battle Expense")) {
                
                LegalBattleExpense lbe = (LegalBattleExpense) expense;
                decreaseRevenue(new BigDecimal(lbe.getCost()));
                if (expense.getDueDate() == World.world.getCurrentDay()) {

                    lbe.incrementNumberOfTimesApplied();
                }
            }
            
            if (expense.getType().equals("General Expense")) {
                
                GeneralExpense ge = (GeneralExpense) expense;
                decreaseRevenue(new BigDecimal(ge.getCost()));
                if (expense.getDueDate() == World.world.getCurrentDay()) {

                    ge.incrementNumberOfTimesApplied();
                }
            }
            
            if (expense.getType().equals("Attack Expense")) {
                
                AttackExpense ae = (AttackExpense) expense;
                decreaseNetIncome(new BigDecimal(ae.getCost()));
                if (expense.getDueDate() == World.world.getCurrentDay()) {

                    ae.incrementNumberOfTimesApplied();
                }
            }
            
            if (expense.getType().equals("Defense Expense")) {
                
                DefenseExpense de = (DefenseExpense) expense;
                decreaseMarketShare(new BigDecimal(de.getCost()));
                if (expense.getDueDate() == World.world.getCurrentDay()) {

                    de.incrementNumberOfTimesApplied();
                }
            }

        }
        removeExpiredExpenses();
    }
    
    /**
     * Description: This method collects a given customer's payment.
     * and distributes it to the appropriate locations: revenue, 
     * netIncome and marketShare
     * 
     * @author James Covert
     * @version 1.0
     * @param customer - customer to have payment collected from
     */
    public void collectPayment(Customer customer) {
        
        customer.setAvailableFunds(customer.getAvailableFunds() - getServiceCost());
        BigDecimal payment = new BigDecimal(getServiceCost());
        BigDecimal quarterPayment = payment.divide(new BigDecimal(4));
        this.increaseRevenue(payment);
        this.increaseNetIncome(quarterPayment);
        this.increaseMarketShare(quarterPayment);
    }
    
    /**
     * Description: This method removes all expenses that have been paid in full.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void removeExpiredExpenses() {
        
        int i = 0;
        while (i < expenses.size()) {
            
            if (expenses.get(i).getDuration() <= expenses.get(i).getNumberOfTimesPaid()) {
                
                expenses.remove(i);
                
            } else {
                
                i++;
            }
        }
    }
    
    /**
     * Description: This method removes a specific number of expenses of a given type.
     * 
     * @author James Covert
     * @version 1.0
     * @param number - number of expenses to be removed
     * @param type - the type of expense to be removed
     */
    public void removeExpenses(int number, String type) {
        
        int counter = 0;
        int i = 0;
        while (i < expenses.size()) {
            
            if (counter < number) {
                
                if (expenses.get(i).getType().equals(type)) {
                    
                    expenses.remove(i);
                    counter++;
                    
                } else {
                    
                    i++;
                }
                
            } else {
                
                break;
            }
        }
    }
    
    /**
     * Description: This method removes all expenses of every type.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void removeAllFees() {
        
        int i = 0;
        while (i < expenses.size()) {
            
            if (expenses.get(i).getType().equals("Fee")) {
                
                expenses.remove(i);
                
            } else {
                
                i++;
            }
        }
    }
    
    /**
     * Description: This method removes all expenses of.
     * 'Legal Battle Expense' type.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void removeAllLegalBattleExpenses() {
        
        int i = 0;
        while (i < expenses.size()) {
            
            if (expenses.get(i).getType().equals("Legal Battle Expense")) {
                
                expenses.remove(i);
                
            } else {
                
                i++;
            }
        }  
    }
    
    /**
     * Description: This method removes all expenses of.
     * 'General Expense' type.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void removeAllGeneralExpenses() {
        
        int i = 0;
        while (i < expenses.size()) {
            
            if (expenses.get(i).getType().equals("General Expense")) {
                
                expenses.remove(i);
                
            } else {
                
                i++;
            }
        }  
    }
    
    /**
     * Description: This method builds a new expense and adds it to the startup expenses.
     * 
     * @author James Covert
     * @version 1.0
     * @param name - name of the expense
     * @param type - type of expense
     * @param cost - expense cost
     * @param dueDate - day of the month the expense is due
     * @param duration - number of months the expense is to be collected
     */
    public void addExpense(String name, String type, double cost, int dueDate, int duration) {
        
        if (type.equals("Fee")) {
            
            Fee fee = new Fee(name, cost, dueDate, duration);
            expenses.add(fee);
        }
        
        if (type.equals("Legal Battle Expense")) {
            
            Fee fee = new Fee(name, cost, dueDate, duration);
            expenses.add(fee);
        }
        
        if (type.equals("General Expense")) {
            
            GeneralExpense ge = new GeneralExpense(name, cost, dueDate, duration);
            expenses.add(ge);
        }
        
        if (type.equals("Attack Expense")) {
            
            AttackExpense ae = new AttackExpense(name, cost, dueDate, duration);
            expenses.add(ae);
        }
        
        if (type.equals("Defense Expense")) {
            
            DefenseExpense de = new DefenseExpense(name, cost, dueDate, duration);
            expenses.add(de);
        }
    }
    
    /**
     * Description: This method this method builds random stats for a newly created Startup.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void buildRandomStats() {
        
        this.addJuniorDevs(RandomNumber.getRandomBetween(1, 3));
        this.addExperiencedDevs(RandomNumber.getRandomBetween(1, 3));
        this.addSeniorDevs(RandomNumber.getRandomBetween(1, 3));
        
        this.addLowIncomeCustomers(RandomNumber.getRandomBetween(10000, 30000));
        this.addMediumIncomeCustomers(RandomNumber.getRandomBetween(100, 2000));
        this.addHighIncomeCustomers(RandomNumber.getRandomBetween(100, 2000));
        
        this.setServiceCost(RandomNumber.getRandomBetween(15, 25) + .99);
        
        this.setRevenue(new BigDecimal(RandomNumber.getRandomBetween(100000000, 100000000)));
        
        int numberOfExpense = RandomNumber.getRandomBetween(10, 20);
        int cost = 0;
        int numberOfMonths = 0;
        int dueDay = 1;
        for (int i = 0; i < numberOfExpense; i++) {
            cost = RandomNumber.getRandomBetween(300, 2000);
            numberOfMonths = RandomNumber.getRandomBetween(500, 600);
            cost = cost / (numberOfMonths * 30);
            dueDay = RandomNumber.getRandomBetween(1, 30);
            this.addExpense("expense", "General Expense", cost, dueDay, numberOfMonths);
        }
        
        this.setDesirability(RandomNumber.getRandomBetween(100, 200));
    }
    
    /**
     * Description: This method removes a specific developer from the startup staff. 
     * and adjusts startup stats in accordance with the developer removed.
     * 
     * @author James Covert
     * @version 1.0
     * @param dev - dev to be removed
     */
    public void removeDev(Developer dev) {
        
        for (int i = 0; i < devs.size(); i++) {
            
            if (devs.get(i).equals(dev)) {
                
                devs.remove(i);
                this.speed--;
                this.desirability--;
                this.decreaseTalentMultiplier(dev.getTalent());
            }
        }
    }
    
    /**
     * Description: This method removes the most senior developer.
     * and adjusts the startup stats matching the dev removed.
     * 
     * @author James Covert
     * @version 1.0
     * @return Developer - the most senior dev
     */
    public Developer removeTopDev() {
        
        Collections.sort(devs, new Comparator<Developer>() {
            
            @Override
            public int compare(Developer d1, Developer d2) {
                
                if (d1.getTalent() > d2.getTalent()) {
                    
                    return 1;
                }
                
                if (d1.getTalent() < d2.getTalent()) {
                    
                    return -1;
                }
                return 0;
            }
        });
        
        Developer dev = devs.remove(0);
        this.speed--;
        this.desirability--;
        this.decreaseTalentMultiplier(dev.getTalent());

        return dev;
    }
    
    /**
     * Description: This method removes the most junior developer.
     * and adjusts the startup stats matching the dev removed.
     * 
     * @author James Covert
     * @version 1.0
     * @return Developer - the most junior dev
     */
    public Developer removeLowestDev() {
        
        Collections.sort(devs, new Comparator<Developer>() {
            
            @Override
            public int compare(Developer d1, Developer d2) {
                
                if (d1.getTalent() < d2.getTalent()) {
                    
                    return 1;
                }
                
                if (d1.getTalent() > d2.getTalent()) {
                    
                    return -1;
                }
                return 0;
            }
        });
        
        Developer dev = devs.remove(0);
        this.speed--;
        this.desirability--;
        this.decreaseTalentMultiplier(dev.getTalent());
        return dev;
    }
    
    /**
     * Description: This method adds a given developer to the startup staff.
     * and adjusts the startup stats matching the dev being added.
     * 
     * @author James Covert
     * @version 1.0
     * @param dev - developer to be added
     */
    public void addDev(Developer dev) {
        
        devs.add(dev);
        this.speed++;
        this.desirability++;
        this.increaseTalentMultiplier(dev.getTalent());
    }
    
    /**
     * Description: This method adds a new financial record entry.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void addFinancialRecord() {
        
        RecordEntry re = new RecordEntry(netIncome, revenue, totalRevenue, 
                marketShare, customers.size(), devs.size());
        
        this.financialRecord.add(re);
    }
    
    /**
     * Description: This method retrieves the last financial record entry.
     * 
     * @author James Covert
     * @version 1.0
     * @return RecordEntry -  the last entry recorded
     */
    public RecordEntry getLastEntry() {
        
        if (financialRecord.size() - 1 >= 0) {
            
            return this.financialRecord.get(financialRecord.size() - 1);
        } 
       
        return new RecordEntry(new BigDecimal(0), new BigDecimal(0), 
                new BigDecimal(0), new BigDecimal(0), 0, 0);
    }
    
    /**
     * Description: This method retrieves the seconds to last financial record entry.
     * 
     * @author James Covert
     * @version 1.0
     * @return RecordEntry -  the second to last entry recorded
     */
    public RecordEntry getSecondToLastEntry() {
        
        if (financialRecord.size() - 2 >= 0) {
            
            return this.financialRecord.get(financialRecord.size() - 2);
        } 
        
        return new RecordEntry(new BigDecimal(0), new BigDecimal(0), 
                new BigDecimal(0), new BigDecimal(0), 0, 0);
    }
    
    /**
     * Description: This method retrieves the previous months revenue total.
     * 
     * @author James Covert
     * @version 1.0
     * @param day - day used to locate previous month revenue information
     * @return BigDecimal - previous month's total revenue
     */
    public BigDecimal getPreviousMonthRevenue(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord.get(financialRecord.size() - 29 - day).getMonthlyRevenue();
        } 
        
        return new BigDecimal(0);
    }
    
    /**
     * Description: This method retrieves the previous months customer total.
     * 
     * @author James Covert
     * @version 1.0
     * @param day - day used to locate previous month customer count
     * @return int - previous month's customer total
     */
    public int getPreviousMonthCustomerCount(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord
                    .get(financialRecord.size() - 29 - day).getNumberOfCustomers();
        } 
        
        return 0;
    }
    
    /**
     * Description: This method retrieves the previous months dev total.
     * 
     * @author James Covert
     * @version 1.0
     * @param day - day used to locate previous month dev count
     * @return int - previous month's dev total
     */
    public int getPreviousMonthDevCount(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord
                    .get(financialRecord.size() - 29 - day).getNumberOfDevs();
        } 
        
        return 0;
    }
    
    /**
     * Description: This method compares current xp amount to the amount required
     * for the startup to level up to the next office level.
     * 
     * @author James Covert
     * @version 1.0
     * @return boolean - true if startup's xp is greater than required xp to level up
     */
    public boolean compareXpToNextLevelXp() {
        
        if (this.xp > this.xpToNextLevel) {
            
            return true;
        }
        return false;
    }
    
    /**
     * Description: This method increases the revenue collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be added
     */
    public void increaseRevenue(BigDecimal amount) {
        
        BigDecimal total = revenue.add(amount);
        this.setRevenue(total);
        total = totalRevenue.add(amount);
        this.setTotalRevenue(total);
    }
    
    /**
     * Description: This method increases the netIncome collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be added
     */
    public void increaseNetIncome(BigDecimal amount) {
        
        BigDecimal total = netIncome.add(amount);
        this.setNetIncome(total);
    }
    
    
    /**
     * Description: This method increases the marketShare collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be added
     */
    public void increaseMarketShare(BigDecimal amount) {
        
        BigDecimal total = marketShare.add(amount);
        this.setMarketShare(total);
    }
    
    /**
     * Description: This method decreases the startup's talent by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be added
     */
    public void increaseTalentMultiplier(int amount) {
        
        this.talentMultiplier += amount;
    }
        
    /**
     * Description: This method decreases the revenue collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be removed
     */
    public void decreaseRevenue(BigDecimal amount) {
        
        this.setRevenue(revenue.subtract(amount));
    }
    
    /**
     * Description: This method decreases the netIncome collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be removed
     */
    public void decreaseNetIncome(BigDecimal amount) {
        
        this.setNetIncome(netIncome.subtract(amount));
    }
    
    /**
     * Description: This method decreases the marketShare collected by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be removed
     */
    public void decreaseMarketShare(BigDecimal amount) {
        
        this.setMarketShare(marketShare.subtract(amount));
    }
    
    /**
     * Description: This method decreases the startup's talent by a given amount.
     * 
     * @author James Covert
     * @version 1.0
     * @param amount - amount to be removed
     */
    public void decreaseTalentMultiplier(int amount) {
        
        this.talentMultiplier -= amount;
    }
    
    // getters and setters

    public BigDecimal getNetIncome() {
        
        return netIncome;
    }

    public void setNetIncome(BigDecimal netIncome) {
        
        this.netIncome = netIncome.setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getRevenue() {
        
        return revenue;
    }

    public void setRevenue(BigDecimal revenue) {
        
        this.revenue = revenue.setScale(2, RoundingMode.DOWN);
    }

    public BigDecimal getMarketShare() {
        
        return marketShare;
    }

    public void setMarketShare(BigDecimal marketShare) {
        
        this.marketShare = marketShare.setScale(2, RoundingMode.DOWN);
    }

    public Location getLocation() {
        
        return location;
    }

    public void setLocation(Location location) {
        
        this.location = location;
    }

    public boolean isEngagedInCompetition() {
        
        return engagedInCompetition;
    }

    public void setEngagedInCompetition(boolean engagedInCompetition) {
        
        this.engagedInCompetition = engagedInCompetition;
    }

    public Competition getCurrentCompetition() {
        
        return currentCompetition;
    }

    public void setCurrentCompetition(Competition currentCompetition) {
        
        this.currentCompetition = currentCompetition;
    }

    public int getSpeed() {
        
        return speed;
    }

    private void setSpeed(int speed) {
        
        this.speed = speed;
    }

    public int getXp() {
        
        return xp;
    }

    public void setXp(int xp) {
        
        this.xp = xp;
    }

    public ArrayList<Developer> getDevs() {
        
        return devs;
    }

    /**
     * Description: This method sets devs.
     * 
     * @author James Covert
     * @version 1.0
     */
    public void setDevs(ArrayList<Developer> devs) {
        
        this.speed = devs.size();
        this.devs = devs;
    }
    
    public Developer getDev(int index) {
        
        return devs.get(index);
    }

    public ArrayList<RecordEntry> getFinancialRecord() {
 
        return financialRecord;
    }

    public void setFinancialRecord(ArrayList<RecordEntry> financialRecord) {
 
        this.financialRecord = financialRecord;
    }
    
    public Level getLevel() {
        
        return level;
    }

    public void setLevel(Level level) {
        
        this.level = level;
    }

    public Levels getLevels() {
        
        return levels;
    }

    public void setLevels(Levels levels) {
        
        this.levels = levels;
    }

    public int getXpToNextLevel() {
        
        return xpToNextLevel;
    }

    public void setXpToNextLevel(int xpToNextLevel) {
        
        this.xpToNextLevel = xpToNextLevel;
    }

    public int getAttackSuccessMultiplier() {
        
        return attackSuccessMultiplier;
    }

    public void setAttackSuccessMultiplier(int attackSuccessMultiplier) {
        
        this.attackSuccessMultiplier = attackSuccessMultiplier;
    }

    public int getLevelNumber() {
        
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        
        this.levelNumber = levelNumber;
    }

    public int getXpMin() {
        
        return xpMin;
    }

    public void setXpMin(int xpMin) {
        
        this.xpMin = xpMin;
    }

    public int getXpMax() {
        
        return xpMax;
    }

    public void setXpMax(int xpMax) {
        
        this.xpMax = xpMax;
    }

    public ArrayList<Customer> getCustomers() {
        
        return customers;
    }

    public void setCustomers(ArrayList<Customer> customers) {
        
        this.customers = customers;
    }
    
    public Customer getCustomer(int index) {
        
        return customers.get(index);
    }
    
    public void addCustomer(Customer customer) {
        
        customers.add(customer);
    }

    public double getServiceCost() {
        
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        
        this.serviceCost = serviceCost;
    }

    public BigDecimal payDev(BigDecimal tempRevenue, Developer dev) {
        
        return tempRevenue.subtract(dev.getPaycheck());
    }

    public int getTalentMultiplier() {
        
        return talentMultiplier;
    }

    public void setTalentMultiplier(int talentMultiplier) {
        
        this.talentMultiplier = talentMultiplier;
    }

    public BigDecimal getTotalRevenue() {
        
        return totalRevenue;
    }

    public void setTotalRevenue(BigDecimal totalRevenue) {
        
        this.totalRevenue = totalRevenue.setScale(2, RoundingMode.DOWN);
    }

    public ArrayList<Expense> getExpenses() {
        
        return expenses;
    }

    public void setExpenses(ArrayList<Expense> expenses) {
        
        this.expenses = expenses;
    }

    /**
     * Description: This method retrieves Desirability.
     * 
     * @author James Covert
     * @version 1.0
     */
    public int getDesirability() {
        
        if (desirability <= 0) {
            return 1;
        }
        return desirability;
    }

    public void setDesirability(int desirability) {
        
        this.desirability = desirability;
    }
    
    public void increaseDesirability(int amount) {
        
        this.desirability += amount;
    }
    
    public void decreaseDesirability(int amount) {
        
        this.desirability -= amount;
    }

    public TechGiant getTechGiant() {
        
        return techGiant;
    }

    public void setTechGiant(TechGiant techGiant) {
        
        this.techGiant = techGiant;
    }

    public String getType() {
        
        return type;
    }

    public void setType(String type) {
        
        this.type = type;
    }

    public boolean dodgeSuccess() {
        
        return dodge;
    }

    public void setDodge(boolean dodge) {
        
        this.dodge = dodge;
    }

    public int getAttackCostMultiplier() {
        
        return attackCostMultiplier;
    }

    public void setAttackCostMultiplier(int attackCostMultiplier) {
        
        this.attackCostMultiplier = attackCostMultiplier;
    }

    public int getDefendCostMultiplier() {
        
        return defendCostMultiplier;
    }

    public void setDefendCostMultiplier(int defendCostMultiplier) {
        
        this.defendCostMultiplier = defendCostMultiplier;
    }
}
