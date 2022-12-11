package controller;

import static constant.HofRule.COMMAND_EXIT;
import static constant.HofRule.COMMAND_ORDER;

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
            OutputView.requestFunction();
            function = InputView.readFunctionCommand();
            if (function.equals(COMMAND_ORDER)) {
                order();
            }
//            if (function.equals(COMMAND_PAY)) {
//                pay();
//            }
        } while (!function.equals(COMMAND_EXIT));
    }

    private void order() {
        printTables();
        int tableNumber = InputView.inputTableNumber();
        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
        int menuNumber = InputView.inputMenuNumber();
        int menuCount = InputView.inputMenuCount();
        TableRepository.addOrder(tableNumber, menuNumber, menuCount);
    }

    private void printTables() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);
    }
}
