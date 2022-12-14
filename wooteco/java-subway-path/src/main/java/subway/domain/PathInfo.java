package subway.domain;

import java.util.Objects;
import subway.constant.PathCommand;

public class PathInfo {
    private PathCommand pathCommand;
    private Station startStation;
    private Station endStation;
    private int weight;

    public PathInfo(PathCommand pathCommand) {
        this.pathCommand = pathCommand;
    }

    public void set(Station startStation, Station endStation, int weight) {
        this.startStation = startStation;
        this.endStation = endStation;
        this.weight = weight;
    }

    public PathCommand getPathCommand() {
        return pathCommand;
    }

    public Station getStartStation() {
        return startStation;
    }

    public Station getEndStation() {
        return endStation;
    }

    public int getWeight() {
        return weight;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final PathInfo pathInfo = (PathInfo) o;
        return pathCommand == pathInfo.pathCommand &&
                startStation == pathInfo.startStation &&
                endStation == pathInfo.endStation &&
                weight == pathInfo.weight;
    }

    @Override
    public int hashCode() {
        return Objects.hash(pathCommand, startStation, endStation, weight);
    }
}
