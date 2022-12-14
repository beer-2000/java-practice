package subway.domain;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.constant.PathCommand;

public class PathGraph {
    private PathCommand pathCommand;
    private WeightedMultigraph graph;

    public PathGraph(PathCommand pathCommand) {
        this.pathCommand = pathCommand;
        this.graph = new WeightedMultigraph<Station, DefaultWeightedEdge>(DefaultWeightedEdge.class);
    }

    public void addVertex(Station station) {
        graph.addVertex(station);
    }

    public void setEdgeWeight(Station startStation, Station endStation, int weight) {
        graph.setEdgeWeight(graph.addEdge(startStation, endStation), weight);
    }

    public boolean isOf(PathCommand pathCommand) {
        return this.pathCommand.equals(pathCommand);
    }

    public List<Station> getStationsOfPath(Station startStation, Station endStation) {
        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        return dijkstraShortestPath.getPath(startStation, endStation).getVertexList();
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
