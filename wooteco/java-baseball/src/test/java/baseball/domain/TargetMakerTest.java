package baseball.domain;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;

class TargetMakerTest {

    @Test
    void should_3numbers_When_Generate() {
        List<Integer> target = TargetMaker.generateTargetNumbers();
        System.out.println(target);
        assertThat(target).hasSize(3);
    }
}