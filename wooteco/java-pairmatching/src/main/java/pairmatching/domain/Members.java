package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class Members {
    private List<Member> members;

    public Members(String courseName) {
        this.members = new ArrayList<>();
        if (courseName.equals("백엔드")) {
            initMembersOfBackend();
        }
        if (courseName.equals("프론트엔드")) {
            initMembersOfFrontend();
        }
    }

    private void initMembersOfBackend() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/backend-crew.md"));
            String str;
            while ((str = reader.readLine()) != null) {
                members.add(new Member(str));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR]: 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR]: IO에 문제가 있습니다.");
        }
    }

    private void initMembersOfFrontend() {
        try {
            BufferedReader reader = new BufferedReader(new FileReader("src/main/resources/frontend-crew.md"));
            String str;
            while ((str = reader.readLine()) != null) {
                members.add(new Member(str));
            }
            reader.close();
        } catch (FileNotFoundException e) {
            throw new IllegalArgumentException("[ERROR]: 파일을 찾을 수 없습니다.");
        } catch (IOException e) {
            throw new IllegalArgumentException("[ERROR]: IO에 문제가 있습니다.");
        }
    }
}
