package subway.domain;

import subway.constant.PathCommand;

public class Subway {

    public Subway() {
        initStation();
        initLine();
        initPathGraph();
    }

    private void initStation() {
        StationRepository.addStation(new Station("교대역"));
        StationRepository.addStation(new Station("강남역"));
        StationRepository.addStation(new Station("역삼역"));
        StationRepository.addStation(new Station("남부터미널역"));
        StationRepository.addStation(new Station("양재역"));
        StationRepository.addStation(new Station("매봉역"));
        StationRepository.addStation(new Station("양재시민의숲역"));
    }

    private void initLine() {
        LineRepository.addLine(new Line("2호선"));
        LineRepository.addLine(new Line("3호선"));
        LineRepository.addLine(new Line("신분당선"));
    }

    private void initPathGraph() {
        PathGraphRepository.addPathGraph(new PathGraph(PathCommand.MINIMUM_DISTANCE));
        PathGraphRepository.addPathGraph(new PathGraph(PathCommand.MINIMUM_TIME));
    }
}
