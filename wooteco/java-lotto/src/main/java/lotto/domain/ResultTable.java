package lotto.domain;

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
}
