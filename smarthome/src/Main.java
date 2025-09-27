import java.util.Scanner;

public class Main {

    Scanner scanner = new Scanner(System.in);
    SmartHomeOS os = new SmartHomeOS();
    int optionSelected;

    //Startup Appliance Control Program and provide commands for user
    void main(String[] args) {

        os.StartUp();
        os.ShowApllianceStatus();

        do {
            PromptForAppliance();
            optionSelected = scanner.nextInt();
            switch (optionSelected) {
                case 1:
                    ToggleLights();
                    break;
                case 2:
                    SetFan();
                    break;
                case 3:
                    SetAirConditioner();
                    break;
                case 4:
                    os.ShowApllianceStatus();
            }
        }
        while (optionSelected != 5);
        System.out.println("GoodBye!");

    }

    void ToggleLights() {
        System.out.println("Toggling Lights");
        os.ToggleLights();
    }

    void SetAirConditioner() {
        System.out.println("Air Conditioning: 1 - Heat | 2 - Cool | 3 - OFF");
        switch (scanner.nextInt()) {
            case 1:
                os.Heat();
                break;
            case 2:
                os.Cool();
                break;
            default:
                os.DeactivateAC();
        }
    }

    void SetFan() {
        System.out.println("Fan Control: 1 - Speed Up | 2 - Slow Down");
        if (scanner.nextInt() == 1) {
            os.SpeedUpFan();
        } else {
            os.SlowDownFan();
        }

    }

    void PromptForAppliance() {
        System.out.println("Which appliance would you like to adjust?");
        System.out.println("1 - Light | 2 - Fan | 3 - Air Conditioner | 4 - List Appliances | 5 - Exit");
    }
}
