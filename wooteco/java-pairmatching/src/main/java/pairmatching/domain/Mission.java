package pairmatching.domain;

import camp.nextstep.edu.missionutils.Randoms;
import java.util.ArrayList;
import java.util.List;

public class Mission {
    private Members members;
    private String name;
    private List<String> pairInfo;
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
        savePairInfo(Randoms.shuffle(memberInfo));
        matchCount += 1;
    }

    public List<String> getPair() {
        if (pairInfo.size() == 0) {
            throw new IllegalArgumentException("[ERROR] 페어 매칭 정보가 없습니다.");
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
