package racingcar.domain;

import java.util.ArrayList;
import java.util.List;

public class RacingGame {
    private List<Car> cars;

    public RacingGame(List<String> carNames) {
        List<Car> cars = new ArrayList<>();
        carNames.stream().forEach(carName -> {
            cars.add(new Car(carName));
        });
        this.cars = cars;
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
