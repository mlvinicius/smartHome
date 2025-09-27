public class AirConditioner implements Appliance{

    private Thermostat temperatureSetting;

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
