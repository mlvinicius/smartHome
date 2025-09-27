//Standard AC functions with flavour text.
public enum Thermostat {
    COOL("Cooling House"),
    OFF("Powered Off"),
    HEAT("Heating House");
    private String description;

    Thermostat(String description) {
        this.description = description;
    }

    public String getDescription(){
        return description;
    }
}
