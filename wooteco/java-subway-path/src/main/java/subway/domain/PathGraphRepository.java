package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class PathGraphRepository {
    private static final List<PathGraph> pathGraphs = new ArrayList<>();

    public static void addPathGraph(PathGraph pathGraph) {
        pathGraphs.add(pathGraph);
    }
}
