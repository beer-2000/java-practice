package pairmatching.controller;

import java.util.List;
import pairmatching.constant.FunctionCommand;
import pairmatching.domain.Courses;
import pairmatching.domain.MissionInfo;
import pairmatching.ui.InputView;
import pairmatching.ui.OutputView;

public class CourseController {
    private final InputView inputView;
    private final OutputView outputView;
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
        boolean isComplete = false;
        while (!isComplete) {
            outputView.printCourseStatus(courses.getCourseStatus());
            MissionInfo missionInfo = getMissionInfoFromUser();
            if (courses.isMatchedAlready(missionInfo)) {
                isComplete = checkReMatch(missionInfo);
                continue;
            }
            List<String> pairInfo = courses.matchPair(missionInfo);
            outputView.printPairInfos(pairInfo);
            isComplete = true;
        }
    }

    private boolean checkReMatch(MissionInfo missionInfo) {
        if (inputView.readReMatchCommand().equals("네")) {
            List<String> pairInfo = courses.matchPair(missionInfo);
            outputView.printPairInfos(pairInfo);
            return true;
        }
        return false;
    }

    private void findPair() {
        outputView.printCourseStatus(courses.getCourseStatus());
        MissionInfo missionInfo = getMissionInfoFromUser();
        List<String> pairInfo = courses.getPair(missionInfo);
        outputView.printPairInfos(pairInfo);
    }

    private MissionInfo getMissionInfoFromUser() {
        while (true) {
            try {
                return inputView.readMissionInfo();
            } catch (IllegalArgumentException e) {
                outputView.printErrorMessage(e.getMessage());
            }
        }
    }

    private void initPair() {
        this.courses = new Courses();
        outputView.announceInitCourses();
    }
}
