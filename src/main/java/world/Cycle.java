package main.java.world;

public class Cycle implements Runnable {
    
    private boolean running;
    private final double updateRate = 30.0d/60.0d;
    
    private Quarter currentQuarter;
    
    private World world;
    
    public Cycle(World w) {
        
        this.world = w;
        currentQuarter = w.getCurrentQuarter();
    }

    @Override
    public void run() {
        
        running = true;
        double accumulator = 0;
        long currentTime = System.currentTimeMillis();
        long lastUpdate = System.currentTimeMillis();
        
        while(running) {
            
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = (currentTime - lastUpdate) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;
            
            while(accumulator > updateRate) {
                
                update();
                accumulator -= updateRate;
            }
        }
    }
        
    private void update() {

        currentQuarter.incrementDay();
            
        world.updateWorld(currentQuarter.getCurrentQuarter(), currentQuarter.getCurrentDay());
    }
    
    // getters and setters

    public Quarter getCurrentQuarter() {
        
        return currentQuarter;
    }

    public void setCurrentQuarter(Quarter currentQuarter) {
        
        this.currentQuarter = currentQuarter;
    }   
}

