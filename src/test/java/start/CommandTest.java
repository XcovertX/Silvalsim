package test.java.start;

import static org.junit.Assert.assertEquals;

import org.junit.Test;

import main.java.actor.FinancialTechStartUp;
import main.java.actor.GameTechStartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.AdvertiseCommand;
import main.java.marketplace.BribePoliticianCommand;
import main.java.marketplace.Competition;
import main.java.marketplace.DodgeCommand;
import main.java.marketplace.DrainTalentCommand;
import main.java.marketplace.LiquidateCommand;
import main.java.marketplace.Offense;
import main.java.marketplace.RecruitTalentCommand;
import main.java.marketplace.StealTradeSecretCommand;
import main.java.marketplace.UndercutPricesCommand;
import main.java.world.California;
import main.java.world.World;

public class CommandTest {

    /**
     * Tests DrainTalent.
     */
    @Test
    public void drainTalentTest() {
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

        new DrainTalentCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests BribePolitician.
     */
    @Test
    public void bribePoliticianTest() {
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

        new BribePoliticianCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests Trade Theft.
     */
    @Test
    public void tradeTheftTest() {
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

        new StealTradeSecretCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests UndercutPirces.
     */
    @Test
    public void undercutPricesTest() {
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

        new UndercutPricesCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests Advertise.
     */
    @Test
    public void advertiseTest() {
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

        new AdvertiseCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests recruitTalent.
     */
    @Test
    public void recruitTalentTest() {
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

        new RecruitTalentCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests liquidate command.
     */
    @Test
    public void liquidateTest() {
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

        new LiquidateCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests dodge command.
     */
    @Test
    public void dodgeTest() {
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

        new DodgeCommand(ftsu, gtsu).execute();
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
}
