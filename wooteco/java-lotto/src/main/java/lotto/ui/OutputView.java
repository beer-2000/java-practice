package lotto.ui;

import java.util.List;
import lotto.domain.ResultTable;

public class OutputView {
    private String REQUEST_INPUT_AMOUNT = "구입금액을 입력해 주세요.";
    private String ANNOUNCEMENT_PURCHASE_COUNT = "%d개를 구매했습니다.";
    private String LINE_SEPARATOR = System.lineSeparator();
    private String REQUEST_INPUT_TARGET_NUMBERS = "당첨 번호를 입력해 주세요.";
    private String REQUEST_INPUT_BONUS_NUMBER = "보너스 번호를 입력해 주세요.";
    private String ANNOUNCEMENT_WINNING_STATICS = "당첨 통계";
    private String LINE_FOR_SEPARATE = "---";
    private String ANNOUNCEMENT_WINNING_FIFTH = "3개 일치 (5,000원) - %d개" + LINE_SEPARATOR;
    private String ANNOUNCEMENT_WINNING_FOURTH = "4개 일치 (50,000원) - %d개" + LINE_SEPARATOR;
    private String ANNOUNCEMENT_WINNING_THIRD = "5개 일치 (1,500,000원) - %d개" + LINE_SEPARATOR;
    private String ANNOUNCEMENT_WINNING_SECOND = "5개 일치, 보너스 볼 일치 (30,000,000원) - %d개" + LINE_SEPARATOR;
    private String ANNOUNCEMENT_WINNING_FIRST = "6개 일치 (2,000,000,000원) - %d개" + LINE_SEPARATOR;
    private String ANNOUNCEMENT_YIELD = "총 수익률은 %s%%입니다.";

    public void announceInputMoney() {
        System.out.println(REQUEST_INPUT_AMOUNT);
    }

    public void announcePurchaseCount(int purchaseCount) {
        System.out.println();
        System.out.printf(ANNOUNCEMENT_PURCHASE_COUNT, purchaseCount);
        System.out.println();
    }

    public void printNumbers(List<Integer> numbers) {
        System.out.println(numbers);
    }

    public void announceInputTargetNumbers() {
        System.out.println();
        System.out.println(REQUEST_INPUT_TARGET_NUMBERS);
    }

    public void announceInputBonusNumber() {
        System.out.println();
        System.out.println(REQUEST_INPUT_BONUS_NUMBER);
    }

    public void announceResult(ResultTable resultTable) {
        System.out.println(ANNOUNCEMENT_WINNING_STATICS);
        System.out.println(LINE_FOR_SEPARATE);
        announceWinningResult(resultTable);
        System.out.printf(ANNOUNCEMENT_YIELD, resultTable.getYield());
    }

    public void printErrorMessage(String errorMessage) {
        System.out.println(errorMessage);
    }

    private void announceWinningResult(ResultTable resultTable) {
        System.out.printf(ANNOUNCEMENT_WINNING_FIFTH, resultTable.getCountOfFifth());
        System.out.printf(ANNOUNCEMENT_WINNING_FOURTH, resultTable.getCountOfFourth());
        System.out.printf(ANNOUNCEMENT_WINNING_THIRD, resultTable.getCountOfThird());
        System.out.printf(ANNOUNCEMENT_WINNING_SECOND, resultTable.getCountOfSecond());
        System.out.printf(ANNOUNCEMENT_WINNING_FIRST, resultTable.getCountOfFirst());
    }
}
