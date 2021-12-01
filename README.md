"# Silvalsim" 

main class is located at src/main/java/start/Silvalsim.java

For SivValSim, I used the following Design patterns:

- Factory Pattern: I use the factory pattern to generate the different StartUps.
StartUpFactory.generateStartUp(String startUpType) generates the corresponding StartUp type. To a lesser degree, the TechGiantFactory does the same, though, it does not have the have differing types

- Command Pattern: I used the command pattern to to generate the all of the actions that a StartUp can utilize in competition. Command interface defines the execute() method. DodgeCommand, AdevertiseCommand, RecruitTalentCommand, LiquidateCommand, DrainTalentCommand, BribePoliticianCommand, StealTradeSecretCommand, UndercutPricesCommand all implement the the Command interface. Offense remotely calls the attack commands and Defense  calls the defend commands.

- Iterator Pattern: OfficeLevelRepository utilizes the iterator pattern. Levels utilizes OfficeLevelRepository to retrieve different Levels.
