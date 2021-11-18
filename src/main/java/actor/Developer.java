package main.java.actor;

public class Developer extends Actor {
    
    public final static int JUNIOR_DEV_TALENT = 1;
    public final static int EXPERIENCED_DEV_TALENT = 5;
    public final static int SENIOR_DEV_TALENT = 10;
    
    private int talent;
    
    public Developer(int talent) {

    }

    public int getTalent() {
        return talent;
    }

    public void setTalent(int talent) {
        this.talent = talent;
    }
}
