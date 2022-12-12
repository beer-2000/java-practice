package subway.ui;

import java.util.Arrays;
import subway.constant.FunctionCommand;
import subway.constant.StationCommand;

public class OutputView {
    private final String ANNOUNCEMENT_MAIN_FUNCTION = "## 메인 화면";
    private final String ANNOUNCEMENT_STATION_FUNCTION = "## 역 관리 화면";
    private final String ANNOUNCEMENT_REGISTER_STATION = "[INFO] 지하철 역이 등록되었습니다.";

    public void announceMainFunction() {
        System.out.println(ANNOUNCEMENT_MAIN_FUNCTION);
        Arrays.stream(FunctionCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
    }

    public void announceStationFunction() {
        System.out.println(ANNOUNCEMENT_STATION_FUNCTION);
        Arrays.stream(StationCommand.values())
                .forEach(value -> {
                    System.out.println(value.getMessage());
                });
    }

    public void announceRegisterStation() {
        System.out.println(ANNOUNCEMENT_REGISTER_STATION);
    }

}
