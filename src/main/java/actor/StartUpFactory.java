package main.java.actor;

import java.util.ArrayList;

import main.java.world.California;
import main.java.world.Location;
import main.java.world.RandomNumber;
import main.java.world.World;

public class StartUpFactory {
    
    private ArrayList<String> names;
    private ArrayList<String> generalExtenders;
    private ArrayList<String> phoneExtenders;
    private ArrayList<String> gameExtenders;
    private ArrayList<String> osExtenders;
    private ArrayList<String> socialMediaExtenders;
    private ArrayList<String> financialExtenders;
    
    public StartUpFactory() {
        
        populateNames();
        populateGeneralExtenders();
        populateSpecificExtenders();
    }

    public void generateStartUp(String startUpType) {
        
        String name = "";
        String description = "";
        int techGiantIndex = RandomNumber.getRandomBetween(0, World.world.getTechGiants().size() - 1);
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
    
    private String formulateName(String startUpType) {
        
        String name = getName(RandomNumber.getRandomBetween(0, names.size() - 1));
        String genExtender = getGeneralExtender(RandomNumber.getRandomBetween(0, generalExtenders.size() - 1));
        String specificExtender = "";
        
        if (startUpType.equals("PhoneTech")) {
            
            specificExtender = getPhoneExtender(RandomNumber.getRandomBetween(0, phoneExtenders.size() - 1));
        }
        
        if (startUpType.equals("OperatingSystems")) {
            
            specificExtender = getOSExtender(RandomNumber.getRandomBetween(0, osExtenders.size() - 1));
        }
        
        if (startUpType.equals("GameTech")) {
            
            specificExtender = getGameExtender(RandomNumber.getRandomBetween(0, gameExtenders.size() - 1));
        }
        
        if (startUpType.equals("SocialMedia")) {
            
            specificExtender = getSocialMediaExtender(RandomNumber.getRandomBetween(0, socialMediaExtenders.size() - 1));
        }
        
        if (startUpType.equals("FinancialTech")) {
            
            specificExtender = getFinancialExtender(RandomNumber.getRandomBetween(0, financialExtenders.size() - 1));
        }
        
        return name + genExtender + specificExtender;
        
    }
    
    private void populateNames() {

        names = new ArrayList<String>();
        
        names.add("X-");
        names.add("Dun");
        names.add("Jamm");
        names.add("Pan");
        names.add("Coda");
        names.add("Mif");
        names.add("Sabe");
        names.add("MSPC");
        names.add("Rec");
        names.add("Cov");
        names.add("Laz ");

    }
    
    private void populateGeneralExtenders() {

        generalExtenders = new ArrayList<String>();
        
        generalExtenders.add("tronics ");
        generalExtenders.add("tech ");
        generalExtenders.add("techno ");
        generalExtenders.add("zio");
        generalExtenders.add("bionic ");
        generalExtenders.add("aug ");
        generalExtenders.add("state ");
        generalExtenders.add("tron ");
        generalExtenders.add("lite ");
        generalExtenders.add("icro ");
        generalExtenders.add("quantum ");
  
    }
    
    private void populateSpecificExtenders() {

        populatePhoneExtenders();
        populateGameExtenders();
        populateOSExtenders();
        populateSMExtenders();
        populateFinancialExtenders(); 
    }
    
    private void populatePhoneExtenders() {
        
        phoneExtenders = new ArrayList<String>();
        
        phoneExtenders.add("Phones");
        phoneExtenders.add("S-Phones");
        phoneExtenders.add("Communications");
        phoneExtenders.add("");
        
    }
    
    private void populateGameExtenders() {
        
        gameExtenders = new ArrayList<String>();
        
        gameExtenders.add("Games");
        gameExtenders.add("Apps");
        gameExtenders.add("Entertainment");
        gameExtenders.add("");
          
    }
    
    private void populateOSExtenders() {
        
        osExtenders = new ArrayList<String>();
        
        osExtenders.add("O.Systems");
        osExtenders.add("Systems");
        osExtenders.add("OS");
        osExtenders.add("");

    }
    
    private void populateSMExtenders() {
        
        socialMediaExtenders = new ArrayList<String>();
        
        socialMediaExtenders.add("Media");
        socialMediaExtenders.add("");
        socialMediaExtenders.add("Platforms");    
    }
    
    private void populateFinancialExtenders() {
        
        financialExtenders = new ArrayList<String>();
        
        financialExtenders.add("Finances");
        financialExtenders.add("Applications");
        financialExtenders.add("");
    }
    
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
    
    private String getOSExtender(int selectIndex) {
        
        return osExtenders.get(selectIndex);
    }
}