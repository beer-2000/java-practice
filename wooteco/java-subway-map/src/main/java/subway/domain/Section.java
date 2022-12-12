package subway.domain;

public class Section {
    private int order;
    private Station station;

    public Section(int order, Station station) {
        this.order = order;
        this.station = station;
    }

    public boolean isOf(Station station) {
        return this.station.equals(station);
    }

    public boolean isMoreThan(int order) {
        return this.order >= order;
    }

    public void addOrder() {
        order += 1;
    }
}
