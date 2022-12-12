package subway.ui;

import java.util.Arrays;
import subway.constant.FunctionCommand;

public class OutputView {
    private final String ANNOUNCEMENT_MAIN_FUNCTION = "## 메인 화면";

    public void announceMainFunction() {
        System.out.println(ANNOUNCEMENT_MAIN_FUNCTION);
        Arrays.stream(FunctionCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
    }

}
