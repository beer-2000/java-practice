package controller;

import domain.Menu;
import domain.Table;
import java.util.List;
import repository.MenuRepository;
import repository.TableRepository;
import view.InputView;
import view.OutputView;

public class HofController {
    public void start() {
        final List<Table> tables = TableRepository.tables();
        OutputView.printTables(tables);

        final int tableNumber = InputView.inputTableNumber();

        final List<Menu> menus = MenuRepository.menus();
        OutputView.printMenus(menus);
    }
}
