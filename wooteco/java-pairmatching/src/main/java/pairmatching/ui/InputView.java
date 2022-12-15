package pairmatching.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import pairmatching.constant.FunctionCommand;
import pairmatching.domain.MissionInfo;

public class InputView {

    public FunctionCommand readFunctionCommand() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(FunctionCommand.values())
                .forEach(functionCommand -> System.out.println(functionCommand.getMessage()));
        FunctionCommand functionCommand = FunctionCommand.get(Console.readLine());
        System.out.println();
        return functionCommand;
    }

    public MissionInfo readMissionInfo() {
        System.out.println("과정, 레벨, 미션을 선택하세요.");
        System.out.println("ex) 백엔드, 레벨1, 자동차경주");
        String[] missionInfoRaw = Console.readLine().split(", ");
        return new MissionInfo(missionInfoRaw[0], missionInfoRaw[1], missionInfoRaw[2]);
    }
}
