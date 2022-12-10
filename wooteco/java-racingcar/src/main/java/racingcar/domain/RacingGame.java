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
}
