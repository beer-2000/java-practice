package ui;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class InputView {
    public List<String> readPlayerNames() {
        Scanner scanner = new Scanner(System.in);
        String playerNamesRaw = scanner.nextLine();
        return Arrays.stream(playerNamesRaw.split(","))
                .collect(Collectors.toList());
    }

    public double readBettingMoney() {
        Scanner scanner = new Scanner(System.in);
        double bettingMoney = scanner.nextDouble();
        return bettingMoney;
    }

    public String readGetCardCommand() {
        Scanner scanner = new Scanner(System.in);
        String getCardCommand = scanner.nextLine();
        return getCardCommand;
    }
}
