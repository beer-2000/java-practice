package pairmatching.domain;

import java.util.ArrayList;
import java.util.List;

public class Member {
    private final String name;
    private final List<Member> members;

    public Member(String name) {
        this.name = name;
        this.members = new ArrayList<>();
    }

    public String getName() {
        return name;
    }

    public boolean isNameOf(String name) {
        return this.name.equals(name);
    }

    public boolean haveMatchedWith(Member member) {
        return members.contains(member);
    }

    public void addHistory(Member member) {
        members.add(member);
        // TODO 출력 제거
//        System.out.printf(name + ": ");
//        members.forEach(member1 -> {
//            System.out.print(member1.getName());
//            System.out.print(", ");
//        });
//        System.out.println();
    }
}
