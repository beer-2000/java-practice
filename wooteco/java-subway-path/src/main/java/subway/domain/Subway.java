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
        initPathsOfDistanceFirst();
        initPathsOfDistanceSecond();
        initPathsOfTimeFirst();
        initPathsOfTimeSecond();
    }

    private static void initPathsOfDistanceFirst() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_DISTANCE);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("강남역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("역삼역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("남부터미널역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("남부터미널역"), StationRepository.getStationByName("양재역"), 6);
        PathGraphRepository.setEdgeWeight(pathInfo);

    }

    private static void initPathsOfDistanceSecond() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_DISTANCE);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("매봉역"), 1);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("양재역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("양재시민의숲역"), 10);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }

    private static void initPathsOfTimeFirst() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_TIME);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("강남역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("역삼역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("교대역"), StationRepository.getStationByName("남부터미널역"), 2);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("남부터미널역"), StationRepository.getStationByName("양재역"), 5);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }

    private static void initPathsOfTimeSecond() {
        PathInfo pathInfo = new PathInfo(PathCommand.MINIMUM_TIME);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("매봉역"), 1);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("강남역"), StationRepository.getStationByName("양재역"), 8);
        PathGraphRepository.setEdgeWeight(pathInfo);
        pathInfo.set(StationRepository.getStationByName("양재역"), StationRepository.getStationByName("양재시민의숲역"), 3);
        PathGraphRepository.setEdgeWeight(pathInfo);
    }
}
