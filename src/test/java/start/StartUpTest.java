package test.java.start;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;

import main.java.actor.FinancialTechStartUp;
import main.java.actor.TechGiant;
import main.java.world.California;
import main.java.world.World;

import org.junit.Test;

public class StartUpTest {

    /**
     * Tests adding junior devs.
     */
    @Test
    public void addJuniorDevtest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        int devSize = ftsu.getDevs().size();
        ftsu.addJuniorDevs(5);
        assertEquals(devSize + 5, ftsu.getDevs().size());
    }
    
    /**
     * Tests adding experienced devs.
     */
    @Test
    public void addExperiencedDevtest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        int devSize = ftsu.getDevs().size();
        ftsu.addExperiencedDevs(10);
        assertEquals(devSize + 10, ftsu.getDevs().size());
    }
    
    /**
     * Tests adding senior devs.
     */
    @Test
    public void addSeniorDevtest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        int devSize = ftsu.getDevs().size();
        ftsu.addSeniorDevs(3);
        assertEquals(devSize + 3, ftsu.getDevs().size());
    }
    
    /**
     * Tests removeAllGeneralExpenses.
     */
    @Test
    public void removeAllGeneralExpensesTest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.addExpense("test", "General Expense", 100, 2, 2);
        ftsu.removeAllGeneralExpenses();
        int numberOfExpenses = ftsu.getExpenses().size();
        assertEquals(0, numberOfExpenses);
    }
    
    /**
     * Tests addExpense.
     */
    @Test
    public void addExpensesTest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.addExpense("test", "General Expense", 100, 2, 2);
        int numberOfExpenses = ftsu.getExpenses().size();
        assertEquals(1, numberOfExpenses);
    }
    
    /**
     * Tests deducting 'Fee' expenses.
     */
    @Test
    public void deductFeeExpenseTest() {
        World w = new World();
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.setRevenue(new BigDecimal(100));
        ftsu.addExpense("test", "Fee", 100, 1, 1);
        ftsu.deductExpenses();
        BigDecimal rev = ftsu.getRevenue();
        assertEquals(0, rev.intValue());
    }

}
