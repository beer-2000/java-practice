package subway.domain;

public class Section {
    private int order;
    private Station station;

    public Section(int order, Station station) {
        this.order = order;
        this.station = station;
    }
}
