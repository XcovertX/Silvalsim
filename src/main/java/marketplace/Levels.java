package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.world.Printer;

/**
 * Levels.java
 * Package: main.java.marketplace
 * Description: This is a factory class that builds all potential levels.
 * 
 * @author James Covert
 * @version 1.0
 */

public class Levels {
    
    private OfficeLevelRepository lvls;
    private StartUp su;
    
    /**
     * Description: The Levels constructor assigns the startup it tracks and
     * sets OfficeLevelRepository lvls.
     * 
     * @author James Covert
     * @version 1.0
     * @param su - StartUp that uses this levels object
     */
    public Levels(StartUp su) {
        
        this.su = su;
        setLvls(new OfficeLevelRepository());
    }
    
    /**
     * Description: This method sets the StartUp to to a given Level.
     * 
     * @author James Covert
     * @version 1.0
     * @param levelNumber - the level number of the needed Level
     */
    public void setLevel(int levelNumber) {
        

        for (Iterator iter = lvls.getIterator(); iter.hasNext();) {
            Level lvl = (Level)iter.next();
            if (lvl.getLevelNumber() == levelNumber) {
                
                this.su.setLevel(lvl);
                this.su.setXpToNextLevel(lvl.getBaseNumber());
                this.su.setLevelNumber(lvl.getLevelNumber());
                this.su.setAttackSuccessMultiplier(lvl.getSuccessMultiplier());
                this.su.setXpMin(lvl.getXpMin());
                this.su.setXpMax(lvl.getXpMax());
            }
        }
    }
    
    /**
     * Description: This method sets the StartUp to the next level.
     * It utilizes the iterator OfficeLevelRepository to iterate through
     * the available Levels to find the next one
     * 
     * @author James Covert
     * @version 1.0
     */
    public void levelUp() {
        
        for (Iterator iter = lvls.getIterator(); iter.hasNext();) {
            Level nextLevel = (Level)iter.next();
            if (nextLevel.getLevelNumber() > su.getLevelNumber()) {

                this.su.setLevel(nextLevel);
                this.su.setXpToNextLevel(nextLevel.getBaseNumber());
                this.su.setLevelNumber(nextLevel.getLevelNumber());
                this.su.setAttackSuccessMultiplier(nextLevel.getSuccessMultiplier());
                this.su.setXpMin(nextLevel.getXpMin());
                this.su.setXpMax(nextLevel.getXpMax());
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
                break;
            }
        } 
    }
    
    /**
     * Description: This method retrieves a level by a given int.
     * 
     * @author James Covert
     * @version 1.0
     */
    public Level getLevel(int levelNumber) {
        
        for (Iterator iter = lvls.getIterator(); iter.hasNext();) {
            Level l = (Level)iter.next();
            if (l.getLevelNumber() == levelNumber) {

                return l;
            }
        } 
        return new OfficeUtopia();
    }

    public StartUp getSu() {
        
        return su;
    }

    public void setSu(StartUp su) {
        
        this.su = su;
    }

    public OfficeLevelRepository getLvls() {
        
        return lvls;
    }

    public void setLvls(OfficeLevelRepository lvls) {
        
        this.lvls = lvls;
    }
}
