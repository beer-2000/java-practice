import Programming.org.opentutorials.iot.Elevator;
import Programming.org.opentutorials.iot.Lighting;
import Programming.org.opentutorials.iot.Security;

public class OKJavaGoInHome{

    public static void main(String[] args) {

        // Elevator call
        Elevator myElevator = new Elevator("JAVA APT 507");
        myElevator.callForUp(1);

        // Security off
        Security mySecurity = new Security("JAVA APT 507");
        mySecurity.off();

        // Light on
        Lighting hallLamp = new Lighting("JAVA APT 507 / Hall Lamp");
        hallLamp.on();

        Lighting floorLamp = new Lighting("JAVA APT 507 / floorLamp");
        floorLamp.on();

    }
}