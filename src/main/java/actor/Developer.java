package main.java.actor;

public class Developer extends Actor {
    
    private int talent;
    
    public Developer(String name, String description, int talent) {
        
        this.setName(name);
        this.setDescription(description);
        this.setTalent(talent);
    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }

}
