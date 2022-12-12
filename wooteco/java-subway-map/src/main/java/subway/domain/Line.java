package subway.domain;

import java.util.List;

public class Line {
    private String name;
    private List<Section> sections;

    public Line(String name, Station startStation, Station endStation) {
        this.name = name;
        sections.add(new Section(1, startStation));
        sections.add(new Section(2, endStation));
    }

    public String getName() {
        return name;
    }

    // 추가 기능 구현
}
