package main.java.marketplace;

import main.java.actor.StartUp;

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
        this.opponentOneOffense = new Offense(opponentOne, opponentTwo);
        this.opponentTwoOffense = new Offense(opponentTwo, opponentOne);
        this.opponentOneDefense = new Defense(opponentOne, opponentTwo);
        this.opponentTwoDefense = new Defense(opponentTwo, opponentOne);
        
        combatCycle();
    }
    
    public void combatCycle() {
        
        if (counterOne / (opponentOne.getSpeed()) > 1) {
            opponentOneOffense.attack(opponentTwoDefense);
            setCounterOne(0);
        }
        
        if (counterTwo / (opponentTwo.getSpeed()) > 1) {
            opponentTwoOffense.attack(opponentOneDefense);
            setCounterTwo(0);
        }
//        
//        if(opponentOne.getRevenue() <= 0 ) {
//            opponentOne.die();
//            if( opponentOne.equals( Game.currentGame.getPlayer() ) ) {
//                world.print("You have ");
//                Game.currentGame.getUI().printColor( "died", Color.RED);
//                Game.currentGame.getUI().println( ".");
//            } else {
//                Game.currentGame.getUI().print( "The ");
//                Game.currentGame.getUI().printColor( opponentOne.toString(), Color.GREEN);
//                Game.currentGame.getUI().print( " has ");
//                Game.currentGame.getUI().printColor( "died", Color.RED );
//                Game.currentGame.getUI().println( "." );
//            }
//        }
//        
//        if(opponentTwo.getRevenue() <= 0 ) {
//            opponentTwo.die();
//            if( opponentTwo.equals( Game.currentGame.getPlayer() ) ) {
//                Game.currentGame.getUI().print( "You have ");
//                Game.currentGame.getUI().printColor( "died", Color.RED);
//                Game.currentGame.getUI().println( ".");
//            } else {
//                Game.currentGame.getUI().print( "The ");
//                Game.currentGame.getUI().printColor( opponentTwo.toString(), Color.GREEN);
//                Game.currentGame.getUI().print( " has ");
//                Game.currentGame.getUI().printColor( "died", Color.RED );
//                Game.currentGame.getUI().println( "." );
//            }
//        }
//        
//        if( !opponentOne.isAlive() || !opponentTwo.isAlive() ) {
//        
//            endFight();
//        }
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
