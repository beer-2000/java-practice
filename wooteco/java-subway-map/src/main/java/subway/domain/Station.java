package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Station {
    private String name;
    private List<String> lineNames;

    public Station(String name) {
        this.name = name;
        this.lineNames = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public void addLineName(String lineName) {
        if (lineNames.contains(lineName)) {
            return;
        }
        lineNames.add(lineName);
    }

    public boolean haveLine() {
        return lineNames.size() != 0;
    }
}
