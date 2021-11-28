package main.java.marketplace;

import java.util.ArrayList;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Levels {
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    private StartUp su;
    
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
    
    public void setLevel(int index) {
        
        Level lvl = levels.get(index);
        this.su.setLevel(lvl);
        this.su.setXpToNextLevel(lvl.getBaseNumber());
        this.su.setLevelNumber(lvl.getLevelNumber());
        this.su.setAttackSuccessMultiplier(lvl.getSuccessMultiplier());
        this.su.setXPMin(lvl.getXPMin());
        this.su.setXPMax(lvl.getXPMax());
    }
    
    public Level getLevel(int index) {
        
        return levels.get(index);
    }
    
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

    public StartUp getSu() {
        return su;
    }

    public void setSu(StartUp su) {
        this.su = su;
    }
}
