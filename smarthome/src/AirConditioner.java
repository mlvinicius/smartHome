public class AirConditioner implements Appliance{

    private Thermostat temperatureSetting;

    //Set AC mode on "System" on connection
    public AirConditioner(Thermostat temperatureSetting){
        this.temperatureSetting = temperatureSetting;
    }

    public void setTemperatureSetting(Thermostat temperatureSetting) {
        this.temperatureSetting = temperatureSetting;
    }

    @Override
    public String getPowerStatus() {
        return this.temperatureSetting.getDescription();
    }
}
