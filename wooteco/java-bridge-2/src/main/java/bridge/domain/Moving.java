package bridge.domain;

public enum Moving {
    UP("U"),
    DOWN("D");

    private String command;

    Moving(String command) {
        this.command = command;
    }

    public boolean checkCommand(String command) {
        return this.command.equals(command);
    }
}
