package main.java.actor;

import java.util.ArrayList;

import main.java.world.RandomNumber;
import main.java.world.World;

/**
 * TechGiantFactory.java
 * Package: main.java.actor
 * Description: The TechGiant factory class is used to generate a TechGiant
 * and generate a unique name for it.
 * 
 * @author James Covert
 * @version 1.0
 *-----------------------------------------------------
 */

public class TechGiantFactory {
    
    private ArrayList<String> names;                    // list of potential names
    private ArrayList<String> descriptions;             // list of potential descriptions

    /**
     * Description: The StartUp factory constructor populates all lists pertaining to
     * generating unique names and descriptions. 
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    public TechGiantFactory() {
        
        populateNames();
        populateDescriptions();
    }
    
    /**
     * Description: Thish method generates a new TechGiant and adds it to the world's
     * list of all TechGiants 
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    public void generateTechGiant() {
        String name = getName();
        String description = getDescription();
        World.world.getTechGiants().add(new TechGiant(name, description));
    }
    
    /**
     * Description: This method generates a random name for a new TechGiant
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void populateNames() {

        names = new ArrayList<String>();
        
        names.add("Microsoft");
        names.add("Amazon");
        names.add("Sony");
        names.add("Boston Dynamics");
        names.add("Meta");
        names.add("Raytheon");
        names.add("Cisco");
        names.add("Panasonic");
        names.add("Xerox");
        names.add("Starbucks");
        names.add("Lockheed");

    }
    
    /**
     * Description: This method generates a random description for a new TechGiant
     * 
     * @author James Covert
     * @version 1.0
     * @return void
     *-----------------------------------------------------
     */
    private void populateDescriptions() {

        descriptions = new ArrayList<String>();
        
        descriptions.add("Taking over the world, one startup at a time.");
        descriptions.add("People, Persons, Paper, People");
        descriptions.add("Empire building.");
        descriptions.add("Total Tech Takeover!!");
        descriptions.add("The Business of total domination.");
        descriptions.add("Tech, and more tech.");
        descriptions.add("So much tech offered here.");
        descriptions.add("One World Government is our game.");
        descriptions.add("Lots of tech startups.");
        descriptions.add("Tech overlords.");
        descriptions.add("Techno.");

    }
    
    // getters
    
    public String getName() {
        
        int randomNumber = RandomNumber.getRandomBetween(0, names.size() - 1);
        String name = names.remove(randomNumber);
        return name;
    }
    
    public String getDescription() {
        
        int randomNumber = RandomNumber.getRandomBetween(0, descriptions.size() - 1);
        String name = descriptions.remove(randomNumber);
        return name;
    }
}
