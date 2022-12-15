package pairmatching.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import java.util.regex.Pattern;
import pairmatching.constant.FunctionCommand;
import pairmatching.domain.MissionInfo;

public class InputView {
    private static final String INPUT_MISSION_INFO =
            "^[a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]*, [a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]*, [a-zA-Z가-힣ㄱ-ㅎㅏ-ㅣ0-9]*$";

    public FunctionCommand readFunctionCommand() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(FunctionCommand.values())
                .forEach(functionCommand -> System.out.println(functionCommand.getMessage()));
        FunctionCommand functionCommand = FunctionCommand.get(Console.readLine());
        System.out.println();
        return functionCommand;
    }

    public MissionInfo readMissionInfo() {
        try {
            System.out.println("과정, 레벨, 미션을 선택하세요.");
            System.out.println("ex) 백엔드, 레벨1, 자동차경주");
            String missionInfoBeforeSplit = Console.readLine();
            validateMissionInfo(missionInfoBeforeSplit);
            String[] missionInfoRaw = missionInfoBeforeSplit.split(", ");
            MissionInfo missionInfo = new MissionInfo(missionInfoRaw[0], missionInfoRaw[1], missionInfoRaw[2]);
            System.out.println();
            return missionInfo;
        } catch (ArrayIndexOutOfBoundsException e) {
            throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션명을 다음과 같이 입력하세요. \"ex) 백엔드, 레벨1, 자동차경주\"");
        }
    }

    private void validateMissionInfo(String missionInfoBeforeSplit) {
        boolean isMatch = Pattern.matches(INPUT_MISSION_INFO, missionInfoBeforeSplit);
        if (isMatch) {
            return;
        }
        throw new IllegalArgumentException("[ERROR] 과정, 레벨, 미션명을 다음과 같이 입력하세요. \"ex) 백엔드, 레벨1, 자동차경주\"");
    }

    public String readReMatchCommand() {
        System.out.println("매칭 정보가 있습니다. 다시 매칭하시겠습니까?");
        System.out.println("네 | 아니오");
        String reMatchCommand = Console.readLine();
        System.out.println();
        return reMatchCommand;
    }
}
