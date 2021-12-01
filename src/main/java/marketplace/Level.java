package main.java.marketplace;

import main.java.world.RandomNumber;

/**
 * Level.java
 * Package: main.java.marketplace
 * Description: The is an abstract class that is the basis for
 * all levels: GarageOffice, LocalStoreFront, HighriseBottomFloorOffice,
 * HighriseMiddleFloorOffice, HighriseTopFloorOffice, OfficeCampus,
 * OfficeCompound, OfficeUtopia
 * 
 * @author James Covert
 * @version 1.0
 */
public abstract class Level {
    
    private String title;
    private int levelNumber;
    private int successMultiplier; 
    private int baseNumber;
    private int attackCostMultiplier;
    private int defendCostMultiplier;
    private int xpMin;
    private int xpMax;
    
    /**
     * Description: The method compares given xp to baseLevelXP.
     * 
     * @author James Covert
     * @version 1.0
     * @param xp - startup's xp
     */
    public boolean compareXpBase(int xp) {
        
        if (xp > baseNumber) {
            
            return true;   
        }
        return false;
    }
    
    // getters and setters
    
    public int getXp() {

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

    public int getXpMin() {
        
        return xpMin;
    }

    public void setXpMin(int xpMin) {
        
        this.xpMin = xpMin;
    }

    public int getXpMax() {
        
        return xpMax;
    }

    public void setXpMax(int xpMax) {
        
        this.xpMax = xpMax;
    }

    public int getAttackCostMultiplier() {
        
        return attackCostMultiplier;
    }

    public void setAttackCostMultiplier(int attackCostMultiplier) {
        
        this.attackCostMultiplier = attackCostMultiplier;
    }

    public int getDefendCostMultiplier() {
        
        return defendCostMultiplier;
    }

    public void setDefendCostMultiplier(int defendCostMultiplier) {
        
        this.defendCostMultiplier = defendCostMultiplier;
    }
}
