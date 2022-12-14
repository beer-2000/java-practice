package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.constant.PathCommand;

public class PathGraph {
    private PathCommand pathCommand;
    private WeightedMultigraph graph;
    private final String ERROR_MESSAGE_NOT_CONNECTED = "[ERROR] 연결되지 않은 경로입니다.";
    private final String ERROR_MESSAGE_MINUS_VALUE_OF_DISTANCE = "[ERROR] 거리는 양수를 입력해주세요.";
    private final String ERROR_MESSAGE_MINUS_VALUE_OF_TIME = "[ERROR] 시간은 양수를 입력해주세요.";

    public PathGraph(PathCommand pathCommand) {
        this.pathCommand = pathCommand;
        this.graph = new WeightedMultigraph<Station, DefaultWeightedEdge>(DefaultWeightedEdge.class);
    }

    public void addVertex(Station station) {
        graph.addVertex(station);
    }

    public void setEdgeWeight(Station startStation, Station endStation, int weight) {
        validate(weight);
        graph.setEdgeWeight(graph.addEdge(startStation, endStation), weight);
    }

    private void validate(int weight) {
        if (pathCommand.equals(PathCommand.MINIMUM_DISTANCE)) {
            if (weight < 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE_MINUS_VALUE_OF_DISTANCE);
            }
        }
        if (pathCommand.equals(PathCommand.MINIMUM_TIME)) {
            if (weight < 0) {
                throw new IllegalArgumentException(ERROR_MESSAGE_MINUS_VALUE_OF_TIME);
            }
        }
    }

    public boolean isOf(PathCommand pathCommand) {
        return this.pathCommand.equals(pathCommand);
    }

    public List<Station> getStationsOfPath(Station startStation, Station endStation) {
        try {
            DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
            return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
        } catch (NullPointerException e) {
            throw new IllegalArgumentException(ERROR_MESSAGE_NOT_CONNECTED);
        }
    }

    public int getSumOfWeight(List<Station> stationsOfPath) {
        DijkstraShortestPath shortestPath = new DijkstraShortestPath(graph);
        int distance = 0;
        for (int index = 0; index < stationsOfPath.size() - 1; index++) {
            double weight = shortestPath
                    .getPaths(stationsOfPath.get(index))
                    .getWeight(stationsOfPath.get(index + 1));
            distance += weight;
        }
        return distance;
    }
}
