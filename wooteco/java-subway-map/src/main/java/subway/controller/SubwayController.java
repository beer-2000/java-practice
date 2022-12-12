package subway.controller;

import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.StationCommand;
import subway.domain.Lines;
import subway.domain.Station;
import subway.domain.Stations;
import subway.ui.InputView;
import subway.ui.OutputView;

public class SubwayController {
    private InputView inputView;
    private OutputView outputView;
    private Stations stations;
    private Lines lines;

    public SubwayController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.stations = new Stations();
        initLines();
    }

    public void start() {
        FunctionCommand functionCommand;
        do {
            outputView.announceMainFunction();
            functionCommand = inputView.readFunctionCommand();
            runFunction(functionCommand);
        } while (!functionCommand.equals(FunctionCommand.QUIT));

    }

    private void runFunction(FunctionCommand functionCommand) {
        if (functionCommand.equals(FunctionCommand.STATION_MANAGEMENT)) {
            manageStation();
        }
        if (functionCommand.equals(FunctionCommand.LINE_MANAGEMENT)) {
            manageLine();
        }
        if (functionCommand.equals(FunctionCommand.SECTION_MANAGEMENT)) {
            manageSection();
        }
    }

    private void manageStation() {
        outputView.announceStationFunction();
        StationCommand stationCommand = inputView.readStationFunction();
        if (stationCommand.equals(StationCommand.REGISTER)) {
            registerStation();
        }
        if (stationCommand.equals(StationCommand.DELETE)) {
            deleteStation();
        }
        if (stationCommand.equals(StationCommand.FIND)) {
            findStation();
        }
    }

    private void registerStation() {
        while (true) {
            try {
                stations.register(inputView.readStationNameToRegister());
                outputView.announceRegisterStation();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void deleteStation() {
        while (true) {
            try {
                stations.delete(inputView.readStationNameToDelete());
                outputView.announceDeleteStation();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void findStation() {
        outputView.printStations(stations.getStationNames());
    }

    private void manageLine() {
        outputView.announceLineFunction();
        LineCommand lineCommand = inputView.readLineFunction();
        if (lineCommand.equals(LineCommand.REGISTER)) {
            registerLine();
        }
        if (lineCommand.equals(LineCommand.DELETE)) {
            deleteLine();
        }
        if (lineCommand.equals(LineCommand.FIND)) {
            findLine();
        }
    }

    private void registerLine() {

    }

    private void deleteLine() {

    }

    private void findLine() {

    }

    private void registerLineByValues(String name, String startStationName, String endStationName) {
        Station startStation = stations.getStationByName(startStationName);
        Station endStation = stations.getStationByName(endStationName);
        lines.addLine(name, startStation, endStation);
    }

    private void manageSection() {

    }

    private void initLines() {
        this.lines = new Lines();
        lines.addLine("2호선",
                stations.getStationByName("교대역"),
                stations.getStationByName("역삼역")
        );
        lines.addLine("3호선",
                stations.getStationByName("교대역"),
                stations.getStationByName("매봉역")
        );
        lines.addLine("신분당선",
                stations.getStationByName("강남역"),
                stations.getStationByName("양재시민의숲역")
        );
    }
}
