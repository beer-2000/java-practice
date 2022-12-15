package pairmatching.domain;

public class Mission {
    private Members members;
    private String name;
    private int matchCount;

    public Mission(String name) {
        this.members = new Members();
        this.name = name;
        this.matchCount = 0;
    }

    public String getName() {
        return name;
    }
}
