package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Level {
    private List<Mission> missions;
    private String name;

    public Level(String name) {
        this.name = name;
        this.missions = new ArrayList<>();
    }
}
