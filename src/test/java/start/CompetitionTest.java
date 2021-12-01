package test.java.start;

import static org.junit.Assert.assertEquals;

import main.java.actor.FinancialTechStartUp;
import main.java.actor.GameTechStartUp;
import main.java.actor.TechGiant;
import main.java.marketplace.Competition;
import main.java.world.California;
import main.java.world.World;
import org.junit.Test;

public class CompetitionTest {

    /**
     * Tests endFight opponent 2.
     */
    @Test
    public void endFightOppTwoTest() {
        
        TechGiant tg1 = new TechGiant("test", "test");
        TechGiant tg2 = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg1);
        GameTechStartUp gtsu = new GameTechStartUp("test", "test", ca, tg2);
        ftsu.addHighIncomeCustomers(100);
        gtsu.addHighIncomeCustomers(100);
        tg1.getStartups().add(ftsu);
        tg2.getStartups().add(gtsu);
        World w = new World();
        w.getTechGiants().add(tg1);
        w.getTechGiants().add(tg2);
        Competition comp = new Competition(ftsu, gtsu);
        w.setCurrentCompetition(comp);
        w.setCurrentDay(1);

        gtsu.die();
        
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }
    
    /**
     * Tests endFight opponent 1.
     */
    @Test
    public void endFightOppOneTest() {
        TechGiant tg1 = new TechGiant("test", "test");
        TechGiant tg2 = new TechGiant("test", "test");
        California ca = new California();
        FinancialTechStartUp ftsu = new FinancialTechStartUp("test", "test", ca, tg1);
        GameTechStartUp gtsu = new GameTechStartUp("test", "test", ca, tg2);
        ftsu.addHighIncomeCustomers(100);
        gtsu.addHighIncomeCustomers(100);
        tg1.getStartups().add(ftsu);
        tg2.getStartups().add(gtsu);
        World w = new World();
        w.getTechGiants().add(tg1);
        w.getTechGiants().add(tg2);
        Competition comp = new Competition(ftsu, gtsu);
        w.setCurrentCompetition(comp);
        w.setCurrentDay(1);

        ftsu.die();
        
        comp.endFight();
        
        boolean compEnded = (w.getCurrentCompetition() == null);
        assertEquals(true, compEnded);
    }

}
