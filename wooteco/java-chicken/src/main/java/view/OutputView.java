package view;

import domain.Menu;
import domain.Table;
import java.util.List;
import java.util.Map;

public class OutputView {
    private static final String ANNOUNCEMENT_TABLE_LIST = System.lineSeparator() + "## 테이블 목록";
    private static final String TOP_LINE = "┌ ─ ┐";
    private static final String TABLE_FORMAT = "| %s |";
    private static final String BOTTOM_LINE = "└ ─ ┘";
    private static final String ANNOUNCEMENT_FUNCTIONS = "## 메인화면" + System.lineSeparator()
            + "1 - 주문등록" + System.lineSeparator()
            + "2 - 결제하기" + System.lineSeparator()
            + "3 - 프로그램 종료";
    private static final String ANNOUNCEMENT_ORDER_SHEET = "## 주문 내역" + System.lineSeparator() + "메뉴 수량 금액";

    public static void printTables(final List<Table> tables) {
        System.out.println(ANNOUNCEMENT_TABLE_LIST);
        final int size = tables.size();
        printLine(TOP_LINE, size);
        printTableNumbers(tables);
        printLine(BOTTOM_LINE, size);
    }

    public static void printMenus(final List<Menu> menus) {
        System.out.println();
        for (final Menu menu : menus) {
            System.out.println(menu);
        }
    }

    private static void printLine(final String line, final int count) {
        for (int index = 0; index < count; index++) {
            System.out.print(line);
        }
        System.out.println();
    }

    private static void printTableNumbers(final List<Table> tables) {
        for (final Table table : tables) {
            System.out.printf(TABLE_FORMAT, table);
        }
        System.out.println();
    }

    public static void printFunctions() {
        System.out.println(ANNOUNCEMENT_FUNCTIONS);
    }

    public static void printEmptyLine() {
        System.out.println();
    }

    public static void printOrderSheet(Map<Menu, Integer> sheet) {
        System.out.println();
        System.out.println(ANNOUNCEMENT_ORDER_SHEET);
        sheet.keySet().stream()
                .forEach(menu -> {
                    int count = sheet.get(menu);
                    if (count != 0) {
                        System.out.println(String.join(" ", menu.getName(), Integer.toString(count),
                                Integer.toString(count * menu.getPrice())));
                    }
                });
    }
}
