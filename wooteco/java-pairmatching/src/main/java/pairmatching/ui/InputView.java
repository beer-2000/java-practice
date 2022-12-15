package pairmatching.ui;

import camp.nextstep.edu.missionutils.Console;
import java.util.Arrays;
import pairmatching.constant.FunctionCommand;

public class InputView {

    public FunctionCommand readFunctionCommand() {
        System.out.println("기능을 선택하세요.");
        Arrays.stream(FunctionCommand.values())
                .forEach(functionCommand -> System.out.println(functionCommand.getMessage()));
        FunctionCommand functionCommand = FunctionCommand.get(Console.readLine());
        System.out.println();
        return functionCommand;
    }
}
