package subway.domain;

import java.util.ArrayList;
import java.util.List;
import subway.constant.PathCommand;

public class PathGraphRepository {
    private static final List<PathGraph> pathGraphs = new ArrayList<>();

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
}
