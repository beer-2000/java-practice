package lotto.controller;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;
import lotto.domain.Cashier;
import lotto.domain.Lotto;
import lotto.domain.NumbersGenerator;
import lotto.domain.ResultTable;
import lotto.domain.WinningCalculator;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
    }

    public void start() {
        List<Lotto> lottos = purchaseLottos();
        ResultTable resultTable = calculateResult(lottos);
    }

    private List<Lotto> purchaseLottos() {
        List<Lotto> lottos = new ArrayList<>();
        outputView.announceInputMoney();
        int purchaseCount = Cashier.calculatePurchaseCountByMoney(inputView.getMoneyByUser());
        outputView.announcePurchaseCount(purchaseCount);
        IntStream.range(0, purchaseCount)
                .forEach(number -> {
                    List<Integer> numbers = NumbersGenerator.generateNumbers();
                    outputView.printNumbers(numbers);
                    lottos.add(new Lotto(numbers));
                });
        return lottos;
    }

    private ResultTable calculateResult(List<Lotto> lottos) {
        WinningCalculator winningCalculator = generateWinningCalculator();
        return winningCalculator.calculateResultOfLottos(lottos);
    }

    private WinningCalculator generateWinningCalculator() {
        outputView.announceInputTargetNumbers();
        String targetNumbersRaw = inputView.getTargetNumbersFromUser();
        outputView.announceInputBonusNumber();
        String bonusNumberRaw = inputView.getBonusNumberFromUser();
        WinningCalculator winningCalculator = new WinningCalculator(targetNumbersRaw, bonusNumberRaw);
        return winningCalculator;
    }
}
