package subway.controller;

import subway.constant.FunctionCommand;
import subway.constant.LineCommand;
import subway.constant.SectionCommand;
import subway.constant.StationCommand;
import subway.domain.Line;
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
        init();
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
        if (functionCommand.equals(FunctionCommand.SUBWAY_MAP)) {
            printSubwayMap();
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
        Line line = lines.getLineByName(inputView.readLineNameOfSection());
        Station station = stations.getStationByName(inputView.readStationNameOfSection());
        int order = inputView.readOrder();
        line.addSection(order, station);
        outputView.announceRegisterSection();
    }

    private void deleteSection() {
        Line line = lines.getLineByName(inputView.readLineNameOfSectionToDelete());
        Station station = stations.getStationByName(inputView.readStationNameOfSectionToDelete());
        line.deleteSection(station);
        outputView.announceDeleteSection();
    }

    private void init() {
        this.lines = new Lines();
        initLines();
        initSections();
    }

    private void initSections() {
        Line lineNumber2 = lines.getLineByName("2호선");
        Line lineNumber3 = lines.getLineByName("3호선");
        Line lineNumberBundang = lines.getLineByName("신분당선");
        lineNumber2.addSection(2, stations.getStationByName("강남역"));
        lineNumber3.addSection(2, stations.getStationByName("남부터미널역"));
        lineNumber3.addSection(3, stations.getStationByName("양재역"));
        lineNumberBundang.addSection(2, stations.getStationByName("양재역"));
    }

    private void printSubwayMap() {
        outputView.printSubwayMap(lines.getSubwayMap());
    }

    private void initLines() {
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
