package main.java.world;

/**
 * Cycle.java
 * Package: main.java.world
 * Description: This method implements Runnable. 
 * The primary purpose of this class is to increment update the world twice a second
 * 
 * @author James Covert
 * @version 1.0
 */

public class Cycle implements Runnable {
    
    private boolean running;
    private static final double updateRate = 30.0d / 60.0d;
    
    private Quarter currentQuarter;
    
    private World world;
    
    /**
     * Description: Cycle constructor assigns the world that cycle is updating.
     * 
     * @author James Covert
     * @version 1.0
     * @param w - current World object
     */
    public Cycle(World w) {
        
        this.world = w;
        currentQuarter = w.getCurrentQuarter();
    }

    /**
     * Description: This method runs the loop for updating the world.
     * 
     * @author James Covert
     * @version 1.0
     */
    @Override
    public void run() {
        
        running = true;
        double accumulator = 0;
        long currentTime = System.currentTimeMillis();
        long lastUpdate = System.currentTimeMillis();
        
        while (running) {
            
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;
            
            while (accumulator > updateRate) {
                
                update();
                accumulator -= updateRate;
            }
        }
    }
    
    /**
     * Description: This method is called by the loop to update the world.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void update() {

        currentQuarter.incrementDay();
            
        world.updateWorld(currentQuarter.getCurrentDay());
    }
    
    // getters and setters

    public Quarter getCurrentQuarter() {
        
        return currentQuarter;
    }

    public void setCurrentQuarter(Quarter currentQuarter) {
        
        this.currentQuarter = currentQuarter;
    }   
}

