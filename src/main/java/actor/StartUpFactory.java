package main.java.actor;

import java.util.ArrayList;

import main.java.world.California;
import main.java.world.Location;
import main.java.world.RandomNumber;
import main.java.world.World;

/**
 * StartUpFactory.java
 * Package: main.java.actor
 * Description: The StartUp factory class is used to generate any requested type of StartUp.
 * 
 * @author James Covert
 * @version 1.0
 */
public class StartUpFactory {
    
    private ArrayList<String> names;                // list of potential names
    private ArrayList<String> generalExtenders;     // list of potential name modifiers
    private ArrayList<String> phoneExtenders;       // list of potential phone name modifiers
    private ArrayList<String> gameExtenders;        // list of potential game name modifiers
    private ArrayList<String> osExtenders;          // list of potential OS name modifiers
    private ArrayList<String> socialMediaExtenders; // list of potential SM name modifiers
    private ArrayList<String> financialExtenders;   // list of potential FE name modifiers
    
    /**
     * Description: The StartUp factory constructor populates all lists pertaining to.
     * generating random, unique names for new start ups. 
     * 
     * @author James Covert
     * @version 1.0
     */
    public StartUpFactory() {
        
        populateNames();
        populateGeneralExtenders();
        populateSpecificExtenders();
    }

    /**
     * Description: This method generates a new StartUp of a given type.
     * It instantiates required variables to generate a new StartUp.
     * It then determines the type of StartUp to be created.
     * It then formulates a random, unique name for the StartUp.
     * It then gives it a basic description.
     * It then builds the startup and adds it to the TechGiant who owns it.
     * 
     * @author James Covert
     * @version 1.0
     * @param startUpType - the type of startup to be built
     */
    public void generateStartUp(String startUpType) {
        
        String name = "";
        String description = "";
        int techGiantIndex = RandomNumber
                .getRandomBetween(0, World.world.getTechGiants().size() - 1);
        TechGiant tg = World.world.getTechGiants().get(techGiantIndex);
        Location location = new California();
        
        if (startUpType.equals("PhoneTech")) {
            
            name = formulateName("PhoneTech");
            description = "Awesome Phones.";
            tg.getStartups().add(new PhoneTechStartUp(name, description, location, tg));
        }
        
        if (startUpType.equals("OperatingSystems")) {
            
            name = formulateName("OperatingSystems");
            description = "Great operating systems.";
            tg.getStartups().add(new OperatingSystemsStartUp(name, description, location, tg));
        }
        
        if (startUpType.equals("GameTech")) {
            
            name = formulateName("GameTech");
            description = "Super good games.";
            tg.getStartups().add(new GameTechStartUp(name, description, location, tg));
            
        }
        
        if (startUpType.equals("SocialMedia")) {
            
            name = formulateName("SocialMedia");
            description = "Great social media.";
            tg.getStartups().add(new SocialMediaStartUp(name, description, location, tg));
        }
        
        if (startUpType.equals("FinancialTech")) {
            
            name = formulateName("FinancialTech");
            description = "Great financial technology.";
            tg.getStartups().add(new FinancialTechStartUp(name, description, location, tg));
        }
    }
    
    /**
     * Description: This method generates a random, unique name for a given. StartUp type
     * 
     * @author James Covert
     * @version 1.0
     * @param startUpType - the type of startup to be built
     * @return String - name of the startup
     */
    private String formulateName(String startUpType) {

        String specificExtender = "";
        
        if (startUpType.equals("PhoneTech")) {
            
            specificExtender = getPhoneExtender(RandomNumber
                    .getRandomBetween(0, phoneExtenders.size() - 1));
        }
        
        if (startUpType.equals("OperatingSystems")) {
            
            specificExtender = getOsExtender(RandomNumber
                    .getRandomBetween(0, osExtenders.size() - 1));
        }
        
        if (startUpType.equals("GameTech")) {
            
            specificExtender = getGameExtender(RandomNumber
                    .getRandomBetween(0, gameExtenders.size() - 1));
        }
        
        if (startUpType.equals("SocialMedia")) {
            
            specificExtender = getSocialMediaExtender(RandomNumber
                    .getRandomBetween(0, socialMediaExtenders.size() - 1));
        }
        
        if (startUpType.equals("FinancialTech")) {
            
            specificExtender = getFinancialExtender(RandomNumber
                    .getRandomBetween(0, financialExtenders.size() - 1));
        }
        
        String name = getName(RandomNumber.getRandomBetween(0, names.size() - 1));
        String genExtender = getGeneralExtender(RandomNumber
                .getRandomBetween(0, generalExtenders.size() - 1));
        return name + genExtender + specificExtender;
        
    }
    
    /**
     * Description: This method populates the possible names a startup could use.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateNames() {

        names = new ArrayList<String>();
        
        names.add("X-");
        names.add("Dun");
        names.add("Jam");
        names.add("Pan");
        names.add("Coda");
        names.add("Mite");
        names.add("Sabe");
        names.add("MSPC");
        names.add("Rec");
        names.add("Con");
        names.add("Laz");
        names.add("Tet");
        names.add("Ner");
        names.add("La");
        names.add("Ko");
        names.add("Ra");
        names.add("Me");
        names.add("Sint");
        names.add("Quo");
        names.add("Fi");
        names.add("Ga");
        names.add("Gram");
        names.add("Ve");
        names.add("Vi");
        names.add("Ze");
        names.add("Ce");
        names.add("Ci");
        names.add("Q-");
        names.add("Ba");
        names.add("Bot");
        names.add("Bi");
        names.add("Es");
        names.add("Trans");
        names.add("Quan");

    }
    
    /**
     * Description: This method populates the possible name modifiers a startup could use.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateGeneralExtenders() {

        generalExtenders = new ArrayList<String>();
        
        generalExtenders.add("tronics ");
        generalExtenders.add("tech ");
        generalExtenders.add("techno ");
        generalExtenders.add("zio ");
        generalExtenders.add("bionic ");
        generalExtenders.add("augment ");
        generalExtenders.add("state ");
        generalExtenders.add("tron ");
        generalExtenders.add("-lite ");
        generalExtenders.add("micro ");
        generalExtenders.add("quantum ");
        generalExtenders.add("rem ");
        generalExtenders.add("lorn ");
        generalExtenders.add("tess ");
        generalExtenders.add("circuit ");
        generalExtenders.add("solo-");
        generalExtenders.add("fiat ");
        generalExtenders.add("synth ");
  
    }
    
    /**
     * Description: This method calls all of the methods used to populate the 
     * startup type specific name modifiers.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateSpecificExtenders() {

        populatePhoneExtenders();
        populateGameExtenders();
        populateOsExtenders();
        populateSmExtenders();
        populateFinancialExtenders(); 
    }
    
    /**
     * Description: This method populates the possible name modifiers for startup type 'phone'.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populatePhoneExtenders() {
        
        phoneExtenders = new ArrayList<String>();
        
        phoneExtenders.add("Phones");
        phoneExtenders.add("Telecommunications");
        phoneExtenders.add("Communications");
        phoneExtenders.add("CMS");
        
    }
    
    /**
     * Description: This method populates the possible name modifiers for startup type 'game'.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateGameExtenders() {
        
        gameExtenders = new ArrayList<String>();
        
        gameExtenders.add("Games");
        gameExtenders.add("Apps");
        gameExtenders.add("Entertainment");
        gameExtenders.add("Ent");
          
    }
    
    /**
     * Description: This method populates the possible name modifiers.
     * for startup type 'Operating Systems'.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateOsExtenders() {
        
        osExtenders = new ArrayList<String>();
        
        osExtenders.add("O.Systems");
        osExtenders.add("Systems");
        osExtenders.add("OS");
        osExtenders.add("O.S.");

    }
    
    /**
     * Description: This method populates the possible name modifiers.
     * for startup type 'Social Media'.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateSmExtenders() {
        
        socialMediaExtenders = new ArrayList<String>();
        
        socialMediaExtenders.add("Media");
        socialMediaExtenders.add("Apps");
        socialMediaExtenders.add("Platforms");    
    }
    
    /**
     * Description: This method populates the possible.
     * name modifiers for startup type 'Financial Tech'.
     * 
     * @author James Covert
     * @version 1.0
     */
    private void populateFinancialExtenders() {
        
        financialExtenders = new ArrayList<String>();
        
        financialExtenders.add("Finances");
        financialExtenders.add("Exchange");
        financialExtenders.add("Capital");
    }
    
    // getters and setters
    
    private String getName(int selectIndex) {
        
        return names.remove(selectIndex);
    }
    
    private String getGeneralExtender(int selectIndex) {
        
        return generalExtenders.remove(selectIndex);
    }
    
    private String getPhoneExtender(int selectIndex) {
        
        return phoneExtenders.get(selectIndex);
    }
    
    private String getGameExtender(int selectIndex) {
        
        return gameExtenders.get(selectIndex);
    }
    
    private String getSocialMediaExtender(int selectIndex) {
        
        return socialMediaExtenders.get(selectIndex);
    }
    
    private String getFinancialExtender(int selectIndex) {
        
        return financialExtenders.get(selectIndex);
    }
    
    private String getOsExtender(int selectIndex) {
        
        return osExtenders.get(selectIndex);
    }
}