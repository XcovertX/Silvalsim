package main.java.marketplace;

import java.math.BigDecimal;

import main.java.actor.StartUp;
import main.java.actor.TechGiant;
import main.java.world.Printer;
import main.java.world.World;

/**
 * Competition.java
 * Package: main.java.marketplace
 * Description: Competition allows for two startups to compete
 * 
 * @author James Covert
 * @version 1.0
 */

public class Competition {
    
    // opponent one //////////////////
    private StartUp opponentOne;        // StartUp1
    private Offense opponentOneOffense; // StartUp1 offense used to deploy attacks
    private Defense opponentOneDefense; // StartUp1 offense used to deploy defenses 
    private int counterOne;             // used to determine when SU1 is ready to attack
    
    // opponent two //////////////////
    private StartUp opponentTwo;        // StartUp2
    private Offense opponentTwoOffense; // StartUp2 offense used to deploy attacks
    private Defense opponentTwoDefense; // StartUp2 offense used to deploy defenses 
    private int counterTwo;             // used to determine when SU2 is ready to attack
    
    /**
     * Description: The Competition constructor assigns the variables.
     * required from the two competing startups
     * and assigns the two competing opponents
     * Lastly, it call printChallengeStart which prints the start message
     * 
     * @author James Covert
     * @version 1.0
     * @param su1 - the startup deploying a defense
     * @param su2 - the startup receiving the defense
     */
    public Competition(StartUp su1, StartUp su2) {

        this.setOpponentOne(su1);
        this.setOpponentTwo(su2);
        this.setCounterOne(su1.getSpeed());
        this.setCounterTwo(su2.getSpeed());
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
    
    /**
     * Description: This method is called once a day.
     * It first checks to see who is ready to attack.
     * If the opponent is ready for attack, it calls on the startup's Offense
     * It then calls on their opponents Defense
     * It then resets the attacking startup's counter to 0
     * It then checks if either opponent's revenue has dropped below 0
     * If an opponents revenue drops below 0, it dies and prints defeat msg
     * It then checks if either opponent is ready to level up
     * If level up ready, the su's level is increased
     * It then check if either opponent is dead.
     * If dead, endFight() is called

     * @author James Covert
     * @version 1.0
     */
    public void combatCycle() {
        
        if (counterOne > opponentOne.getSpeed() - opponentOne.getLevelNumber()) {
  
            Printer.println("");
            World.world.getCurrentQuarter().printTimeStamp();
            opponentOneOffense.attack();    
            opponentTwoDefense.Defend();
            setCounterOne(0);
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
            Printer.println("");
            
            try {
                Thread.sleep(1500);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
        if (opponentOne.getRevenue().compareTo(new BigDecimal(0)) <= 0) {
            
            opponentOne.die();
            
            Printer.println("");
            Printer.print(Printer.ANSI_RED, opponentOne.getName());
            Printer.println(Printer.ANSI_RED, " has been defeated!!");
            Printer.println("");
            
        } else if (opponentTwo.getRevenue().compareTo(new BigDecimal(0)) <= 0) {
            
            opponentTwo.die();
            
            Printer.println("");
            Printer.print(Printer.ANSI_RED, opponentTwo.getName());
            Printer.println(Printer.ANSI_RED, " has been defeated!!");
            Printer.println("");
        }
        
        if (opponentOne.compareXpToNextLevelXp()) {
            
            opponentOne.getLevels().levelUp();
        }
        
        if (opponentTwo.compareXpToNextLevelXp()) {
            
            opponentTwo.getLevels().levelUp();
        }
        
        if (!opponentOne.isAlive() || !opponentTwo.isAlive()) {
        
            endFight();
        }
        incrementCounters();
    }
    
    /**
     * Description: This method is called twice a day, once for each opponent.
     * It prints the startup's stats: 
     * revenue, netIncome, marketShare, xp, devcount, customer count, office level

     * @author James Covert
     * @version 1.0
     */
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
        
        if (su.getLastEntry().getNetIncome()
                .compareTo(su.getSecondToLastEntry().getNetIncome()) < 0) {
            
            Printer.print(Printer.ANSI_RED, "$" + su.getNetIncome().toString()); 
            
        } else {
            
            Printer.print(Printer.ANSI_GREEN, "$" + su.getNetIncome().toString());
        }
        
        Printer.print(" MarketShare: ");
        
        if (su.getLastEntry().getMarketShare()
                .compareTo(su.getSecondToLastEntry().getMarketShare()) < 0) {
            
            Printer.println(Printer.ANSI_RED, "$" + su.getMarketShare().toString()); 
            
        } else {
            
            Printer.println(Printer.ANSI_GREEN, "$" + su.getMarketShare().toString());
        }
        
        Printer.print(Printer.ANSI_YELLOW, "XP: ");
        Printer.print(Integer.toString(su.getXp()));

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
        
        Printer.println(Printer.ANSI_PURPLE, "************************"
                + "********************************************************");
    }
    
    /**
     * Description: This method ends the competition.
     * It awards the dead startup to the winning techgiant.
     * It determines if the tech giant owing the dead start up
     * It then sets the dead startup's xp to 0;
     * It then adds 1000000.00 to the dead startup.
     * It then prints results.
     * has any more startups.
     * If the tech giant does not have any, it is marked as dead.
     * Lastly, it removes ongoing legal fees and sets competition to null
     * 
     * @author James Covert
     * @version 1.0
     */
    public void endFight() {
        
        if (!opponentTwo.isAlive()) {
            
            award(opponentOne, opponentTwo);
            
            if (opponentTwo.getTechGiant().getStartups().isEmpty()) {
                
                opponentTwo.getTechGiant().die();
            }
            
            opponentTwo.setXp(0);

            opponentTwo.setRevenue(new BigDecimal(1000000.00));
            
            printResults(opponentOne, opponentTwo);
            
        } 
        
        if (!opponentOne.isAlive()) {

            award(opponentTwo, opponentOne);
            
            if (opponentOne.getTechGiant().getStartups().isEmpty()) {
                
                opponentOne.getTechGiant().die();
            }
            
            opponentOne.setXp(0);

            opponentOne.setRevenue(new BigDecimal(1000000.00));
            
            printResults(opponentTwo, opponentOne);
        }
        
        this.opponentOne.removeAllLegalBattleExpenses();
        this.opponentTwo.removeAllLegalBattleExpenses();
        
        this.opponentOne.setEngagedInCompetition(false);
        this.opponentTwo.setEngagedInCompetition(false );
        this.opponentOne.setCurrentCompetition(null);
        this.opponentTwo.setCurrentCompetition(null);
        World.world.setCurrentCompetition(null); 
    }
    
    /**
     * Description: This method prints the ownership of all startups.

     * @author James Covert
     * @version 1.0
     */
    private void printOwnership() {
        
        Printer.println("");
        Printer.println("Number of tech giants in the marketplace: " 
        + World.world.getTechGiants().size());
        
        for (int i = 0; i < World.world.getTechGiants().size(); i++) {
            
            TechGiant tg = World.world.getTechGiants().get(i);
            Printer.print(Printer.ANSI_CYAN, tg.getName());
            Printer.print(" now owns: ");
            
            int counter = 0;
            for (int j = 0; j < tg.getStartups().size(); j++) {
                
                StartUp su = tg.getStartups().get(j);
                
                Printer.print(Printer.ANSI_CYAN, su.getName());
                if ( 1 + j < tg.getStartups().size()) {
                  
                    Printer.print(", ");
                }
                
                if (counter > 2) {
                    
                    Printer.println("");
                    counter = 0;
                    
                } else {
                    
                    counter++;
                }
            }
            Printer.println("");
        }  
    }
    
    /**
     * Description: This method calls all award methods.

     * @author James Covert
     * @version 1.0
     * @param winningSU - the winning SU
     * @param losingSU - the losing SU
     */
    private void award(StartUp winningSU, StartUp losingSU) {
        
        awardStartUp(winningSU, losingSU);
        awardWinnerXP(winningSU, losingSU);
        awardLevelUp(winningSU);
    }
    
    /**
     * Description: This method awards the dead startup to the winning tech giant.

     * @author James Covert
     * @version 1.0
     * @param winningSU - the winning SU
     * @param losingSU - the losing SU
     */
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
    
    /**
     * Description: This method awards xp to the winning StartUp.

     * @author James Covert
     * @version 1.0
     * @param winningSU - the winning SU
     * @param losingSU - the losing SU
     */
    public void awardXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXp(su1.getXp() + lvl.getXp());
    }
    
    /**
     * Description: This method awards critical xp to the winning StartUp.

     * @author James Covert
     * @version 1.0
     * @param winningSU - the winning SU
     * @param losingSU - the losing SU
     */
    public void awardCriticalXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXp(su1.getXp() + (su1.getTalentMultiplier() * 2) + (lvl.getXp() * 2));
    }
    
    /**
     * Description: This method awards xp to the winning StartUp.

     * @author James Covert
     * @version 1.0
     * @param winningSU - the winning SU
     * @param losingSU - the losing SU
     */
    private void awardWinnerXP(StartUp su1, StartUp su2) {
        
        Level lvl = su2.getLevel();
        su1.setXp(su1.getXp() + (su1.getTalentMultiplier() * 3) + (lvl.getXp() * su1.getLevelNumber()));
    }
    
    /**
     * Description: This method levels up the startup if they are ready.

     * @author James Covert
     * @version 1.0
     * @param su - the winning SU
     */
    public void awardLevelUp(StartUp su) {
        
        if (su.compareXpToNextLevelXp()){

            su.getLevels().levelUp();
            
            if (su.compareXpToNextLevelXp()) {
                
                awardLevelUp(su);
            } 
        }
    }
    
    /**
     * Description: This method prints the results of the competition.
     * 
     * @author James Covert
     * @version 1.0
     */
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
    
    /**
     * Description: This method prints challenge start message.
     * 
     * @author James Covert
     * @version 1.0
     */
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

    // getters and setters
    
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
}
