package pairmatching.domain;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class Course {
    private List<Level> levels;
    private String name;

    public Course(String name) {
        this.name = name;
        initLevels();
    }

    private void initLevels() {
        this.levels = new ArrayList<>();
        levels.add(new Level("레벨1"));
        levels.add(new Level("레벨2"));
        levels.add(new Level("레벨3"));
        levels.add(new Level("레벨4"));
        levels.add(new Level("레벨5"));
        getLevelByName("레벨1").addMissions(Arrays.asList("자동차경주", "로또", "숫자야구게임"));
        getLevelByName("레벨2").addMissions(Arrays.asList("장바구니", "결제", "지하철노선도"));
        getLevelByName("레벨4").addMissions(Arrays.asList("성능개선", "배포"));
    }

    public Level getLevelByName(String name) {
        return levels.stream()
                .filter(level -> level.isNameOf(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 레벨 이름입니다."));
    }

    public String getName() {
        return name;
    }

    public List<LevelStatus> getLevelStatus() {
        return levels.stream()
                .map(Level::getLevelStatus)
                .collect(Collectors.toList());
    }
}
