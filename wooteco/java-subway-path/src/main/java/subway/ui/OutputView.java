package subway.ui;

import java.util.Arrays;
import subway.constant.MainCommand;

public class OutputView {
    private final String ANNOUNCE_MAIN_COMMAND = "## 메인 화면";

    public void announceMainCommand() {
        System.out.println(ANNOUNCE_MAIN_COMMAND);
        Arrays.stream(MainCommand.values())
                .forEach(mainCommand -> System.out.println(mainCommand.getMessage()));
        System.out.println();
    }
}
