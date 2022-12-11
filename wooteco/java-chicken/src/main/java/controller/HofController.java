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
    private final String ERROR_MESSAGE_WRONG_FUNCTION_COMMAND = "[ERROR] 원하는 기능의 번호를 입력해주세요";

    public void start() {
        String function;
        do {
            function = getFunction();
            if (function.equals(COMMAND_ORDER)) {
                order();
            }
            if (function.equals(COMMAND_PAY)) {
                pay();
            }
        } while (!function.equals(COMMAND_EXIT));
    }

    private String getFunction() {
        String function;
        while (true) {
            try {
                OutputView.printFunctions();
                function = InputView.readFunctionCommand();
                validateFunction(function);
                return function;
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void validateFunction(String function) {
        if (function.equals(COMMAND_ORDER) || function.equals(COMMAND_PAY) || function.equals(COMMAND_EXIT)) {
            return;
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_WRONG_FUNCTION_COMMAND);
    }

    private void order() {
        while (true) {
            try {
                printTables();
                Table table = TableRepository.getTableByNumber(InputView.inputTableNumber());
                final List<Menu> menus = MenuRepository.menus();
                OutputView.printMenus(menus);
                Menu menu = MenuRepository.getMenuByNumber(InputView.inputMenuNumber());
                int menuCount = InputView.inputMenuCount();
                TableRepository.addOrder(table, menu, menuCount);
                OutputView.printEmptyLine();
            } catch (IllegalArgumentException e) {
                OutputView.printErrorMessage(e.getMessage());
            }
        }
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
        table.resetOrder();
    }
}
