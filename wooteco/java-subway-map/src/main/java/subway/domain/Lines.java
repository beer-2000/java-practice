package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private List<Line> lines;
    private final String ERROR_MESSAGE_NOT_EXIST_LINE_NAME = "[ERROR] 존재하지 않는 노선 이름입니다.";

    public Lines() {
        lines = new ArrayList<>();
    }

    public void addLine(String name, Station startStation, Station endStation) {
        lines.add(new Line(name, startStation, endStation));
    }

    public void delete(String lineName) {
        Line lineToDelete = lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_LINE_NAME));
        lines.remove(lineToDelete);
    }

    public List<String> getLineNames() {
        return lines.stream()
                .map(Line::getName)
                .collect(Collectors.toList());
    }
}
