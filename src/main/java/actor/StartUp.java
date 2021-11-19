package main.java.actor;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.Random;

import main.java.marketplace.Competition;
import main.java.marketplace.Level;
import main.java.marketplace.Levels;
import main.java.marketplace.RecordEntry;
import main.java.world.Location;

public class StartUp extends Actor {
    
    // Stats ///////////////////////
    private Levels levels;                          // all possible levels
    private Level level;                            // current level
    private int levelNumber;                        // current level number
    private int xp;                                 // experience points
    private int xpMin;                              // min awarded xp for successful attacks
    private int xpMax;                              // max awarded xp for successful attacks
    private int xpToNextLevel;                      // xp needed to level up
    private int attackSuccessMultiplier;            // for determining attack success
    private double netIncome;                       // hit points
    private double revenue;                         // health points
    private double marketShare;                     // defense points
    private int speed;                              // action speed
    private double serviceCost;                     // cost to use the sevice
    private ArrayList<RecordEntry> financialRecord; // log of finances
    
    // Devs ////////////////////////
    private ArrayList<Developer> devs;              // devs employed
    private ArrayList<Customer> customers;          // number of customers
    private Location location;                      // company location
    
    private boolean engagedInCompetition;
    private Competition currentCompetition;
    
    private static final double NET_INCOME_MULTIPLIER = 100000.00;
    private static final double REVENUE_MULTIPLIER = 1000000.00;

    
    public StartUp(String name, String description, Location location) {
        
        setName(name);
        setDescription(description);
        setAlive(true);
        
        setLocation(location);
        setXP(0);
        setNetIncome(0.00);
        setRevenue(0.00);
        setMarketShare(0.00);
        setSpeed(0);
        setServiceCost(0.00);
        
        setLevels(new Levels(this));
        
        levels.setLevel(0);
        
        devs = new ArrayList<Developer>();
        financialRecord = new ArrayList<RecordEntry>();
        customers = new ArrayList<Customer>();
        
        
    }
    
    public void addJuniorDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset = rand.nextInt(max + 1 - min) + min;
        for(int i = 0; i < numOfDevs; i++) {
            Developer dev = new Developer(Developer.JUNIOR_DEV_TALENT + offset);
            this.addDev(dev);
        }   
    }
    
    public void addExperiencedDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset = rand.nextInt(max + 1 - min) + min;
        for(int i = 0; i < numOfDevs; i++) {
            Developer dev = new Developer(Developer.EXPERIENCED_DEV_TALENT + offset);
            this.addDev(dev);
        }
    }
    
    public void addSeniorDevs(int numOfDevs) {
        
        Random rand = new Random();
        int max = 5;
        int min = 0;
        int offset = rand.nextInt(max + 1 - min) + min;
        for(int i = 0; i < numOfDevs; i++) {
            Developer dev = new Developer(Developer.SENIOR_DEV_TALENT + offset);
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
            Customer customer = new Customer(Customer.LOW_INCOME_AVAILABLE_FUNDS + offset, dueDate);
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
            Customer customer = new Customer(Customer.MEDIUM_INCOME_AVAILABLE_FUNDS + offset, dueDate);
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
            Customer customer = new Customer(Customer.HIGH_INCOME_AVAILABLE_FUNDS + offset, dueDate);
            this.addCustomer(customer);
        }
    }
    
    // getters and setters

    public double getNetIncome() {
        
        return netIncome;
    }

    public void setNetIncome(double netIncome) {
        
        this.netIncome = Math.floor(netIncome * 100) / 100.00;
    }

    public double getRevenue() {
        
        return revenue;
    }

    public void setRevenue(double revenue) {
        
        this.revenue = Math.floor(revenue * 100) / 100.00;
    }

    public double getMarketShare() {
        
        return marketShare;
    }

    public void setMarketShare(double marketShare) {
        
        this.marketShare = Math.floor(marketShare * 100) / 100.00;
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
    
    public void awardXP() {
        
        xp = xp + level.getXP();
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
                setNetIncome(this.netIncome - (devs.get(0).getTalent()));
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
        
        this.speed--;
        setNetIncome(this.netIncome - (devs.get(0).getTalent()));
        return devs.remove(0);
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
        
        this.speed--;
        setNetIncome(this.netIncome - (devs.get(0).getTalent()));
        return devs.remove(0);
    }
    
    public void addDev(Developer dev) {
        
        devs.add(dev);
        this.speed++;
        setNetIncome(this.netIncome + (dev.getTalent()));
    }
    
    public void increaseRevenue(double amount) {
        
        this.setRevenue(revenue + amount);       
    }
    
    public void increaseNetIncome(Developer dev) {
        
        this.setNetIncome(this.netIncome + (dev.getTalent()));
    }

    public ArrayList<RecordEntry> getFinancialRecord() {
 
        return financialRecord;
    }

    public void setFinancialRecord(ArrayList<RecordEntry> financialRecord) {
 
        this.financialRecord = financialRecord;
    }
    
    public void addFinancialRecord() {
        
        RecordEntry re = new RecordEntry(netIncome, revenue, marketShare, customers.size());
        
        this.financialRecord.add(re);
    }
    
    public RecordEntry getLastEntry() {
        
        return this.financialRecord.get(financialRecord.size() - 1);
    }
    
    public RecordEntry getSecondToLastEntry() {
        
        if (financialRecord.size() - 2 >= 0) {
            
            return this.financialRecord.get(financialRecord.size() - 2);
        } 
        
        return new RecordEntry(0, 0, 0, 0);
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
//                this.speed--;
//                setNetIncome(this.netIncome - (devs.get(0).getTalent()));
            }
        }
    }
    
//    public Developer removeHighIncomeCustomer() {
//        
//        Collections.sort(devs, new Comparator<Developer>() {
//            
//            @Override
//            public int compare(Developer d1, Developer d2) {
//                
//                if (d1.getTalent() > d2.getTalent()) {
//                    return 1;
//                }
//                
//                if (d1.getTalent() < d2.getTalent()) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
//        
//        this.speed--;
//        setNetIncome(this.netIncome - (devs.get(0).getTalent()));
//        return devs.remove(0);
//    }
//    
//    public Developer removeLowestDev() {
//        
//        Collections.sort(devs, new Comparator<Developer>() {
//            
//            @Override
//            public int compare(Developer d1, Developer d2) {
//                
//                if (d1.getTalent() < d2.getTalent()) {
//                    return 1;
//                }
//                
//                if (d1.getTalent() > d2.getTalent()) {
//                    return -1;
//                }
//                return 0;
//            }
//        });
//        
//        this.speed--;
//        setNetIncome(this.netIncome - (devs.get(0).getTalent()));
//        return devs.remove(0);
//    }
    
    public void addCustomer(Customer customer) {
        
        customers.add(customer);
//        this.speed++;
//        setNetIncome(this.netIncome + (dev.getTalent()));
    }

    public double getServiceCost() {
        
        return serviceCost;
    }

    public void setServiceCost(double serviceCost) {
        
        this.serviceCost = serviceCost;
    }
    
    public void collectPayment(Customer customer) {
        
        customer.setAvailableFunds(customer.getAvailableFunds() - getServiceCost());
        double payment = getServiceCost();
        this.increaseRevenue(payment);
    }


}
