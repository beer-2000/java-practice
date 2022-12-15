package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Courses {
    private List<Course> courses;

    public Courses() {
        this.courses = new ArrayList<>();
        courses.add(new Course("백엔드"));
        courses.add(new Course("프론트엔드"));
    }

    public CourseStatus getCourseStatus() {
        List<String> courseNames = courses.stream()
                .map(Course::getName)
                .collect(Collectors.toList());
        List<LevelStatus> levelStatuses = courses.get(0).getLevelStatus();
        return new CourseStatus(courseNames, levelStatuses);
    }
}
