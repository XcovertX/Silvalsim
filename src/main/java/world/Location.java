package main.java.world;

public abstract class Location {
    
    private String stateName;
    private String stateAbbreviation;
    private double taxRate;
    
    public String getStateName() {
        return stateName;
    }
    public void setStateName(String stateName) {
        this.stateName = stateName;
    }
    public String getStateAbbreviation() {
        return stateAbbreviation;
    }
    public void setStateAbbreviation(String stateAbbreviation) {
        this.stateAbbreviation = stateAbbreviation;
    }
    public double getTaxRate() {
        return taxRate;
    }
    public void setTaxRate(double taxRate) {
        this.taxRate = taxRate;
    }

}
