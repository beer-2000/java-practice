package subway.domain;

import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import subway.constant.PathCommand;

public class PathGraph {
    private PathCommand pathCommand;
    private WeightedMultigraph graph;

    public PathGraph(PathCommand pathCommand) {
        this.pathCommand = pathCommand;
        WeightedMultigraph<Station, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        this.graph = graph;
    }

    public void addVertex(Station station) {
        graph.addVertex(station);
    }

    public void setEdgeWeight(Station startStation, Station endStation, int weight) {
        graph.setEdgeWeight(startStation, endStation, weight);
    }

    public boolean isOf(PathCommand pathCommand) {
        return this.pathCommand.equals(pathCommand);
    }
}
