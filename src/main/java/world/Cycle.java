package main.java.world;

public class Cycle implements Runnable {
    
    private boolean running;
    private final double updateRate = 1.0d/60.0d;
    
    private Quarter currentQuarter;
    
    private World world;
    
    public Cycle(World w) {
        
        this.world = w;
        currentQuarter = new Quarter(0, 0);
    }

    @Override
    public void run() {
        
        running = true;
        double accumulator = 0;
        long currentTime = System.currentTimeMillis();
        long lastUpdate = System.currentTimeMillis();
        
        while(running) {
            
            currentTime = System.currentTimeMillis();
            double lastRenderTimeInSeconds = ( currentTime - lastUpdate ) / 1000d;
            accumulator += lastRenderTimeInSeconds;
            lastUpdate = currentTime;
            
            while(accumulator > updateRate) {
                
                update();
                accumulator -= updateRate;
            }
        }
    }
        
    private void update() {
        
        try {
            
            currentQuarter.incrementDay();
            
            world.updateWorld(currentQuarter.getCurrentQuarter(), currentQuarter.getCurrentDay());
            
            Thread.sleep(1000); 
            
        } catch (InterruptedException e) {
            
            e.printStackTrace();
            
        }
    }
    
    // getters and setters

    public Quarter getCurrentQuarter() {
        return currentQuarter;
    }

    public void setCurrentQuarter(Quarter currentQuarter) {
        this.currentQuarter = currentQuarter;
    }   
}

