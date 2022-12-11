package view;

import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_TABLE_NUMBER = System.lineSeparator() + "## 테이블을 선택하세요.";
    private static final String REQUEST_FUNCTION = System.lineSeparator() + "## 원하는 기능을 선택하세요.";
    private static final String REQUEST_MENU_NUMBER = System.lineSeparator() + "## 등록할 메뉴를 선택하세요.";
    private static final String REQUEST_MENU_COUNT = System.lineSeparator() + "## 메뉴의 수량을 입력하세요.";
    private static final String REQUEST_PAY_TYPE =
            System.lineSeparator() + "## %d번 테이블의 결제를 진행합니다."
                    + System.lineSeparator() + "## 신용 카드는 1번, 현금은 2번";

    public static int inputTableNumber() {
        System.out.println(REQUEST_TABLE_NUMBER);
        return scanner.nextInt();
    }

    public static String readFunctionCommand() {
        System.out.println(REQUEST_FUNCTION);
        return scanner.next();
    }

    public static int inputMenuNumber() {
        System.out.println(REQUEST_MENU_NUMBER);
        return scanner.nextInt();
    }

    public static int inputMenuCount() {
        System.out.println(REQUEST_MENU_COUNT);
        return scanner.nextInt();
    }

    public static int inputPayType(int tableNumber) {
        System.out.printf(REQUEST_PAY_TYPE, tableNumber);
        System.out.println();
        return scanner.nextInt();
    }
}
