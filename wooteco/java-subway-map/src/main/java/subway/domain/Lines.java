package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Lines {
    private List<Line> lines;

    public Lines() {
        lines = new ArrayList<>();
    }

    public void addLine(String name, Station startStation, Station endStation) {
        lines.add(new Line(name, startStation, endStation));
    }
}
