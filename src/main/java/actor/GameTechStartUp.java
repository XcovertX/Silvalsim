package main.java.actor;

import java.math.BigDecimal;

import main.java.world.Location;
import main.java.world.RandomNumber;

public class GameTechStartUp extends StartUp {

    public GameTechStartUp(String name, String description, Location location, TechGiant techGiant) {
        super(name, description, location, techGiant);
        
        this.setType("GameTech");
        
        this.addJuniorDevs(RandomNumber.getRandomBetween(2, 10));
        this.addExperiencedDevs(RandomNumber.getRandomBetween(2, 10));
        this.addSeniorDevs(RandomNumber.getRandomBetween(2, 10));
        
        this.addLowIncomeCustomers(RandomNumber.getRandomBetween(10000, 30000));
        this.addMediumIncomeCustomers(RandomNumber.getRandomBetween(100, 2000));
        this.addHighIncomeCustomers(RandomNumber.getRandomBetween(100, 2000));
        
        this.setServiceCost(RandomNumber.getRandomBetween(1, 20) + .99);
        
        this.setRevenue(new BigDecimal(RandomNumber.getRandomBetween(1000000, 2000000)));
        
        int numberOfExpense = RandomNumber.getRandomBetween(10, 100);
        int cost = 0;
        int numberOfMonths = 0;
        int dueDay = 1;
        for (int i = 0; i < numberOfExpense; i++) {
            cost = RandomNumber.getRandomBetween(1000, 20000);
            numberOfMonths = RandomNumber.getRandomBetween(500, 600);
            dueDay = RandomNumber.getRandomBetween(1, 30);
            this.addExpense("expense", "General Expense", cost, dueDay, numberOfMonths);
        }
        
        this.setDesirability(RandomNumber.getRandomBetween(100, 200));

    }

}
