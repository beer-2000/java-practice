package ui;

public class OutputView {
    private final String REQUEST_PLAYER_NAMES = "게임에 참여할 사람의 이름을 입력하세요.(쉼표 기준으로 분리)";
    private final String REQUEST_BETTING_MONEY = "%s의 배팅 금액은?";

    public void requestPlayerNames() {
        System.out.println(REQUEST_PLAYER_NAMES);
    }

    public void requestBettingMoney(String name) {
        System.out.println();
        System.out.printf(REQUEST_BETTING_MONEY, name);
        System.out.println();
    }
}
