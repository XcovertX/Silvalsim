package main.java.marketplace;

import java.util.ArrayList;

/**
 * OfficeLevelRepository.java
 * Package: main.java.marketplace
 * Description: This is the implements the Container interface.
 * 
 * 
 * @author James Covert
 * @version 1.0
 */
public class OfficeLevelRepository implements Container {
    
    private ArrayList<Level> levels = new ArrayList<Level>();
    
    /**
     * Description: The OfficeLevelRepository constructor populates the levels list.
     * 
     * @author James Covert
     * @version 1.0
     */
    public OfficeLevelRepository() {
        
        levels.add(new GarageOffice());
        levels.add(new LocalStoreFrontOffice());
        levels.add(new HighriseBottomFloorOffice());
        levels.add(new HighriseMiddleFloorOffice());
        levels.add(new HighriseTopFloorOffice());
        levels.add(new OfficeCampus());
        levels.add(new OfficeCompound());
        levels.add(new OfficeUtopia());
    }

    /**
     * Description: This method retrieves the Iterator.
     * 
     * @author James Covert
     * @version 1.0
     * @return Iterator - used to iterate though available Levels
     */
    @Override
    public Iterator getIterator() {

        return new LevelIterator();
    }
    
    /**
     * Description: This is a private class used to.
     * iterate through the collection of Levels
     * 
     * @author James Covert
     * @version 1.0
     * @return Iterator - used to iterate though available Levels
     */
    private class LevelIterator implements Iterator {

        int index;
        
        @Override
        public boolean hasNext() {

            if (index < levels.size()) {
                
                return true;
            }
            return false;
        }

        @Override
        public Object next() {

            if (this.hasNext()) {
                
                return levels.get(index++);
            }
            return null;
        }
        
    }

}
