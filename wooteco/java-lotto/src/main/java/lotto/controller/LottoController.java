package lotto.controller;

import java.util.List;
import lotto.domain.WinningCalculator;
import lotto.ui.InputView;
import lotto.ui.OutputView;

public class LottoController {
    private InputView inputView;
    private OutputView outputView;
    private WinningCalculator winningCalculator;

    public LottoController() {
        this.inputView = new InputView();
        this.outputView = new OutputView();
        outputView.announceInputTargetNumbers();
        outputView.announceInputBonusNumber();
        String targetNumbersRaw = inputView.getTargerNumbersFromUser();
        String bonusNumberRaw = inputView.getBonusNumberFromUser();
        this.winningCalculator = new WinningCalculator(targetNumbersRaw, bonusNumberRaw);
    }

    public void purchaseLottos() {

    }
}
