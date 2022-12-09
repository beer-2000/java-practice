package lotto.domain;

import static lotto.constant.LottoRule.PRICE;
import static lotto.domain.WinningResult.FIFTH;
import static lotto.domain.WinningResult.FIRST;
import static lotto.domain.WinningResult.FOURTH;
import static lotto.domain.WinningResult.SECOND;
import static lotto.domain.WinningResult.THIRD;

import java.text.DecimalFormat;
import java.text.NumberFormat;
import java.util.Arrays;
import java.util.LinkedHashMap;
import java.util.Map;

public class ResultTable {
    private Map<WinningResult, Integer> table;

    public ResultTable() {
        Map<WinningResult, Integer> table = new LinkedHashMap<>();
        Arrays.stream(WinningResult.values())
                .forEach(winningResult -> {
                    table.put(winningResult, 0);
                });
        this.table = table;
    }

    public void add(WinningResult winningResult) {
        int count = table.get(winningResult);
        table.put(winningResult, count + 1);
    }

    public int getCountOfFifth() {
        return table.get(FIFTH);
    }

    public int getCountOfFourth() {
        return table.get(FOURTH);
    }

    public int getCountOfThird() {
        return table.get(THIRD);
    }

    public int getCountOfSecond() {
        return table.get(SECOND);
    }

    public int getCountOfFirst() {
        return table.get(FIRST);
    }

    public String getYield() {
        double countAll = 0;
        double amount = 0;
        for (WinningResult winningResult : table.keySet()) {
            countAll += table.get(winningResult);
            amount += table.get(winningResult) * winningResult.getPrize();
        }
        double purchaseMoney = countAll * PRICE;
        double yield = amount / purchaseMoney * 100;
        NumberFormat formatter = new DecimalFormat("#,##0.0");
        return formatter.format(yield);
    }
}
