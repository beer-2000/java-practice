package subway.controller;

import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.SectionCommand;
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
            functionCommand = getFunctionCommandAfterRun();
        } while (!functionCommand.equals(FunctionCommand.QUIT));

    }

    private FunctionCommand getFunctionCommandAfterRun() {
        FunctionCommand functionCommand;
        while (true) {
            try {
                outputView.announceMainFunction();
                functionCommand = inputView.readFunctionCommand();
                runFunction(functionCommand);
                return functionCommand;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
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
        while (true) {
            try {
                manegeStationContainError();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void manegeStationContainError() {
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
        stations.register(inputView.readStationNameToRegister());
        outputView.announceRegisterStation();
    }

    private void deleteStation() {
        stations.delete(inputView.readStationNameToDelete());
        outputView.announceDeleteStation();
    }

    private void findStation() {
        outputView.printStations(stations.getStationNames());
    }

    private void manageLine() {
        while (true) {
            try {
                manageLineContainError();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void manageLineContainError() {
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
        String lineName = inputView.readLineNameToRegister();
        Station startStation = stations.getStationByName(inputView.readStartStationName());
        Station endStation = stations.getStationByName(inputView.readEndStationName());
        lines.addLine(lineName, startStation, endStation);
        outputView.announceRegisterLine();
    }

    private void deleteLine() {
        String lineName = inputView.readLineNameToDelete();
        lines.delete(lineName);
        outputView.announceDeleteLine();
    }

    private void findLine() {
        outputView.printLines(lines.getLineNames());
    }

    private void manageSection() {
        while (true) {
            try {
                manageSectionContainError();
                break;
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void manageSectionContainError() {
        outputView.announceSectionFunction();
        SectionCommand sectionCommand = inputView.readSectionFunction();
        if (sectionCommand.equals(SectionCommand.REGISTER)) {
            registerSection();
        }
        if (sectionCommand.equals(SectionCommand.DELETE)) {
            deleteSection();
        }
    }

    private void registerSection() {

    }

    private void deleteSection() {
        
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
