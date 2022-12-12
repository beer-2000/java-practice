package subway.domain;

import java.util.List;

public class LineMap {
    private String name;
    private List<Station> stations;

    public LineMap(String name, List<Station> stations) {
        this.name = name;
        this.stations = stations;
    }

    public String getName() {
        return name;
    }

    public List<Station> getStations() {
        return stations;
    }
}
