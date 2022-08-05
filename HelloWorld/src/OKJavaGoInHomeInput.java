import Programming.org.opentutorials.iot.DimmingLights;
import Programming.org.opentutorials.iot.Elevator;
import Programming.org.opentutorials.iot.Lighting;
import Programming.org.opentutorials.iot.Security;

import javax.swing.JOptionPane;

public class OKJavaGoInHomeInput{

    public static void main(String[] args) {

//        String id = JOptionPane.showInputDialog("Enter a ID");
//        Double bright = Double.parseDouble(
//                JOptionPane.showInputDialog("Enter a bright level")
//        );

        // Use arguments
        String id = args[0];
        Double bright = Double.parseDouble(args[1]);

        // Elevator call
        Elevator myElevator = new Elevator(id);
        myElevator.callForUp(1);

        // Security off
        Security mySecurity = new Security(id);
        mySecurity.off();

        // Light on
        Lighting hallLamp = new Lighting(id + " / Hall Lamp");
        hallLamp.on();

        Lighting floorLamp = new Lighting(id + " / floorLamp");
        floorLamp.on();

        DimmingLights moodLamp = new DimmingLights(id + " moodLamp");
        moodLamp.setBright(bright);
        moodLamp.on();

    }
}