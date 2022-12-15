package pairmatching.domain;

public class MissionInfo {
    private String courseName;
    private String levelName;
    private String missionName;

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
