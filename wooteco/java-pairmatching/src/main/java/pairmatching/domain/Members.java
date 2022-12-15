package pairmatching.domain;

import java.util.List;

public class Members {
    private List<Member> members;

    public Members(String courseName) {
        if (courseName.equals("백엔드")) {
            initMembersOfBackend();
        }
        if (courseName.equals("프론트엔트")) {
            initMembersOfFrontend();
        }
    }
}
