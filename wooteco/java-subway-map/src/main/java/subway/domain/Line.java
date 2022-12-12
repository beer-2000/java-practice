package subway.domain;

import java.util.ArrayList;
import java.util.List;

public class Line {
    private String name;
    private List<Section> sections;
    private final String ERROR_MESSAGE_SAME_END_POINT = "[ERROR] 상행 종점과 하행 종점은 다른 역으로 지정되어야 합니다.";

    public Line(String name, Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SAME_END_POINT);
        }
        this.name = name;
        this.sections = new ArrayList<>();
        sections.add(new Section(1, startStation));
        sections.add(new Section(2, endStation));
    }

    public String getName() {
        return name;
    }
}
