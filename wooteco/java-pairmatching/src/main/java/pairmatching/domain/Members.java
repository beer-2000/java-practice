package pairmatching.domain;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Members {
    private final List<Member> members;

    public Members(String courseName) {
        this.members = new ArrayList<>();
        if (courseName.equals("백엔드")) {
            initMembersOfBackend();
        }
        if (courseName.equals("프론트엔드")) {
            initMembersOfFrontend();
        }
    }

    public List<String> getMembersInfo() {
        return members.stream()
                .map(Member::getName)
                .collect(Collectors.toList());
    }

    public boolean canSavePair(List<String> shuffledMemberInfo) {
        boolean alreadyPair;
        for (int index = 0; index < shuffledMemberInfo.size(); index += 2) {
            if (index + 3 == shuffledMemberInfo.size()) {
                alreadyPair = checkAlreadyPairOfThree(
                        shuffledMemberInfo.get(index),
                        shuffledMemberInfo.get(index + 1),
                        shuffledMemberInfo.get(index + 2));
                return !alreadyPair;
            }
            alreadyPair = checkAlreadyPair(shuffledMemberInfo.get(index), shuffledMemberInfo.get(index + 1));
            if (alreadyPair) {
                return false;
            }
        }
        return true;
    }

    private boolean checkAlreadyPair(String firstMemberName, String secondMemberName) {
        Member firstMember = getMemberByName(firstMemberName);
        Member secondMember = getMemberByName(secondMemberName);
        return firstMember.haveMatchedWith(secondMember);
    }

    private boolean checkAlreadyPairOfThree(
            String firstMemberName, String secondMemberName, String thirdMemberName) {
        Member firstMember = getMemberByName(firstMemberName);
        Member secondMember = getMemberByName(secondMemberName);
        Member thirdMember = getMemberByName(thirdMemberName);
        boolean haveAlreadyMatched;
        haveAlreadyMatched =
                firstMember.haveMatchedWith(secondMember) || secondMember.haveMatchedWith(thirdMember)
                        || thirdMember.haveMatchedWith(firstMember);
        return haveAlreadyMatched;
    }

    private Member getMemberByName(String name) {
        return members.stream()
                .filter(member -> member.isNameOf(name))
                .findFirst()
                .orElseThrow(() -> new IllegalArgumentException("[ERROR] 존재하지 않는 멤버 이름입니다."));
    }

    public void savePair(List<String> shuffledMemberInfo) {
        for (int index = 0; index < shuffledMemberInfo.size(); index += 2) {
            if (index + 3 == shuffledMemberInfo.size()) {
                addPairHistoryOfThree(shuffledMemberInfo.get(index), shuffledMemberInfo.get(index + 1),
                        shuffledMemberInfo.get(index + 2));
                return;
            }
            addPairHistory(shuffledMemberInfo.get(index), shuffledMemberInfo.get(index + 1));
        }
    }

    private void addPairHistory(String firstMemberName, String secondMemberName) {
        Member firstMember = getMemberByName(firstMemberName);
        Member secondMember = getMemberByName(secondMemberName);
        firstMember.addHistory(secondMember);
        secondMember.addHistory(firstMember);
    }

    private void addPairHistoryOfThree(String firstMemberName, String secondMemberName, String thirdMemberName) {
        Member firstMember = getMemberByName(firstMemberName);
        Member secondMember = getMemberByName(secondMemberName);
        Member thirdMember = getMemberByName(thirdMemberName);
        firstMember.addHistory(secondMember);
        firstMember.addHistory(thirdMember);
        secondMember.addHistory(firstMember);
        secondMember.addHistory(thirdMember);
        thirdMember.addHistory(firstMember);
        thirdMember.addHistory(secondMember);
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
