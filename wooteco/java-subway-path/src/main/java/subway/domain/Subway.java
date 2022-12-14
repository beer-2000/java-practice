package subway.domain;

public class Subway {
    private StationRepository stationRepository;
    private LineRepository lineRepository;
    private PathGraphRepository pathGraphRepository;

    public Subway() {
        this.stationRepository = new StationRepository();
        this.lineRepository = new LineRepository();
        this.pathGraphRepository = new PathGraphRepository();
    }
}
