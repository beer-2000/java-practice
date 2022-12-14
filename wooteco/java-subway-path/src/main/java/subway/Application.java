package subway;

import java.util.Scanner;
import subway.controller.SubwayController;

public class Application {
    public static void main(String[] args) {
        final Scanner scanner = new Scanner(System.in);
        SubwayController subwayController = new SubwayController(scanner);
        subwayController.start();
    }
}
