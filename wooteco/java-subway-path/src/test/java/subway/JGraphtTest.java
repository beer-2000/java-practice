package subway;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.jgrapht.alg.shortestpath.DijkstraShortestPath;
import org.jgrapht.graph.DefaultWeightedEdge;
import org.jgrapht.graph.WeightedMultigraph;
import org.junit.jupiter.api.Test;

public class JGraphtTest {
    @Test
    public void getDijkstraShortestPath() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v2", "v3"), 2);
        graph.setEdgeWeight(graph.addEdge("v1", "v3"), 100);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v3", "v1").getVertexList();
        System.out.println((dijkstraShortestPath.getPaths("v1")));
        System.out.println(dijkstraShortestPath.getPaths("v2").getWeight("v1"));
        int sumOfWeight = 0;
        for (int index = 0; index < shortestPath.size() - 1; index++) {
            double weight = dijkstraShortestPath
                    .getPaths(new String(shortestPath.get(index)))
                    .getWeight(new String(shortestPath.get(index + 1)));
            System.out.println(shortestPath.get(index));
            sumOfWeight += weight;
            System.out.println(weight);
            System.out.println(sumOfWeight);
        }
        System.out.println(sumOfWeight);
        System.out.println(shortestPath);
        assertThat(shortestPath.size()).isEqualTo(3);
    }

    @Test
    public void getDijkstraShortestPathTest() {
        WeightedMultigraph<String, DefaultWeightedEdge> graph = new WeightedMultigraph(DefaultWeightedEdge.class);
        graph.addVertex("v1");
        graph.addVertex("v2");
        graph.addVertex("v3");
        graph.addVertex("v4");
        graph.setEdgeWeight(graph.addEdge("v1", "v2"), 2);
        graph.setEdgeWeight(graph.addEdge("v3", "v4"), 10);

        DijkstraShortestPath dijkstraShortestPath = new DijkstraShortestPath(graph);
        List<String> shortestPath = dijkstraShortestPath.getPath("v1", "v4").getVertexList();
        assertThat(shortestPath.size()).isEqualTo(3);
    }
}
