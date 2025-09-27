import java.time.LocalDate;

import java.time.temporal.ChronoUnit;
import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

// This class will work as the OS of the system, handling appliance operations
public class SmartHomeOS {
    private Light light;
    private Fan fan;
    private AirConditioner airConditioner;
    private static final long YEAR_IN_MILLISECONDS = 31536000000L;

    // Welcomes user, schedules update and initializes appliances.
    public void StartUp() {
        System.out.println("Initializing System...");

        int year = LocalDate.now().getYear();
        LocalDate nextUpdate = LocalDate.of(++year, 1, 1);
        long delay = ChronoUnit.MILLIS.between(LocalDate.now().atStartOfDay(), nextUpdate.atStartOfDay());

        try (ScheduledExecutorService updateScheduler = Executors.newScheduledThreadPool(1)) {
            updateScheduler.scheduleAtFixedRate(this::PrepareUpdate, delay, YEAR_IN_MILLISECONDS, TimeUnit.MILLISECONDS);
        }
        System.out.println("Initial update scheduled for: " + TimeUnit.MILLISECONDS.toDays(delay) + " days from now");

        light = new Light();
        fan = new Fan(0);
        airConditioner = new AirConditioner(Thermostat.OFF);
    }

    //Gives display-friendly list of appliances
    public void ShowApllianceStatus() {
        System.out.println("Lights: " + light.getPowerStatus());
        System.out.println("Fan: " + fan.getPowerStatus());
        System.out.println("Air Conditioning: " + airConditioner.getPowerStatus());
    }

    //Toggles lights ON/OFF
    public void ToggleLights() {
        light.togglePower();
    }

    //Speeds up fan. If max is reached, the speed is maintained in a safe level
    public void SpeedUpFan() {
        int currentPower = fan.getPowerLevel();
        if (currentPower >= 2) {
            return;
        }
        fan.setPowerLevel(++currentPower);
    }

    //Slows fan down. Limited by the OFF "position"
    public void SlowDownFan() {
        int currentPower = fan.getPowerLevel();
        if (currentPower < 0)
            return;
        fan.setPowerLevel(--currentPower);
    }

    //Prepares appliances for system update. (Turns OFF)
    public void PrepareUpdate() {
        this.light.powerOff();
        this.fan.setPowerLevel(0);
        this.airConditioner.setTemperatureSetting(Thermostat.OFF);
    }

    //Set AC to Heat
    public void Heat() {
        airConditioner.setTemperatureSetting(Thermostat.HEAT);
    }

    //Set AC to Cool
    public void Cool() {
        airConditioner.setTemperatureSetting(Thermostat.COOL);
    }

    //Turn OFF AC
    public void DeactivateAC() {
        airConditioner.setTemperatureSetting(Thermostat.OFF);
    }


}
