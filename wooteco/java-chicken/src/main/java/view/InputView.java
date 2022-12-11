package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_TABLE_NUMBER = "## 주문할 테이블을 선택하세요.";
    private static final String REQUEST_FUNCTION = "## 원하는 기능을 선택하세요.";

    public static int inputTableNumber() {
        System.out.println(REQUEST_TABLE_NUMBER);
        return scanner.nextInt();
    }

    public static String readFunctionCommand() {
        System.out.println(REQUEST_FUNCTION);
        return scanner.nextLine();
    }
}
