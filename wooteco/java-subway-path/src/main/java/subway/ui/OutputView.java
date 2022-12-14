package subway.ui;

import java.util.Arrays;
import subway.constant.MainCommand;
import subway.constant.PathCommand;

public class OutputView {
    private final String ANNOUNCE_MAIN_COMMAND = "## 메인 화면";
    private final String ANNOUNCE_PATH_COMMAND = "## 경로 기준";

    public void announceMainCommand() {
        System.out.println(ANNOUNCE_MAIN_COMMAND);
        Arrays.stream(MainCommand.values())
                .forEach(mainCommand -> System.out.println(mainCommand.getMessage()));
        System.out.println();
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void announcePathCommand() {
        System.out.println(ANNOUNCE_PATH_COMMAND);
        Arrays.stream(PathCommand.values())
                .forEach(pathCommand -> System.out.println(pathCommand.getMessage()));
        System.out.println();
    }
}
