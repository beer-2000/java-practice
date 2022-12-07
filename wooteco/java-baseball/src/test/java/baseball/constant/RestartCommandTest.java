package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;

import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.ValueSource;

class RestartCommandTest {
    @ValueSource(strings = {"1", "2"})
    @ParameterizedTest
    void should_True_When_Input1(String input) {
        assertThat(RestartCommand.isCorrectCommand(input)).isTrue();
    }

    @ValueSource(strings = {"3", "a"})
    @ParameterizedTest
    void should_False_When_WrongInput(String input) {
        assertThat(RestartCommand.isCorrectCommand(input)).isFalse();
    }
}