package view;

<<<<<<< HEAD
import java.util.Scanner;

public class InputView {
    private static final Scanner scanner = new Scanner(System.in);

    public static int inputTableNumber() {
        System.out.println("## 주문할 테이블을 선택하세요.");
        return scanner.nextInt();
=======
import java.util.InputMismatchException;
import java.util.Scanner;

public class InputView {
    private static Scanner scanner = new Scanner(System.in);
    private static final String REQUEST_TABLE_NUMBER = System.lineSeparator() + "## 테이블을 선택하세요.";
    private static final String REQUEST_FUNCTION = System.lineSeparator() + "## 원하는 기능을 선택하세요.";
    private static final String REQUEST_MENU_NUMBER = System.lineSeparator() + "## 등록할 메뉴를 선택하세요.";
    private static final String REQUEST_MENU_COUNT = System.lineSeparator() + "## 메뉴의 수량을 입력하세요.";
    private static final String REQUEST_PAY_TYPE =
            System.lineSeparator() + "## %d번 테이블의 결제를 진행합니다."
                    + System.lineSeparator() + "## 신용 카드는 1번, 현금은 2번";
    private static final String ERROR_MESSAGE_WRONG_COUNT = "[ERROR] 잘못된 수량입니다.";
    private static final String ERROR_MESSAGE_WRONG_TABLE_NUMBER = "[ERROR] 잘못된 테이블 번호입니다.";
    private static final String ERROR_MESSAGE_WRONG_MENU_NUMBER = "[ERROR] 잘못된 메뉴 번호입니다.";
    private static final String ERROR_MESSAGE_WRONG_PAY_TYPE = "[ERROR] 잘못된 계산 방식 번호입니다.";

    public static int inputTableNumber() {
        try {
            System.out.println(REQUEST_TABLE_NUMBER);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner = new Scanner(System.in);
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_TABLE_NUMBER);
        }
    }

    public static String readFunctionCommand() {
        System.out.println(REQUEST_FUNCTION);
        return scanner.next();
    }

    public static int inputMenuNumber() {
        try {
            System.out.println(REQUEST_MENU_NUMBER);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            scanner = new Scanner(System.in);
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_MENU_NUMBER);
        }
    }

    public static int inputMenuCount() {
        try {
            System.out.println(REQUEST_MENU_COUNT);
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_COUNT);
        }
    }

    public static int inputPayType(int tableNumber) {
        try {
            System.out.printf(REQUEST_PAY_TYPE, tableNumber);
            System.out.println();
            return scanner.nextInt();
        } catch (InputMismatchException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_PAY_TYPE);
        }
>>>>>>> horsehair
    }
}
