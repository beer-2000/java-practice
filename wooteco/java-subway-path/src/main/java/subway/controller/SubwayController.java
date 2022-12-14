package subway.controller;

import java.util.Scanner;
import subway.constant.MainCommand;
import subway.constant.PathCommand;
import subway.domain.Subway;
import subway.ui.InputView;
import subway.ui.OutputView;

public class SubwayController {
    private Scanner scanner;
    private InputView inputView;
    private OutputView outputView;
    private Subway subway;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
        this.subway = new Subway();
    }

    public void start() {
        MainCommand mainCommand = null;
        do {
            try {
                outputView.announceMainCommand();
                mainCommand = inputView.readMainCommand();
                runMainFunction(mainCommand);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (mainCommand.equals(MainCommand.QUIT));
    }

    private void runMainFunction(MainCommand mainCommand) {
        if (mainCommand.equals(MainCommand.PATH_FIND)) {
            startPathFunction();
        }
    }

    private void startPathFunction() {
        PathCommand pathCommand = inputView.readPathCommand();
        if (pathCommand.equals(PathCommand.MINIMUM_DISTANCE)) {

        }
        if (pathCommand.equals(PathCommand.MINIMUM_DISTANCE)) {

        }
        if (pathCommand.equals(PathCommand.MINIMUM_DISTANCE)) {

        }
    }
}
