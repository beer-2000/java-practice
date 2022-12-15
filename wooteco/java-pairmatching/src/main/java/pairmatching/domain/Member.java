package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private String name;
    private List<Member> members;

    public Member(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }
}
