package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.constant.PathCommand;

public class PathGraphRepository {
    private static final List<PathGraph> pathGraphs = new ArrayList<>();
    private static final String ERROR_MESSAGE_NOT_EXIST_PATH_GRAPH = "[ERROR] 존재하지 않는 경로 그래프입니다.";

    public static void addPathGraph(PathGraph pathGraph) {
        pathGraphs.add(pathGraph);
    }

    public static void addVertex(PathCommand pathCommand, Station station) {
        pathGraphs.stream()
                .filter(pathGraph -> pathGraph.isOf(pathCommand))
                .forEach(pathGraph -> pathGraph.addVertex(station));
    }

    public static void setEdgeWeight(PathInfo pathInfo) {
        pathGraphs.stream()
                .filter(pathGraph -> pathGraph.isOf(pathInfo.getPathCommand()))
                .forEach(pathGraph -> pathGraph.setEdgeWeight(
                        pathInfo.getStartStation(),
                        pathInfo.getEndStation(),
                        pathInfo.getWeight())
                );
    }

    public static List<Station> getStationsOfPath(
            PathCommand pathCommand, Station startStation, Station endStation) {
        PathGraph pathGraph = getPathGraphOf(pathCommand);
        return pathGraph.getStationsOfPath(startStation, endStation);
    }

    private static PathGraph getPathGraphOf(PathCommand pathCommand) {
        return pathGraphs.stream()
                .filter(pathGraph -> pathGraph.isOf(pathCommand))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_PATH_GRAPH));
    }

    public static int getDistanceThrough(List<Station> stationsOfPath) {
        PathGraph graph = getPathGraphOf(PathCommand.MINIMUM_DISTANCE);
        return graph.getSumOfWeight(stationsOfPath);
    }

    public static int getTimeThrough(List<Station> stationsOfPath) {
        PathGraph graph = getPathGraphOf(PathCommand.MINIMUM_TIME);
        return graph.getSumOfWeight(stationsOfPath);
    }
}
