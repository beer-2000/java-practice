package racingcar.domain;

import static racingcar.constant.RacingRule.MOVING_DISTANCE;
import static racingcar.constant.RacingRule.MOVING_THRESHOLD;
import static racingcar.constant.RacingRule.RANDOM_END_INCLUSIVE;
import static racingcar.constant.RacingRule.RANDOM_START_INCLUSIVE;

import camp.nextstep.edu.missionutils.Randoms;

public class Car {
    private final String name;
    private int position = 0;

    public Car(String name) {
        this.name = name;
    }

    public void move() {
        int randomNumber = Randoms.pickNumberInRange(RANDOM_START_INCLUSIVE, RANDOM_END_INCLUSIVE);
        if (randomNumber >= MOVING_THRESHOLD) {
            position += MOVING_DISTANCE;
        }
    }
}
