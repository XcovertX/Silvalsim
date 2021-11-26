package main.java.actor;

import java.math.BigDecimal;
import java.math.RoundingMode;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import main.java.marketplace.Competition;
import main.java.marketplace.Expense;
import main.java.marketplace.Fee;
import main.java.marketplace.GeneralExpense;
import main.java.marketplace.LegalBattleExpense;
import main.java.marketplace.Level;
import main.java.marketplace.Levels;
import main.java.marketplace.RecordEntry;
import main.java.world.Location;
import main.java.world.Printer;
import main.java.world.World;

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
    private int talentMultiplier;                   // for adjusting xp gains
    private double serviceCost;                     // cost to use the service
    private int desirability;                       // determines desire level, effects customer gains
    private boolean dodge;                          // determines if next attack will be dodged
    private Location location;                      // company location, holds tax info
    private ArrayList<Expense> expenses;            // costs for running business
    private ArrayList<RecordEntry> financialRecord; // log of finances
    
    // Devs ////////////////////////
    private ArrayList<Developer> devs;              // devs employed
    
    // Customers ///////////////////
    private ArrayList<Customer> customers;          // number of customers
    
    private boolean engagedInCompetition;
    private Competition currentCompetition;

    
    public StartUp(String name, String description, Location location, TechGiant techGiant) {
        
        setName(name);
        setDescription(description);
        setTechGiant(techGiant);
        setAlive(true);
        setType(type);
        
        setLocation(location);
        setXP(0);
        setNetIncome(new BigDecimal(0.00));
        setRevenue(new BigDecimal(0.00));
        setTotalRevenue(new BigDecimal(0.00));
        setMarketShare(new BigDecimal(0.00));
        setSpeed(0);
        setServiceCost(0.00);
        
        setLevels(new Levels(this));
        
        levels.setLevel(0);
        
        devs = new ArrayList<Developer>();
        financialRecord = new ArrayList<RecordEntry>();
        customers = new ArrayList<Customer>();
        expenses =  new ArrayList<Expense>();
         
    }
    
    public void addJuniorDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset;
        for(int i = 0; i < numOfDevs; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            double salary = 100000;
            for(int j = 0; j < offset; j++) {
                salary += 1000;
            }
            Developer dev = new Developer(Developer.JUNIOR_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }   
    }
    
    public void addExperiencedDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset;
        for(int i = 0; i < numOfDevs; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            double salary = 120000;
            for(int j = 0; j < offset; j++) {
                salary += 1000;
            }
            Developer dev = new Developer(Developer.EXPERIENCED_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }
    }
    
    public void addSeniorDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset;
        for(int i = 0; i < numOfDevs; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            double salary = 150000;
            for(int j = 0; j < offset; j++) {
                salary += 1000;
            }
            Developer dev = new Developer(Developer.SENIOR_DEV_TALENT + offset, salary);
            this.addDev(dev);
        }
    }
    
    public void addLowIncomeCustomers(int numOfCustomers) {
        
        Random rand = new Random();
        int max = 10;
        int min = 0;
        int offset;
        int dueDate;
        for(int i = 0; i < numOfCustomers; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            max = 30;
            min = 1;
            dueDate = rand.nextInt(max + 1 - min) + min;
            Customer customer = new Customer(this, Customer.LOW_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
            
        }   
    }
    
    public void addMediumIncomeCustomers(int numOfCustomers) {
        
        Random rand = new Random();
        int max = 200;
        int min = 0;
        int offset;
        int dueDate;
        for(int i = 0; i < numOfCustomers; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            max = 30;
            min = 1;
            dueDate = rand.nextInt(max + 1 - min) + min;
            Customer customer = new Customer(this, Customer.MEDIUM_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
        }
    }
    
    public void addHighIncomeCustomers(int numOfCustomers) {
        
        Random rand = new Random();
        int max = 1000;
        int min = 0;
        int offset;
        int dueDate;
        for(int i = 0; i < numOfCustomers; i++) {
            offset = rand.nextInt(max + 1 - min) + min;
            max = 30;
            min = 1;
            dueDate = rand.nextInt(max + 1 - min) + min;
            Customer customer = new Customer(this, Customer.HIGH_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
        }
    }
    
    public void deductExpenses() {
        
        for(int i = 0; i < expenses.size(); i++) {
            
            Expense expense = expenses.get(i);
            
            if (expense.getDueDate() == World.world.getCurrentDay() ) {
            
                if (expense.getType().equals("Fee")) {
                    
                    Fee fee = (Fee) expense;
                    decreaseRevenue(new BigDecimal(fee.getCost()));
                    fee.incrementNumberOfTimesApplied();
                }
                
                if (expense.getType().equals("Legal Battle Expense")) {
                    
                    LegalBattleExpense lbe= (LegalBattleExpense) expense;
                    decreaseRevenue(new BigDecimal(lbe.getCost()));
                    lbe.incrementNumberOfTimesApplied();
                }
                
                if (expense.getType().equals("General Expense")) {
                    
                    GeneralExpense ge= (GeneralExpense) expense;
                    decreaseRevenue(new BigDecimal(ge.getCost()));
                    ge.incrementNumberOfTimesApplied();
                }
            }
        }
        removeExpiredExpenses();
    }
    
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
    
    public void removeAllFees() {
        
        int i = 0;
        while (i < expenses.size()) {
            
            if (expenses.get(i).equals("Fee")) {
                
                expenses.remove(i);
                
            } else {
                
                i++;
            }
        }
    }
    
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

    public int getXP() {
        
        return xp;
    }

    public void setXP(int xp) {
        
        this.xp = xp;
    }

    public ArrayList<Developer> getDevs() {
        
        return devs;
    }

    public void setDevs(ArrayList<Developer> devs) {
        
        this.speed = devs.size();
        this.devs = devs;
    }
    
    public Developer getDev(int index) {
        
        return devs.get(index);
    }
    
    public void removeDev(Developer dev) {
        
        for(int i = 0; i < devs.size(); i++) {
            if (devs.get(i).equals(dev)) {
                devs.remove(i);
                this.speed--;
                this.desirability--;
                this.decreaseTalentMultiplier(dev.getTalent());
            }
        }
    }
    
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
    
    public void addDev(Developer dev) {
        
        devs.add(dev);
        this.speed++;
        this.desirability++;
        this.increaseTalentMultiplier(dev.getTalent());
    }
    
    public void increaseRevenue(BigDecimal amount) {
        
        BigDecimal total = revenue.add(amount);
        this.setRevenue(total);
        total = totalRevenue.add(amount);
        this.setTotalRevenue(total);
    }
    
    public void increaseNetIncome(BigDecimal amount) {
        
        BigDecimal total = netIncome.add(amount);
        this.setNetIncome(total);
    }
    
    public void decreaseRevenue(BigDecimal amount) {
        
        this.setRevenue(revenue.subtract(amount));
    }
    
    public void decreaseNetIncome(BigDecimal amount) {
        
        this.setNetIncome(netIncome.subtract(amount));
    }
    
    public void increaseTalentMultiplier(int amount) {
        
        this.talentMultiplier += amount;
    }
    
    public void decreaseTalentMultiplier(int amount) {
        
        this.talentMultiplier -= amount;
    }

    public ArrayList<RecordEntry> getFinancialRecord() {
 
        return financialRecord;
    }

    public void setFinancialRecord(ArrayList<RecordEntry> financialRecord) {
 
        this.financialRecord = financialRecord;
    }
    
    public void addFinancialRecord() {
        
        RecordEntry re = new RecordEntry(netIncome, revenue, totalRevenue, 
                marketShare, customers.size(), devs.size());
        
        this.financialRecord.add(re);
    }
    
    public RecordEntry getLastEntry() {
        
        return this.financialRecord.get(financialRecord.size() - 1);
    }
    
    public RecordEntry getSecondToLastEntry() {
        
        if (financialRecord.size() - 2 >= 0) {
            
            return this.financialRecord.get(financialRecord.size() - 2);
        } 
        
        return new RecordEntry(new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), new BigDecimal(0), 0, 0);
    }
    
    public BigDecimal getPreviousMonthRevenue(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord.get(financialRecord.size() - 29 - day).getMonthlyRevenue();
        } 
        
        return new BigDecimal(0);
    }
    
    public int getPreviousMonthCustomerCount(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord.get(financialRecord.size() - 29 - day).getNumberOfCustomers();
        } 
        
        return 0;
    }
    
    public int getPreviousMonthDevCount(int day) {
        
        if (financialRecord.size() - 29 - day >= 1) {
            
            return this.financialRecord.get(financialRecord.size() - 29 - day).getNumberOfDevs();
        } 
        
        return 0;
    }
    
    public boolean compareXPToNextLevelXP() {
        
        if (this.xp > this.xpToNextLevel) {
            
            return true;
        }
        return false;
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

    public int getXPMin() {
        return xpMin;
    }

    public void setXPMin(int xpMin) {
        this.xpMin = xpMin;
    }

    public int getXPMax() {
        return xpMax;
    }

    public void setXPMax(int xpMax) {
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
    
    public void removeCustomer(Customer customer) {
        
        for(int i = 0; i < customers.size(); i++) {
            if (customers.get(i).equals(customer)) {
                customers.remove(i);
            }
        }
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
    
    public void collectPayment(Customer customer) {
        
        customer.setAvailableFunds(customer.getAvailableFunds() - getServiceCost());
        BigDecimal payment = new BigDecimal(getServiceCost());
        this.increaseRevenue(payment);
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
    }

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
}
