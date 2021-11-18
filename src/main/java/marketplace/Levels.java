package main.java.marketplace;

import java.util.ArrayList;

public class Levels {
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    
    public Levels() {
        
        levels.add(new GarageOffice());
    }
    
    public Level getLevel(int index) {
        
        return levels.get(index);
    }
    
    public Level levelUp(int index) {
        
        int i = index + 1;
        return levels.get(i);
    }
}
