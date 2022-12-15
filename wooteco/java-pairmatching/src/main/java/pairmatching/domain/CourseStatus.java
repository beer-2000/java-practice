package pairmatching.domain;

import java.util.List;

public class CourseStatus {
    private List<String> courseNames;
    private List<LevelStatus> levelStatuses;

    private final String SEPARATOR = " | ";

    public CourseStatus(List<String> courseNames, List<LevelStatus> levelStatuses) {
        this.courseNames = courseNames;
        this.levelStatuses = levelStatuses;
    }

    public List<String> getCourseNames() {
        return courseNames;
    }

    public List<LevelStatus> getLevelStatuses() {
        return levelStatuses;
    }

    public String getCourseNamesInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        courseNames.forEach(name -> {
            stringBuilder.append(SEPARATOR);
            stringBuilder.append(name);
        });
        stringBuilder.delete(0, 3);
        return stringBuilder.toString();
    }
}
