package subway.domain;

import java.util.List;

public class PathResult {
    private int distance;
    private int time;
    private List<String> stationNames;

    public PathResult(int distance, int time, List<String> stationNames) {
        this.distance = distance;
        this.time = time;
        this.stationNames = stationNames;
    }

    public int getDistance() {
        return distance;
    }

    public int getTime() {
        return time;
    }

    public List<String> getStationNames() {
        return stationNames;
    }
}
