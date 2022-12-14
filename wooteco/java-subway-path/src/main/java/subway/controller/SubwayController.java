package subway.controller;

import java.util.Scanner;
import subway.constant.MainCommand;
import subway.constant.PathCommand;
import subway.domain.PathResult;
import subway.domain.Subway;
import subway.ui.InputView;
import subway.ui.OutputView;

public class SubwayController {
    private InputView inputView;
    private OutputView outputView;
    private Subway subway;

    public SubwayController(Scanner scanner) {
        this.inputView = new InputView(scanner);
        this.outputView = new OutputView();
        try {
            this.subway = new Subway();
        } catch (IllegalArgumentException e) {
            outputView.printErrorMessage(e.getMessage());
        }
    }

    public void start() {
        MainCommand mainCommand = MainCommand.PATH_FIND;
        do {
            try {
                outputView.announceMainCommand();
                mainCommand = inputView.readMainCommand();
                runMainFunction(mainCommand);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!mainCommand.equals(MainCommand.QUIT));
    }

    private void runMainFunction(MainCommand mainCommand) {
        if (mainCommand.equals(MainCommand.PATH_FIND)) {
            runPathFunction();
        }
    }

    private void runPathFunction() {
        while (true) {
            try {
                outputView.announcePathCommand();
                PathCommand pathCommand = inputView.readPathCommand();
                String startStationName = inputView.readStartStation();
                String endStationName = inputView.readEndStation();
                PathResult pathResult = subway.getPathResult(pathCommand, startStationName, endStationName);
                outputView.printPathResult(pathResult);
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }
}
