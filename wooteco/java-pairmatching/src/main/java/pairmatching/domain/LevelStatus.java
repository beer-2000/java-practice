package pairmatching.domain;

import java.util.List;

public class LevelStatus {
    private String name;
    private List<String> missionNames;

    private final String SEPARATOR = " | ";

    public LevelStatus(String name, List<String> missionNames) {
        this.name = name;
        this.missionNames = missionNames;
    }

    public String getName() {

        return name;
    }

    public List<String> getMissionNames() {
        return missionNames;
    }

    public String getLevelInfo() {
        StringBuilder stringBuilder = new StringBuilder();
        missionNames.forEach(name -> {
            stringBuilder.append(SEPARATOR);
            stringBuilder.append(name);
        });
        stringBuilder.delete(0, 3);
        return "  - " + name + ": " + stringBuilder;
    }
}
