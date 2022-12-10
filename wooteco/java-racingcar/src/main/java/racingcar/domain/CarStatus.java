package racingcar.domain;

import java.util.Objects;

public class CarStatus {
    private final String name;
    private final int position;

    public CarStatus(String name, int position) {
        this.name = name;
        this.position = position;
    }

    public String getName() {
        return name;
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(final Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        final CarStatus carStatus = (CarStatus) o;
        return name == carStatus.name &&
                position == carStatus.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
