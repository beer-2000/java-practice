package subway.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Lines {
    private List<Line> lines;
    private final String ERROR_MESSAGE_NOT_EXIST_LINE_NAME = "[ERROR] 존재하지 않는 노선 이름입니다.";
    private final String ERROR_MESSAGE_ALREADY_EXIST_LINE_NAME = "[ERROR] 이미 존재하는 노선 이름입니다.";

    public Lines() {
        lines = new ArrayList<>();
    }

    public void addLine(String name, Station startStation, Station endStation) {
        validateDuplication(name);
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

    public Line getLineByName(String lineName) {
        return lines.stream()
                .filter(line -> line.getName().equals(lineName))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_LINE_NAME));
    }

    public List<LineMap> getSubwayMap() {
        return lines.stream()
                .map(Line::getLineMap)
                .collect(Collectors.toList());
    }

    private void validateDuplication(String name) {
        for (Line line : lines) {
            if (line.getName().equals(name)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ALREADY_EXIST_LINE_NAME);
            }
        }
    }
}
