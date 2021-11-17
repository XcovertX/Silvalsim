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
            setCounterOne(0);
        }
        
        if (counterTwo / (opponentTwo.getSpeed()) > 1) {
            opponentTwoOffense.attack();
            setCounterTwo(0);
        }
        
        if(opponentOne.getRevenue() <= 0 ) {
            opponentOne.die();
        }
        
        if(opponentTwo.getRevenue() <= 0 ) {
            opponentTwo.die();
        }
        
        if( !opponentOne.isAlive() || !opponentTwo.isAlive() ) {
        
            endFight();
        }
        incrementCounters();
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
