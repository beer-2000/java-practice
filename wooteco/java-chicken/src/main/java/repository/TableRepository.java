package repository;

import domain.Menu;
import domain.Table;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class TableRepository {
    private static final List<Table> tables = new ArrayList<>();
    private static final String ERROR_MESSAGE_WRONG_TABLE_NUMBER = "[ERROR] 존재하지 않는 테이블 번호입니다.";

    static {
        tables.add(new Table(1));
        tables.add(new Table(2));
        tables.add(new Table(3));
        tables.add(new Table(5));
        tables.add(new Table(6));
        tables.add(new Table(8));
    }

    public static List<Table> tables() {
        return Collections.unmodifiableList(tables);
    }

    public static void addOrder(Table table, Menu menu, int menuCount) {
        table.addOrder(menu, menuCount);
    }

    public static Table getTableByNumber(int tableNumber) {
        return tables.stream()
                .filter(table -> table.isNumberOf(tableNumber))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_WRONG_TABLE_NUMBER));
    }
}
