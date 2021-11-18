package main.java.marketplace;

import main.java.actor.StartUp;
import main.java.world.Printer;

public class Competition {
    
    // opponent one //////////////////
    private StartUp opponentOne;
    private Offense opponentOneOffense;
    private Defense opponentOneDefense;
    private int counterOne;
    
    // opponent two //////////////////
    private StartUp opponentTwo;
    private Offense opponentTwoOffense;
    private Defense opponentTwoDefense;
    private int counterTwo;
    
    public Competition(StartUp actorOne, StartUp actorTwo) {
        
        this.setOpponentOne(actorOne);
        this.setOpponentTwo(actorTwo);
        this.setCounterOne(actorOne.getSpeed());
        this.setCounterTwo(actorTwo.getSpeed());
        this.opponentOne.setEngagedInCompetition(true);
        this.opponentTwo.setEngagedInCompetition(true);
        this.opponentOne.setCurrentCompetition(this);
        this.opponentTwo.setCurrentCompetition(this);
        this.opponentOneDefense = new Defense(opponentOne, opponentTwo);
        this.opponentTwoDefense = new Defense(opponentTwo, opponentOne);
        this.opponentOneOffense = new Offense(opponentOne, opponentTwo);
        this.opponentTwoOffense = new Offense(opponentTwo, opponentOne);
        
        combatCycle();
    }
    
    public void combatCycle() {
        
        if (counterOne / (opponentOne.getSpeed()) > 1) {
            
            opponentOneOffense.attack();        
            printScore(getOpponentOne());
            printScore(getOpponentTwo());
            setCounterOne(0);
        }
        
        if (counterTwo / (opponentTwo.getSpeed()) > 1) {
            
            opponentTwoOffense.attack();  
            printScore(getOpponentTwo());      
            printScore(getOpponentOne());
            setCounterTwo(0);
        }
        
        if(opponentOne.getRevenue() <= 0 ) {
            
            opponentOne.die();
        }
        
        if(opponentTwo.getRevenue() <= 0 ) {
            
            opponentTwo.die();
        }
        
        if (opponentOne.getLevel().compareXPBase(opponentOne.getXP())) {
            
            opponentOne.getLevels().levelUp(opponentOne.getLevel().getLevelNumber());
        }
        
        if (opponentTwo.getLevel().compareXPBase(opponentTwo.getXP())) {
            
            opponentTwo.getLevels().levelUp(opponentTwo.getLevel().getLevelNumber());
        }
        
        if( !opponentOne.isAlive() || !opponentTwo.isAlive() ) {
        
            endFight();
        }
        incrementCounters();
    }
    
    private void printScore(StartUp su) {
        
        Printer.println("");
        Printer.print(Printer.ANSI_CYAN, su.getName());
        Printer.print(" Revenue: ");
        
        if (su.getLastEntry().getRevenue() < su.getSecondToLastEntry().getRevenue()) {
            
            Printer.print(Printer.ANSI_RED, "$" + Double.toString(su.getRevenue())); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + Double.toString(su.getRevenue()));
        }
        
        Printer.print(" NetIncome: ");
        
        if (su.getLastEntry().getNetIncome() < su.getSecondToLastEntry().getNetIncome()) {
            
            Printer.print(Printer.ANSI_RED, "$" + Double.toString(su.getNetIncome())); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + Double.toString(su.getNetIncome()));
        }
        
        Printer.print(" MarketShare: ");
        
        if (su.getLastEntry().getMarketShare() < su.getSecondToLastEntry().getMarketShare()) {
            
            Printer.print(Printer.ANSI_RED, "$" + Double.toString(su.getMarketShare())); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + Double.toString(su.getMarketShare()));
        }
        
        Printer.println("");
        
    }

    public StartUp getOpponentOne() {
        
        return opponentOne;
    }

    public void setOpponentOne( StartUp actorOne ) {
        
        this.opponentOne = actorOne;
    }

    public StartUp getOpponentTwo() {
        
        return opponentTwo;
    }

    public void setOpponentTwo( StartUp actorTwo ) {
        
        this.opponentTwo = actorTwo;
    }

    public int getCounterOne() {
        
        return counterOne;
    }
    
    public int getCounterTwo() {
        
        return counterTwo;
    }

    public void setCounterOne( int counter ) {
        
        this.counterOne = counter;
    }
    
    public void setCounterTwo( int counter ) {
        
        this.counterTwo = counter;
    }
    
    public void incrementCounters() {
        
        this.counterOne++;
        this.counterTwo++;
    }
    
    public void endFight() {
        
        this.opponentOne.setEngagedInCompetition( false );
        this.opponentTwo.setEngagedInCompetition( false );
        this.opponentOne.setCurrentCompetition( null );
        this.opponentTwo.setCurrentCompetition( null );
    }
    
    public int selectAttack(StartUp startup) {
        
        return 0;
    }
}
