package test.java.start;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.java.actor.FinancialTechStartUp;
import main.java.actor.GameTechStartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.Competition;
import main.java.world.California;
import main.java.world.World;
import org.junit.Test;

public class WorldTest {
    
    /**
     * Tests updating financial events.
     */
    @Test
    public void updateFinancialEventsTest() {
        World w = new World();
        w.setCurrentDay(1);
        BigDecimal initialRev = w.getTechGiants().get(0).getStartups().get(0).getRevenue();
        w.updateFinancialEvents();
        BigDecimal finalRev = w.getTechGiants().get(0).getStartups().get(0).getRevenue();
        boolean revDecreased = initialRev.compareTo(finalRev) > 0;
        assertEquals(true, revDecreased);
    }
    
    /**
     * Tests updating start ups.
     */
    @Test
    public void updateStartUpsTest() {
        World w = new World();
        w.setCurrentDay(1);
        BigDecimal initialNetIncome = w.getTechGiants().get(0).getStartups().get(0).getNetIncome();
        w.updateStartUps();
        BigDecimal finalNetIncome = w.getTechGiants().get(0).getStartups().get(0).getNetIncome();
        boolean netIncomeDecreased = initialNetIncome.compareTo(finalNetIncome) > 0;
        assertEquals(true, netIncomeDecreased);
    }
    
    /**
     * Tests updating customers.
     */
    @Test
    public void updateCustomersTest() {
        World w = new World();
        TechGiant tg1 = new TechGiant("test", "test");
        TechGiant tg2 = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg1);
        GameTechStartUp gtsu = new GameTechStartUp("test", "test", ca, tg2);
        ftsu.addHighIncomeCustomers(100);
        gtsu.addHighIncomeCustomers(100);
        tg1.getStartups().add(ftsu);
        tg2.getStartups().add(gtsu);
        w.getTechGiants().add(tg1);
        w.getTechGiants().add(tg2);
        Competition comp = new Competition(ftsu, gtsu);
        w.setCurrentCompetition(comp);
        w.setCurrentDay(1);
        
        double initialAvailFunds = w.getTechGiants()
                .get(0).getStartups().get(0).getCustomers().get(0).getAvailableFunds();
        w.updateCustomers();
        double finalAvailFunds = w.getTechGiants()
                .get(0).getStartups().get(0).getCustomers().get(0).getAvailableFunds();
        boolean netIncomeDecreased = initialAvailFunds < finalAvailFunds;
        assertEquals(true, netIncomeDecreased);
    }
    
    /**
     * Tests updating market place.
     */
    @Test
    public void updateMarketPlaceTest() {
        World w = new World();
        TechGiant tg1 = new TechGiant("test", "test");
        TechGiant tg2 = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg1);
        GameTechStartUp gtsu = new GameTechStartUp("test", "test", ca, tg2);
        ftsu.addHighIncomeCustomers(100);
        gtsu.addHighIncomeCustomers(100);
        tg1.getStartups().add(ftsu);
        tg2.getStartups().add(gtsu);
        w.getTechGiants().add(tg1);
        w.getTechGiants().add(tg2);
        Competition comp = new Competition(ftsu, gtsu);
        w.setCurrentCompetition(comp);
        w.setCurrentDay(1);
        
        int initialCounterOne = comp.getCounterOne();
        w.updateMarketPlace();
        int finalCounterOne = comp.getCounterOne();
        
        boolean counterIncremented = initialCounterOne > finalCounterOne;
        assertEquals(true, counterIncremented);
    }

}
