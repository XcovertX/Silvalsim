package main.java.marketplace;

import main.java.world.RandomNumber;

public abstract class Level {
    
    private String title;
    private int levelNumber;
    private int successMultiplier; 
    private int baseNumber;
    private int xpMin;
    private int xpMax;
    
    public boolean compareXPBase(int xp) {
        
        if (xp > baseNumber) {
            
            return true;   
        }
        return false;
    }
    
    public int getXP() {

        return RandomNumber.getRandomBetween(xpMin, xpMax);
    }

    public String getTitle() {
        
        return title;
    }

    public void setTitle(String title) {
        
        this.title = title;
    }

    public int getSuccessMultiplier() {
        
        return successMultiplier;
    }

    public void setSuccessMultiplier(int successMultiplier) {
        
        this.successMultiplier = successMultiplier;
    }

    public int getBaseNumber() {
        
        return baseNumber;
    }

    public void setBaseNumber(int baseNumber) {
        
        this.baseNumber = baseNumber;
    }

    public int getLevelNumber() {
        
        return levelNumber;
    }

    public void setLevelNumber(int levelNumber) {
        
        this.levelNumber = levelNumber;
    }

    public int getXPMin() {
        
        return xpMin;
    }

    public void setXPMin(int xpMin) {
        
        this.xpMin = xpMin;
    }

    public int getXPMax() {
        
        return xpMax;
    }

    public void setXPMax(int xpMax) {
        
        this.xpMax = xpMax;
    }
}
