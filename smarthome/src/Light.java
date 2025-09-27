public class Light implements Appliance{
    private boolean powerSwitch = false;

    public void togglePower(){
        this.powerSwitch = !powerSwitch;
        System.out.println(this.getPowerStatus());
    }

    public void powerOff(){
        powerSwitch = false;
    }

    @Override
    public String getPowerStatus() {
        return "Power " + (this.powerSwitch ? "ON" : "OFF");
    }
}
