package main.java.marketplace;

import java.util.ArrayList;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Levels {
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    private StartUp su;
    
    public Levels(StartUp su) {
        
        levels.add(new GarageOffice());
        levels.add(new GarageOffice());
        this.su = su;
    }
    
    public Level getLevel(int index) {
        
        return levels.get(index);
    }
    
    public Level levelUp(int index) {
        
        int i = index + 1;
        Printer.print(Printer.ANSI_CYAN, su.getName());
        Printer.print(Printer.ANSI_YELLOW, " leveled up to ");
        Printer.print(Printer.ANSI_GREEN, levels.get(i).getTitle());
        Printer.println(Printer.ANSI_YELLOW, "!!!");
        return levels.get(i);
    }

    public StartUp getSu() {
        return su;
    }

    public void setSu(StartUp su) {
        this.su = su;
    }
}
