package test.java.start;

import static org.junit.Assert.assertEquals;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.actor.Customer;
import main.java.actor.Developer;
import main.java.actor.FinancialTechStartUp;
import main.java.actor.GameTechStartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.RecordEntry;
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
     * Tests remove expense.
     */
    @Test
    public void removeExpensesTest() {
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.addExpense("test", "General Expense", 100, 2, 2);
        ftsu.addExpense("test", "Attack Expense", 100, 2, 2);
        ftsu.addExpense("test", "General Expense", 100, 2, 2);
        int initialExpenseCount = ftsu.getExpenses().size();
        ftsu.removeExpenses(2, "General Expense");
        int finallExpenseCount = ftsu.getExpenses().size();
        assertEquals(initialExpenseCount - 2, finallExpenseCount);
    }
    
    /**
     * Tests deducting expenses.
     */
    @Test
    public void deductExpenseTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.setRevenue(new BigDecimal(100));
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        ftsu.addExpense("test", "Legal Battle Expense", 100, 1, 2);
        ftsu.addExpense("test", "General Expense", 100, 1, 2);
        ftsu.addExpense("test", "Attack Expense", 100, 1, 2);
        ftsu.addExpense("test", "Defense Expense", 100, 1, 2);
        ftsu.deductExpenses();
        w.setCurrentDay(2);
        ftsu.deductExpenses();
        w.setCurrentDay(1);
        ftsu.deductExpenses();
        assertEquals(0, ftsu.getExpenses().size());
    }
    
    /**
     * Tests remove all fees.
     */
    @Test
    public void removeAllFeesTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.setRevenue(new BigDecimal(100));
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        ftsu.addExpense("test", "Legal Battle Expense", 100, 1, 2);
        ftsu.addExpense("test", "Legal Battle Expense", 100, 1, 2);
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        int initialExpenseCount = ftsu.getExpenses().size();
        ftsu.removeAllLegalBattleExpenses();
        int finalExpenseCount = ftsu.getExpenses().size();
        assertEquals(initialExpenseCount - 2, finalExpenseCount);
    }
    
    /**
     * Tests remove all fees.
     */
    @Test
    public void removeAllLegalBattleExpensesTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.removeAllGeneralExpenses();
        ftsu.setRevenue(new BigDecimal(100));
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        ftsu.addExpense("test", "General Expense", 100, 1, 2);
        ftsu.addExpense("test", "Attack Expense", 100, 1, 2);
        ftsu.addExpense("test", "Fee", 100, 1, 2);
        int initialExpenseCount = ftsu.getExpenses().size();
        ftsu.removeAllFees();
        int finalExpenseCount = ftsu.getExpenses().size();
        assertEquals(initialExpenseCount - 3, finalExpenseCount);
    }
    
    /**
     * Tests collecting payment from customers.
     */
    @Test
    public void collectPaymentTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.setServiceCost(100.00);
        Customer customer = new Customer(ftsu, 100.00, 1);
        ftsu.collectPayment(customer);
        boolean fundsAvailEqualsZero = (customer.getAvailableFunds() == 0);
        assertEquals(true, fundsAvailEqualsZero);
    }
    
    /**
     * Tests customer subscription assessment.
     */
    @Test
    public void assessSubcriptionTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        GameTechStartUp gtsu = new GameTechStartUp("test", "test", ca, tg);
        ftsu.setServiceCost(10000.00);
        gtsu.setServiceCost(1.00);
        Customer customer = new Customer(ftsu, 100.00, 1);
        ftsu.addCustomer(customer);
        boolean shouldSwitch = ftsu.getCustomers().get(0).assessSubscription(gtsu);
        ftsu.removeCustomer(customer);
        assertEquals(true, shouldSwitch);
    }
    
    /**
     * Tests adding devs to StartUp.
     */
    @Test
    public void addDevTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        int initialDevCount = ftsu.getDevs().size();
        Developer dev = new Developer(10, 100000);
        ftsu.addDev(dev);
        int finalDevCount = ftsu.getDevs().size();
        assertEquals(initialDevCount + 1, finalDevCount);
    }
    
    /**
     * Tests removing specific dev.
     */
    @Test
    public void removeDevTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        Developer dev = new Developer(10, 100000);
        ftsu.addDev(dev);
        int initialDevCount = ftsu.getDevs().size();
        ftsu.removeDev(dev);
        int finalDevCount = ftsu.getDevs().size();
        assertEquals(initialDevCount - 1, finalDevCount);
    }
    
    /**
     * Tests removing topDevs.
     */
    @Test
    public void removeTopDevTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.setDevs(new ArrayList<Developer>());
        ftsu.addSeniorDevs(1);
        ftsu.addJuniorDevs(5);
        ftsu.addSeniorDevs(2);
        int initialSeniorDevCount = 0;
        for (int i = 0; i < ftsu.getDevs().size(); i++) {
            Developer dev = ftsu.getDevs().get(i);
            if (dev.getTalent() >= Developer.SENIOR_DEV_TALENT) {
                initialSeniorDevCount++;
            }
        }
        ftsu.removeTopDev();
        ftsu.removeTopDev();
        int finalSeniorDevCount = 0;
        for (int i = 0; i < ftsu.getDevs().size(); i++) {
            Developer dev = ftsu.getDevs().get(i);
            if (dev.getTalent() >= Developer.SENIOR_DEV_TALENT) {
                finalSeniorDevCount++;
            }
        }
        assertEquals(initialSeniorDevCount - 2, finalSeniorDevCount);
    }
    
    /**
     * Tests removing lowest Devs.
     */
    @Test
    public void removeLowestDevTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        ftsu.setDevs(new ArrayList<Developer>());
        ftsu.addJuniorDevs(2);
        ftsu.addSeniorDevs(1);
        ftsu.addJuniorDevs(3);
        ftsu.removeLowestDev();
        ftsu.removeLowestDev();
        ftsu.removeLowestDev();
        ftsu.removeLowestDev();
        ftsu.removeLowestDev();
        boolean devIsJunior = ftsu.getDevs().get(0).getTalent() < Developer.SENIOR_DEV_TALENT;
        assertEquals(true, devIsJunior);
    }
    
    /**
     * Tests adding financial record.
     */
    @Test
    public void addFinancialRecordTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        int initialFinancialRecordSize = ftsu.getFinancialRecord().size();
        ftsu.addFinancialRecord();
        ftsu.addFinancialRecord();
        RecordEntry fe1 = ftsu.getLastEntry();
        RecordEntry fe2 = ftsu.getSecondToLastEntry();
        int finalFinancialRecordSize = ftsu.getFinancialRecord().size();
        assertEquals(initialFinancialRecordSize + 2, finalFinancialRecordSize);
    }
    
    /**
     * Tests retrieving record entries.
     */
    @Test
    public void retrieveEntriesRecordTest() {
        World w = new World();
        w.setCurrentDay(1);
        TechGiant tg = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg);
        RecordEntry fe1 = ftsu.getLastEntry();
        RecordEntry fe2 = ftsu.getSecondToLastEntry();
        ftsu.addFinancialRecord();
        ftsu.addFinancialRecord();
        fe1 = ftsu.getLastEntry();
        fe2 = ftsu.getSecondToLastEntry();
        boolean entriesAreSame = fe1.equals(fe2);
        assertEquals(false, entriesAreSame);
    }

}
