package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    private final Members members;
    private final String name;
    private final List<String> pairInfo;
    private int matchCount;

    public Mission(String name, String courseName) {
        this.members = new Members(courseName);
        this.name = name;
        this.pairInfo = new ArrayList<>();
        this.matchCount = 0;
    }

    public String getName() {
        return name;
    }

    public void matchPair() {
        pairInfo.clear();
        List<String> memberInfo = members.getMembersInfo();
        boolean isComplete = false;
        int shuffleCount = 0;
        while (!(isComplete || shuffleCount >= 3)) {
            List<String> shuffledMemberInfo = Randoms.shuffle(memberInfo);
            shuffleCount += 1;
            // TODO 출력 제거
//            System.out.println("셔플 카운트: " + shuffleCount);
            isComplete = savePairIfCan(memberInfo, shuffledMemberInfo);
        }
        checkShuffleCount(shuffleCount);
        matchCount += 1;
    }

    private void checkShuffleCount(int shuffleCount) {
        if (shuffleCount >= 3) {
            throw new IllegalArgumentException("[ERROR] 매칭에 실패했습니다.");
        }
    }

    private boolean savePairIfCan(List<String> memberInfo, List<String> shuffledMemberInfo) {
        if (members.canSavePair(shuffledMemberInfo)) {
            members.savePair(shuffledMemberInfo);
            savePairInfo(shuffledMemberInfo);
            return true;
        }
        return false;
    }

    public List<String> getPair() {
        if (pairInfo.size() == 0) {
            throw new IllegalArgumentException("ERROR] 매칭 이력이 없습니다.");
        }
        return pairInfo;
    }

    private void savePairInfo(List<String> memberInfo) {
        for (int index = 0; index < memberInfo.size(); index += 2) {
            if (index + 3 == memberInfo.size()) {
                pairInfo.add(memberInfo.get(index)
                        + " : " + memberInfo.get(index + 1)
                        + " : " + memberInfo.get(index + 2));
                break;
            }
            pairInfo.add(memberInfo.get(index) + " : " + memberInfo.get(index + 1));
        }
    }

    public boolean isMatchedAlready() {
        return matchCount != 0;
    }
}
