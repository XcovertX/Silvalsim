package main.java.marketplace;

public abstract class Level {
    
    private String title;
    private int levelNumber;
    private int successMultiplier; 
    private int baseNumber;
    
    public boolean compareXPBase(int xp) {
        
        if (xp > baseNumber) {
            
            return true;
            
        }
        return false;
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
}
