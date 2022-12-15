package pairmatching.domain;

public class Mission {
    private Members members;
    private String name;
    private int matchCount;

    public Mission(String name, String courseName) {
        this.members = new Members(courseName);
        this.name = name;
        this.matchCount = 0;
    }

    public String getName() {
        return name;
    }
}
