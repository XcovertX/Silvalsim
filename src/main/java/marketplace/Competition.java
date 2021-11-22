package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.world.Printer;
import main.java.world.World;

public class Competition {
    
    World world;
    
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
    
    public Competition(World world, StartUp actorOne, StartUp actorTwo) {
        
        this.world = world;
        
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
        
        printChallengeStart(opponentOne, opponentTwo);
        
        combatCycle();
    }
    
    public void combatCycle() {
        
        if (counterOne / (opponentOne.getSpeed()) > 1) {
  
            opponentOneOffense.attack();    
            opponentTwoDefense.Defend();
            setCounterOne(0);
        }
        
        if (counterTwo / (opponentTwo.getSpeed()) > 1) {
 
            opponentTwoOffense.attack();    
            opponentOneDefense.Defend();  
            setCounterTwo(0);
        }
        
        if (opponentOne.getRevenue().compareTo(new BigDecimal(0)) <= 0 ) {
            
            opponentOne.die();
            
        } else if (opponentTwo.getRevenue().compareTo(new BigDecimal(0)) <= 0 ) {
            
            opponentTwo.die();
        }
        
        if (opponentOne.compareXPToNextLevelXP()) {
            
            opponentOne.getLevels().levelUp(opponentOne.getLevelNumber());
        }
        
        if (opponentTwo.compareXPToNextLevelXP()) {
            
            opponentTwo.getLevels().levelUp(opponentTwo.getLevelNumber());
        }
        
        if( !opponentOne.isAlive() || !opponentTwo.isAlive() ) {
        
            endFight();
        }
        incrementCounters();
    }
    
    public void printScore(StartUp su) {
        
        Printer.print(Printer.ANSI_CYAN, su.getName());
        Printer.print(" Monthly Revenue: ");
        
        if (su.getRevenue().compareTo(su.getPreviousMonthRevenue(this.world.getCurrentQuarter().getCurrentDay())) < 0) {
            
            Printer.print(Printer.ANSI_RED, "$" + su.getRevenue().toString()); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + su.getRevenue().toString());
        
        }
        
        Printer.print(" NetIncome: ");
        
        if (su.getLastEntry().getNetIncome().compareTo(su.getPreviousMonthRevenue(this.world.getCurrentQuarter().getCurrentDay())) < 0) {
            
            Printer.print(Printer.ANSI_RED, "$" + su.getNetIncome().toString()); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + su.getNetIncome().toString());
        }
        
        Printer.print(" MarketShare: ");
        
        if (su.getLastEntry().getMarketShare().compareTo(su.getSecondToLastEntry().getMarketShare()) < 0) {
            
            Printer.print(Printer.ANSI_RED, "$" + su.getMarketShare().toString()); 
            
        } else {
            
            Printer.println(Printer.ANSI_GREEN, "$" + su.getMarketShare().toString());
        }
        
        Printer.print(Printer.ANSI_YELLOW, "XP: " + Integer.toString(su.getXP()));
        
        Printer.print(Printer.ANSI_BLUE, " Office Level: " + su.getLevel().getTitle());
        
        Printer.print(Printer.ANSI_YELLOW, " Customer Count: " + Integer.toString(su.getCustomers().size()));
        
        Printer.println(Printer.ANSI_BLUE, " Dev Count: " + su.getDevs().size());
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
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
        
        if (opponentOne.isAlive()) {
            
            awardStartUp(opponentOne, opponentTwo);
            printResults(opponentOne, opponentTwo);
            
        } else {
            
            awardStartUp(opponentTwo, opponentOne);  
            printResults(opponentTwo, opponentOne);
        }
        
        this.opponentOne.removeaAllFees();
        this.opponentOne.removeaAllLegalBettleExpenses();
        this.opponentTwo.removeaAllFees();
        this.opponentTwo.removeaAllLegalBettleExpenses();
        
        this.opponentOne.setEngagedInCompetition(false);
        this.opponentTwo.setEngagedInCompetition(false );
        this.opponentOne.setCurrentCompetition(null);
        this.opponentTwo.setCurrentCompetition(null);
        this.world.setCurrentCompetition(null); 
    }
    
    public int selectAttack(StartUp startup) {
        
        return 0;
    }
    
    public void awardStartUp(StartUp winningStartUp, StartUp losingStartUp) {
        
        TechGiant winningTechGiant = winningStartUp.getTechGiant();
        TechGiant losingTechGiant = losingStartUp.getTechGiant();
        
        winningTechGiant.getStartups().add(losingStartUp);
        losingTechGiant.getStartups().remove(losingStartUp);
    }
    
    public void printResults(StartUp winningStartUp, StartUp losingStartUp) {
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        Printer.println(Printer.ANSI_PURPLE, "*                              Competition Results                             *");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        
        Printer.print(Printer.ANSI_CYAN, winningStartUp.getName());
        Printer.println(" has won the competition!!");
        Printer.print(Printer.ANSI_CYAN, winningStartUp.getTechGiant().getName());
        Printer.print(" has now aquired ");
        Printer.print(Printer.ANSI_CYAN, losingStartUp.getName());
        Printer.println("!!");
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
    }
    
    public void printChallengeStart(StartUp su1, StartUp su2) {
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        Printer.println(Printer.ANSI_PURPLE, "*                                Starting Summary                              *");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        
        Printer.print(Printer.ANSI_CYAN, su1.getName());
        Printer.print(" is now competing against ");
        Printer.print(Printer.ANSI_CYAN, su2.getName());
        Printer.println("!!");
        
        Printer.println("");
        
        printScore(opponentOne);
        printScore(opponentTwo);
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
    }
}
