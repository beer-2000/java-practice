package subway.ui;

import java.util.Arrays;
import subway.constant.MainCommand;
import subway.constant.PathCommand;
import subway.domain.PathResult;

public class OutputView {
    private final String ANNOUNCE_MAIN_COMMAND = "## 메인 화면";
    private final String ANNOUNCE_PATH_COMMAND = "## 경로 기준";
    private final String ANNOUNCE_PATH_RESULT = "## 조회 결과";
    private final String SEPARATE_LINE = "[INFO] ---";
    private final String FORMAT_DISTANCE = "[INFO] 총 거리: %dkm";
    private final String FORMAT_TIME = "[INFO] 총 소요 시간: %d분";
    private final String FORMAT_STATION = "[INFO] %s";

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

    public void printPathResult(PathResult pathResult) {
        System.out.println(ANNOUNCE_PATH_RESULT);
        System.out.println(SEPARATE_LINE);
        System.out.printf(FORMAT_DISTANCE, pathResult.getDistance());
        System.out.println();
        System.out.printf(FORMAT_TIME, pathResult.getTime());
        System.out.println();
        System.out.println(SEPARATE_LINE);
        pathResult.getStationNames()
                .forEach(name -> {
                    System.out.printf(FORMAT_STATION, name);
                    System.out.println();
                });
        System.out.println();
    }
}
