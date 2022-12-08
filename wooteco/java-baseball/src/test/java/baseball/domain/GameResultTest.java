package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.api.Test;

class GameResultTest {

    @Test
    void equals() {
        GameResult gameResult1 = new GameResult(1, 2);
        GameResult gameResult2 = new GameResult(1, 2);
        // point != point2
        assertThat(gameResult1 == gameResult2).isFalse();  // 동일성 비교
    }

    @Test
    void equals2() {
        GameResult gameResult1 = new GameResult(1, 2);
        GameResult gameResult2 = new GameResult(1, 2);
        // point != point2
        assertThat(gameResult1).isEqualTo(gameResult2);
    }

    @Test
    void sameHashCode() {
        GameResult gameResult1 = new GameResult(1, 2);
        GameResult gameResult2 = new GameResult(1, 2);
        // point != point2
        assertThat(gameResult1).hasSameHashCodeAs(gameResult2);
    }
}