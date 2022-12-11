package ui;

import java.util.List;

public class OutputView {
    private final String REQUEST_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final String REQUEST_BETTING_MONEY = "%s의 배팅 금액은?";
    private final String ANNOUNCEMENT_DISTRIBUTION = "딜러와 %s에게 2장을 나누었습니다.";
    private final String REQUEST_COMMAND_GET_CARD = "%s는 한장의 카드를 더 받겠습니까?(예는 y, 아니오는 n)";

    public void requestPlayerNames() {
        System.out.println(REQUEST_PLAYER_NAMES);
    }

    public void requestBettingMoney(String name) {
        System.out.println();
        System.out.printf(REQUEST_BETTING_MONEY, name);
        System.out.println();
    }

    public void announceDistribution(List<String> playerNames) {
        System.out.println();
        String playerNamesJoined = String.join(", ", playerNames);
        System.out.printf(ANNOUNCEMENT_DISTRIBUTION, playerNamesJoined);
        System.out.println();
    }

    public void printCards(String cardValues) {
        System.out.println(cardValues);
    }

    public void requestWhetherGetCard(String name) {
        System.out.println();
        System.out.printf(REQUEST_COMMAND_GET_CARD, name);
        System.out.println();
    }
}
