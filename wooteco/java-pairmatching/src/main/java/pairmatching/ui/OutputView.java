package pairmatching.ui;

import java.util.List;
import pairmatching.domain.CourseStatus;

public class OutputView {
    private final String SEPARATE_LINE_CHARACTERS = "#############################################";

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
        System.out.println();
    }

    public void printCourseStatus(CourseStatus courseStatus) {
        System.out.println(SEPARATE_LINE_CHARACTERS);
        System.out.println("과정: " + courseStatus.getCourseNamesInfo());
        System.out.println("미션:");
        courseStatus.getLevelStatuses()
                .forEach(levelStatus -> {
                    System.out.println(levelStatus.getLevelInfo());
                });
        System.out.println(SEPARATE_LINE_CHARACTERS);
    }

    public void printPairInfos(List<String> pairInfo) {
        pairInfo.forEach(System.out::println);
        System.out.println();
    }
}
