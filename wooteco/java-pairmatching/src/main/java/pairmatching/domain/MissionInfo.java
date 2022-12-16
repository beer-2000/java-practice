package pairmatching.domain;

public class MissionInfo {
    private final String courseName;
    private final String levelName;
    private final String missionName;

    public MissionInfo(String courseName, String levelName, String missionName) {
        this.courseName = courseName;
        this.levelName = levelName;
        this.missionName = missionName;
    }

    public String getCourseName() {
        return courseName;
    }

    public String getLevelName() {
        return levelName;
    }

    public String getMissionName() {
        return missionName;
    }
}
