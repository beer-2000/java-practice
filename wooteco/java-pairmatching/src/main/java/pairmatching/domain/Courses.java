package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Courses {
    private List<Course> courses;

    public Courses() {
        this.courses = new ArrayList<>();
        courses.add(new Course("백엔드"));
        courses.add(new Course("프론트엔드"));
    }
}
