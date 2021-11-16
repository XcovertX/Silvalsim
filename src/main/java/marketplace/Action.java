package main.java.marketplace;

import java.util.Random;

public abstract class Action {
    
    public String[] actionDescriptors;
    
    public abstract void run();

    public abstract void run( String thingName );
    
    public abstract void run( String thingName, String preposition );
    
    public abstract void run( String thingNameOne, String preposition, String thingNameTwo );
    
    public String getRandomActionDescriptor() {
        Random rand = new Random();
        int randomIndex = rand.nextInt( actionDescriptors.length );
        String descriptor = actionDescriptors[ randomIndex ];
        return descriptor;
    }

    public String[] getActionDescriptors() {
        return actionDescriptors;
    }

    public void setActionDescriptors(String[] actionDescriptors) {
        this.actionDescriptors = actionDescriptors;

    }
}
