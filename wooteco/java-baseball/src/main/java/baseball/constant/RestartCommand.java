package baseball.constant;

import java.util.Arrays;

public enum RestartCommand {
    RESTART("1"),
    END("2");

    private String command;

    RestartCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean isCorrectCommand(String inputRestartCommand) {
        return Arrays.stream(RestartCommand.values())
                .anyMatch(command -> command.getCommand().equals(inputRestartCommand));
    }
}
