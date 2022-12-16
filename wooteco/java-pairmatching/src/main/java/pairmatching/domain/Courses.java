package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Courses {
    private final List<Course> courses;

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

    public List<String> matchPair(MissionInfo missionInfo) {
        Mission mission = getMissionByInfo(missionInfo);
        mission.matchPair();
        return mission.getPair();
    }

    private Mission getMissionByInfo(MissionInfo missionInfo) {
        Course targetCourse = courses.stream()
                .filter(course -> course.isNameOf(missionInfo.getCourseName()))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 코스입니다."));
        Level targetLevel = targetCourse.getLevelByName(missionInfo.getLevelName());
        return targetLevel.getMissionByName(missionInfo.getMissionName());
    }

    public boolean isMatchedAlready(MissionInfo missionInfo) {
        return getMissionByInfo(missionInfo).isMatchedAlready();
    }

    public List<String> getPair(MissionInfo missionInfo) {
        Mission mission = getMissionByInfo(missionInfo);
        return mission.getPair();
    }
}
