package racingcar.domain;

import static racingcar.constant.RacingRule.MAXIMUM_CAR_NAME;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;
    private final String ERROR_MESSAGE_TOO_LONG_CAR_NAME = "[ERROR] 이름은 %d자 이하여야 합니다.";
    private final String ERROR_MESSAGE_EMPTY_CAR_NAME = "[ERROR] 이름은 공백일 수 없습니다.";

    public RacingGame(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        carNames.stream().forEach(carName -> {
            validateCarName(carName);
            cars.add(new Car(carName));
        });
        this.cars = cars;
    }

    private void validateCarName(String carName) {
        if (carName.length() > MAXIMUM_CAR_NAME) {
            throw new IllegalArgumentException(
                    String.format(ERROR_MESSAGE_TOO_LONG_CAR_NAME, MAXIMUM_CAR_NAME));
        }

        if (carName.isEmpty()) {
            throw new IllegalArgumentException(ERROR_MESSAGE_EMPTY_CAR_NAME);
        }
    }

    public List<CarStatus> playTurn() {
        List<CarStatus> carStatuses = new ArrayList<>();
        cars.stream().forEach(car -> {
            car.move();
            carStatuses.add(car.getStatus());
        });
        return carStatuses;
    }

    public List<CarStatus> getWinners() {
        int maxPosition = getMaxPosition();
        List<CarStatus> winnerCarStatuses = new ArrayList<>();
        cars.stream().forEach(car -> {
            if (car.isOn(maxPosition)) {
                winnerCarStatuses.add(car.getStatus());
            }
        });
        return winnerCarStatuses;
    }

    private int getMaxPosition() {
        int maxPosition = 0;
        for (Car car : cars) {
            if (maxPosition < car.getPosition()) {
                maxPosition = car.getPosition();
            }
        }
        return maxPosition;
    }
}
