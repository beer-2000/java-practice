package pairmatching.controller;

import java.util.List;
import pairmatching.constant.FunctionCommand;
import pairmatching.domain.Courses;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class CourseController {
    private InputView inputView;
    private OutputView outputView;
    private Courses courses;

    public CourseController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        this.courses = new Courses();
    }

    public void start() {
        FunctionCommand functionCommand = FunctionCommand.PAIR_MATCHING;
        do {
            try {
                functionCommand = inputView.readFunctionCommand();
                runFunction(functionCommand);
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        } while (!functionCommand.equals(FunctionCommand.QUIT));
    }

    public void runFunction(FunctionCommand functionCommand) {
        if (functionCommand.equals(FunctionCommand.PAIR_MATCHING)) {
            matchPair();
        }
        if (functionCommand.equals(FunctionCommand.PAIR_FIND)) {
            findPair();
        }
        if (functionCommand.equals(FunctionCommand.PAIR_INIT)) {
            initPair();
        }
    }

    private void matchPair() {
        outputView.printCourseStatus(courses.getCourseStatus());
        List<String> pairInfo = courses.matchPair(inputView.readMissionInfo());
        outputView.printPairInfos(pairInfo);
    }

    private void findPair() {

    }

    private void initPair() {

    }
}
