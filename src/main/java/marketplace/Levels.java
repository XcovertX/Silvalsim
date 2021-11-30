package main.java.marketplace;

import java.math.BigDecimal;
import java.util.ArrayList;

import main.java.actor.StartUp;
import main.java.world.Printer;

/**
 * Levels.java
 * Package: main.java.marketplace
 * Description: This is a factory class that builds all potential levels.
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class Levels {
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    private StartUp su;
    
    /**
     * Description: The Levels constructor assigns the startup it tracks and
     * populates the levels list
     * 
     * @author James Covert
     * @version 1.0
     * @param StartUp su - StartUp that uses this levels object
     *-----------------------------------------------------
     */
    public Levels(StartUp su) {
        
        this.su = su;
        
        levels.add(new GarageOffice());
        levels.add(new LocalStoreFrontOffice());
        levels.add(new HighriseBottomFloorOffice());
        levels.add(new HighriseMiddleFloorOffice());
        levels.add(new HighriseTopFloorOffice());
        levels.add(new OfficeCampus());
        levels.add(new OfficeCompound());
        levels.add(new OfficeUtopia());
    }
    
    /**
     * Description: This method sets the StartUp to to a given Level
     * 
     * @author James Covert
     * @version 1.0
     * @param int index - index where the level is located in levels
     * @return void
     *-----------------------------------------------------
     */
    public void setLevel(int index) {
        
        Level lvl = levels.get(index);
        this.su.setLevel(lvl);
        this.su.setXpToNextLevel(lvl.getBaseNumber());
        this.su.setLevelNumber(lvl.getLevelNumber());
        this.su.setAttackSuccessMultiplier(lvl.getSuccessMultiplier());
        this.su.setXPMin(lvl.getXPMin());
        this.su.setXPMax(lvl.getXPMax());
    }
    
    /**
     * Description: This method sets the StartUp to the next level
     * 
     * @author James Covert
     * @version 1.0
     * @param int index - su current level index
     * @return void
     *-----------------------------------------------------
     */
    public void levelUp(int index) {
        
        int i = index;
        
        if (i >= levels.size()) {
            
            return;
        }
        
        Level nextLevel = levels.get(i);
        this.su.setLevel(nextLevel);
        this.su.setXpToNextLevel(nextLevel.getBaseNumber());
        this.su.setLevelNumber(nextLevel.getLevelNumber());
        this.su.setAttackSuccessMultiplier(nextLevel.getSuccessMultiplier());
        this.su.setXPMin(nextLevel.getXPMin());
        this.su.setXPMax(nextLevel.getXPMax());
        this.su.increaseDesirability(nextLevel.getLevelNumber());
        
        this.su.increaseDesirability(50);
        this.su.increaseRevenue(new BigDecimal(10000000.00));
        
        Printer.println("");
        Printer.print(Printer.ANSI_CYAN, su.getName());
        Printer.println(" is now leveling up... ");
        Printer.println("");
        
        for (int j = 0; j < 50; j++) {
            
            Printer.print("=");
            try {
                
                Thread.sleep(50);
                
            } catch (InterruptedException e) {
                
                e.printStackTrace();
            }
        }

        Printer.print(Printer.ANSI_CYAN, " " + su.getName());
        Printer.print(" has leveled up to ");
        Printer.print(Printer.ANSI_GREEN, nextLevel.getTitle());
        Printer.println("!!!");
        Printer.println("");
    }

    // getters and setters
    
    public Level getLevel(int index) {
        
        return levels.get(index);
    }

    public StartUp getSu() {
        
        return su;
    }

    public void setSu(StartUp su) {
        
        this.su = su;
    }
}
