package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Level {
    private List<Mission> missions;
    private String name;
    private String courseName;

    public Level(String name, String courseName) {
        this.name = name;
        this.courseName = courseName;
        this.missions = new ArrayList<>();
    }

    public void addMissions(List<String> missionNames) {
        missionNames.forEach(name -> missions.add(new Mission(name, courseName)));
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public LevelStatus getLevelStatus() {
        List<String> missionNames = missions.stream()
                .map(Mission::getName)
                .collect(Collectors.toList());
        return new LevelStatus(name, missionNames);
    }
}
