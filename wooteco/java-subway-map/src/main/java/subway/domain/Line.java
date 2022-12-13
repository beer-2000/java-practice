package subway.domain;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;

public class Line {
    private String name;
    private List<Section> sections;
    private final String ERROR_MESSAGE_SAME_END_POINT = "[ERROR] 상행 종점과 하행 종점은 다른 역으로 지정되어야 합니다.";
    private final String ERROR_MESSAGE_ALREADY_EXIST_STATION = "[ERROR] 이미 노선에 존재하는 역입니다.";
    private final String ERROR_MESSAGE_NOT_EXIST_STATION = "[ERROR] 노선에 존재하지 않는 역입니다.";
    private final String ERROR_MESSAGE_TOO_SHORT_LINE = "[ERROR] 노선이 너무 짧아 구간을 삭제할 수 없습니다.";

    public Line(String name, Station startStation, Station endStation) {
        if (startStation.equals(endStation)) {
            throw new IllegalArgumentException(ERROR_MESSAGE_SAME_END_POINT);
        }
        this.name = name;
        this.sections = new ArrayList<>();
        sections.add(new Section(1, startStation));
        sections.add(new Section(2, endStation));
        startStation.addLineName(name);
        endStation.addLineName(name);
    }

    public String getName() {
        return name;
    }

    public void addSection(int order, Station station) {
        validateAlreadyExist(station);
        sections.stream()
                .forEach(section -> {
                    if (section.isMoreThan(order)) {
                        section.addOrder();
                    }
                });
        sections.add(new Section(order, station));
    }

    private void validateAlreadyExist(Station station) {
        for (Section section : sections) {
            if (section.isOf(station)) {
                throw new IllegalArgumentException(ERROR_MESSAGE_ALREADY_EXIST_STATION);
            }
        }
    }

    public void deleteSection(Station station) {
        validateNotExist(station);
        checkSectionsSize();
        Section sectionToDelete = sections.stream()
                .filter(section -> section.isOf(station))
                .findAny()
                .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_STATION));
        int order = sectionToDelete.getOrder();
        sections.remove(sectionToDelete);
        downOrder(order);
    }

    private void validateNotExist(Station station) {
        for (Section section : sections) {
            if (section.isOf(station)) {
                return;
            }
        }
        throw new IllegalArgumentException(ERROR_MESSAGE_NOT_EXIST_STATION);
    }

    private void checkSectionsSize() {
        if (sections.size() <= 2) {
            throw new IllegalArgumentException(ERROR_MESSAGE_TOO_SHORT_LINE);
        }
    }

    private void downOrder(int order) {
        sections.forEach(section -> {
            if (section.isMoreThan(order)) {
                section.minusOrder();
            }
        });
    }

    public LineMap getLineMap() {
        List<Station> stations = sections.stream()
                .sorted(Comparator.comparing(Section::getOrder))
                .map(Section::getStation)
                .collect(Collectors.toList());
        return new LineMap(name, stations);
    }
}
