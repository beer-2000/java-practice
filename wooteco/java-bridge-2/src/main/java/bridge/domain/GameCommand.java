package bridge.domain;

import java.util.Arrays;

public enum GameCommand {
    RETRY("R"),
    QUIT("Q");

    private String command;

    private static final String ERROR_MESSAGE_INCORRECT_COMMAND = "[ERROR] 잘못된 입력입니다.";

    GameCommand(String command) {
        this.command = command;
    }

    public String getCommand() {
        return command;
    }

    public boolean checkCommand(String command) {
        return this.command.equals(command);
    }

    public static GameCommand getByCommand(String command) {
        return Arrays.stream(GameCommand.values())
            .filter(gameCommand -> gameCommand.checkCommand(command))
            .findFirst()
            .orElseThrow(() -> new IllegalArgumentException(ERROR_MESSAGE_INCORRECT_COMMAND));
    }
}
