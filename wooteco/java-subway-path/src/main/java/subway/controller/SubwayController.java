package subway.controller;

import java.util.Scanner;
import subway.domain.LineRepository;
import subway.domain.PathGraphRepository;
import subway.domain.StationRepository;

public class SubwayController {
    private Scanner scanner;
    private StationRepository stationRepository;
    private LineRepository lineRepository;
    private PathGraphRepository pathGraphRepository;

    public SubwayController(Scanner scanner) {
        this.scanner = scanner;
        this.stationRepository = new StationRepository();
        this.lineRepository = new LineRepository();
        this.pathGraphRepository = new PathGraphRepository();
    }

    public void start() {
        
    }
}
