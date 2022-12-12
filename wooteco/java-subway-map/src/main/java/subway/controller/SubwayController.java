package subway.controller;

import subway.domain.Lines;
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
        this.lines = new Lines();
    }

    public void start() {
        
    }
}
