public class Fan implements Appliance{
    private int powerLevel;

    //Power Level: 0 (OFF), 1, 2
    public Fan(int powerLevel) {
        this.powerLevel = powerLevel;
    }

    //Check for range then set power level
    public void setPowerLevel(int powerLevel) {
        if (powerLevel >= 0 && powerLevel < 3){
            this.powerLevel = powerLevel;
        } else {
            //If power level is invalid, appliance should be turned off
            this.powerLevel = 0;
        }
    }

    public int getPowerLevel(){
        return this.powerLevel;
    }

    @Override
    public String getPowerStatus() {
        if (this.powerLevel == 0){
            return "Powered OFF";
        }
        return "Powered ON. Speed: " + powerLevel;
    }
}
