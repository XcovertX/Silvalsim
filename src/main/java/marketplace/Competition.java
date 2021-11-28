package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.world.Printer;
import main.java.world.Quarter;
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
    }
    
    public void combatCycle() {
        
        boolean noAction = true;
        
        if (counterOne > opponentOne.getSpeed() - opponentOne.getLevelNumber()) {
  
            Printer.println("");
            World.world.getCurrentQuarter().printTimeStamp();
            opponentOneOffense.attack();    
            opponentTwoDefense.Defend();
            setCounterOne(0);
            noAction = false;
            Printer.println("");
            
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (counterTwo > opponentTwo.getSpeed() - opponentTwo.getLevelNumber()) {
 
            if (counterOne != 0) {
                
                Printer.println("");
            }
            
            World.world.getCurrentQuarter().printTimeStamp();
            opponentTwoOffense.attack();    
            opponentOneDefense.Defend();
            setCounterTwo(0);
            noAction = false;
            Printer.println("");
            
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (noAction) {
            
//            if (!(World.world.getCurrentDay() == 1)) {
//                
//                Printer.println("Day: " + World.world.getCurrentDay() + " no combat recorded.");
//            }
//            if (World.world.getCurrentDay() >= 30) {
//                
//                Printer.println("");
//            }
        }
        
        if (opponentOne.getRevenue().compareTo(new BigDecimal(0)) <= 0 ) {
            
             opponentOne.die();
            
            Printer.println("");
            Printer.print(Printer.ANSI_RED, opponentOne.getName());
            Printer.println(Printer.ANSI_RED, " has been defeated!!");
            Printer.println("");
            
        } else if (opponentTwo.getRevenue().compareTo(new BigDecimal(0)) <= 0 ) {
            
            opponentTwo.die();
            
            Printer.println("");
            Printer.print(Printer.ANSI_RED, opponentTwo.getName());
            Printer.println(Printer.ANSI_RED, " has been defeated!!");
            Printer.println("");
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
        
        Printer.print("Tech Giant: ");
        Printer.print(Printer.ANSI_CYAN, su.getTechGiant().getName() + " --- ");
        
        Printer.print("Startup: ");
        Printer.println(Printer.ANSI_CYAN, su.getName());
        
        Printer.print("Revenue: ");
        
        if (su.getRevenue().compareTo(su.getSecondToLastEntry().getMonthlyRevenue()) < 0) {
             
            Printer.print(Printer.ANSI_RED, "$" + su.getRevenue().toString()); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + su.getRevenue().toString());
        
        }
        
        Printer.print(" NetIncome: ");
        
        if (su.getLastEntry().getNetIncome().compareTo(su.getSecondToLastEntry().getNetIncome()) < 0) {
            
            Printer.print(Printer.ANSI_RED, "$" + su.getNetIncome().toString()); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + su.getNetIncome().toString());
        }
        
        Printer.print(" MarketShare: ");
        
        if (su.getLastEntry().getMarketShare().compareTo(su.getSecondToLastEntry().getMarketShare()) < 0) {
            
            Printer.println(Printer.ANSI_RED, "$" + su.getMarketShare().toString()); 
            
        } else {
            
            Printer.println(Printer.ANSI_GREEN, "$" + su.getMarketShare().toString());
        }
        
        Printer.print(Printer.ANSI_YELLOW, "XP: ");
        Printer.print(Integer.toString(su.getXP()));

        Printer.print(Printer.ANSI_YELLOW, " Customer Count: ");
        if (su.getCustomers().size() > su.getSecondToLastEntry().getNumberOfCustomers()) {
            
            Printer.print(Printer.ANSI_GREEN, Integer.toString(su.getCustomers().size()));
        
        } else if (su.getCustomers().size() < su.getSecondToLastEntry().getNumberOfCustomers()) {
            
            Printer.print(Printer.ANSI_RED, Integer.toString(su.getCustomers().size()));
        
        } else {
            
            Printer.print(Integer.toString(su.getCustomers().size()));
            
        }
        
        Printer.print(Printer.ANSI_YELLOW, " Dev Count: ");
        if (su.getDevs().size() > su.getSecondToLastEntry().getNumberOfDevs()) {
            
            Printer.println(Printer.ANSI_GREEN, Integer.toString(su.getDevs().size()));
            
        } else if (su.getDevs().size() < su.getSecondToLastEntry().getNumberOfDevs()) {
            
            Printer.println(Printer.ANSI_RED, Integer.toString(su.getDevs().size()));
        
        } else {
            
            Printer.println(Integer.toString(su.getDevs().size()));
            
        }
        
        Printer.print(Printer.ANSI_YELLOW, "Office Level: ");
        Printer.println(su.getLevel().getTitle());
        
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
        
        if (!opponentTwo.isAlive()) {
            
            award(opponentOne, opponentTwo);
            
            if (opponentTwo.getTechGiant().getStartups().isEmpty()) {
                
                opponentTwo.getTechGiant().die();
            }
            
            opponentTwo.setXP(0);
            
            printResults(opponentOne, opponentTwo);
            
        } 
        
        if (!opponentOne.isAlive()) {

            award(opponentTwo, opponentOne);
            
            if (opponentOne.getTechGiant().getStartups().isEmpty()) {
                
                opponentOne.getTechGiant().die();
            }
            
            opponentOne.setXP(0);

            printResults(opponentTwo, opponentOne);
        }
        
        this.opponentOne.removeAllFees();
        this.opponentOne.removeAllLegalBattleExpenses();
        this.opponentTwo.removeAllFees();
        this.opponentTwo.removeAllLegalBattleExpenses();
        
        this.opponentOne.setEngagedInCompetition(false);
        this.opponentTwo.setEngagedInCompetition(false );
        this.opponentOne.setCurrentCompetition(null);
        this.opponentTwo.setCurrentCompetition(null);
        World.world.setCurrentCompetition(null); 
    }
    
    private void printOwnership() {
        
        Printer.println("");
        Printer.println("Number of tech giants in the marketplace: " + world.getTechGiants().size());
        
        for (int i = 0; i < world.getTechGiants().size(); i++) {
            
            TechGiant tg = world.getTechGiants().get(i);
            Printer.print(Printer.ANSI_CYAN, tg.getName());
            Printer.print(" now owns: ");
            
            for (int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                Printer.print(Printer.ANSI_CYAN, su.getName());
                if (j + 1 < tg.getStartups().size()) {
                    
                    Printer.print(", ");
                }
            }
            Printer.println("");
        }  
    }

    public int selectAttack(StartUp startup) {
        
        return 0;
    }
    
    private void award(StartUp winningSU, StartUp losingSU) {
        
        awardStartUp(winningSU, losingSU);
        awardWinnerXP(winningSU, losingSU);
        awardLevelUp(winningSU);
    }
    
    private void awardStartUp(StartUp winningStartUp, StartUp losingStartUp) {
        
        TechGiant winningTechGiant = winningStartUp.getTechGiant();
        TechGiant losingTechGiant = losingStartUp.getTechGiant();
        
        for (int i = 0; i < losingTechGiant.getStartups().size(); i++) {
            
            if(losingTechGiant.getStartups().get(i).getName().equals(losingStartUp.getName())) {
                losingTechGiant.getStartups().get(i).setAlive(true);
                losingTechGiant.getStartups().get(i).setTechGiant(winningTechGiant);
                winningTechGiant.getStartups().add(losingTechGiant.getStartups().get(i));
                losingTechGiant.getStartups().remove(i);
                break;
            }
        }
    }
    
    public void awardXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXP(su1.getXP() + lvl.getXP());
    }
    
    public void awardCriticalXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXP(su1.getXP() + (su1.getTalentMultiplier() * 2) + (lvl.getXP() * 2));
    }
    
    private void awardWinnerXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXP(su1.getXP() + (su1.getTalentMultiplier() * 3) + (lvl.getXP() * su1.getLevelNumber()));
    }
    
    public void awardLevelUp(StartUp su) {
        
        if (su.compareXPToNextLevelXP()){
            
            su.getLevels().levelUp(su.getLevelNumber());
            
            if (su.compareXPToNextLevelXP()) {
                
                awardLevelUp(su);
            } 
        }
    }
    
    public void printResults(StartUp winningStartUp, StartUp losingStartUp) {
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        Printer.println(Printer.ANSI_PURPLE, "*                              Competition Results                             *");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        
        Printer.print(Printer.ANSI_CYAN, winningStartUp.getName());
        Printer.println(" has won the competition!!");
        Printer.println("");
        Printer.print(Printer.ANSI_CYAN, winningStartUp.getTechGiant().getName());
        Printer.print(" has now aquired ");
        Printer.print(Printer.ANSI_CYAN, losingStartUp.getName());
        Printer.println("!!");
        
        printOwnership();
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
    }
    
    public void printChallengeStart(StartUp su1, StartUp su2) {
        
        Printer.println("");
        Printer.print(Printer.ANSI_CYAN, su1.getName());
        Printer.print(" owned by ");        
        Printer.print(Printer.ANSI_CYAN, su1.getTechGiant().getName());
        Printer.print(" is now competing against ");
        Printer.print(Printer.ANSI_CYAN, su2.getName());
        Printer.print(" owned by ");        
        Printer.print(Printer.ANSI_CYAN, su2.getTechGiant().getName());
        Printer.println("!!");
        Printer.println("");
        
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");
        Printer.println(Printer.ANSI_PURPLE, "*                                Starting Summary                              *");
        Printer.println(Printer.ANSI_PURPLE, "********************************************************************************");

        printScore(opponentOne);
        printScore(opponentTwo);
    }
}
