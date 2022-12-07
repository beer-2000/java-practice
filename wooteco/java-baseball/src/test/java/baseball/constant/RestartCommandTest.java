package baseball.constant;

import static org.assertj.core.api.Assertions.assertThat;

import java.util.stream.Stream;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.MethodSource;
import org.junit.jupiter.params.provider.ValueSource;

class RestartCommandTest {
    @ValueSource(strings = {"1", "2"})
    @ParameterizedTest
    void should_True_When_Input1(String input) {
        assertThat(RestartCommand.isCorrectCommand(input)).isTrue();
    }

    @MethodSource("isCorrectCommandArguments")
    @ParameterizedTest
    void should_False_When_WrongInput(String input, boolean expected) {
        assertThat(RestartCommand.isCorrectCommand(input)).isEqualTo(expected);
    }

    private static Stream<Arguments> isCorrectCommandArguments() {
        return Stream.of(
                Arguments.of(null, false),
                Arguments.of("", false),
                Arguments.of("  ", false),
                Arguments.of("a", false),
                Arguments.of("1", true),
                Arguments.of("2", true)
        );
    }
}