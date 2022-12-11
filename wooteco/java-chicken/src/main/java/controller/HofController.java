package controller;

import static constant.HofRule.COMMAND_EXIT;
import static constant.HofRule.COMMAND_ORDER;
import static constant.HofRule.COMMAND_PAY;

import domain.Menu;
import domain.Table;
import java.util.List;
import repository.MenuRepository;
import repository.TableRepository;
import view.InputView;
import view.OutputView;

public class HofController {
    public void start() {
        String function;
        do {
            OutputView.printFunctions();
            function = InputView.readFunctionCommand();
            if (function.equals(COMMAND_ORDER)) {
                order();
            }
            if (function.equals(COMMAND_PAY)) {
                pay();
            }
        } while (!function.equals(COMMAND_EXIT));
    }

    private void order() {
        printTables();
        Table table = TableRepository.getTableByNumber(InputView.inputTableNumber());
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        Menu menu = MenuRepository.getMenuByNumber(InputView.inputMenuNumber());
        int menuCount = InputView.inputMenuCount();
        TableRepository.addOrder(table, menu, menuCount);
        OutputView.printEmptyLine();
    }

    private void printTables() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }

    private void pay() {
        printTables();
        int tableNumber = InputView.inputTableNumber();
        Table table = TableRepository.getTableByNumber(tableNumber);
        OutputView.printOrderSheet(table.getOrderSheet());
        int payType = InputView.inputPayType(tableNumber);
        int totalPrice = table.calculateTotalPrice(payType);
        OutputView.printTotalPrice(totalPrice);
    }
}
