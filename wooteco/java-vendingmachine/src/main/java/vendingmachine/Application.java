package vendingmachine;

import vendingmachine.controller.VendingController;

public class Application {
    public static void main(String[] args) {
        VendingController vendingController = new VendingController();
        vendingController.start();
    }
}
