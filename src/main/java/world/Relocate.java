package main.java.world;

import java.util.HashMap;
import java.util.Map;

public class Relocate {
    
    private Map< String, Location > locations = new HashMap<>();
    
    public Relocate() {
        
        locations.put("CA", new California());
        locations.put("NY", new NewYork());
        locations.put("WA", new Washington());
        
    }
    
    public Location getLocation(String state) {
        
        try {
            
            return locations.get(state);
            
        } catch( IllegalArgumentException e ) {
            
            return null;
        } 
    }
    
    public boolean check(String s) {
        
        return locations.containsKey(s);
    }

}
