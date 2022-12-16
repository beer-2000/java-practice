package bridge;

import bridge.domain.Moving;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.IntStream;

import static bridge.constant.BridgeRule.MAXIMUM_BRIDGE_SIZE;
import static bridge.constant.BridgeRule.MINIMUM_BRIDGE_SIZE;

/**
 * 다리의 길이를 입력 받아서 다리를 생성해주는 역할을 한다.
 */
public class BridgeMaker {

    private final BridgeNumberGenerator bridgeNumberGenerator;

    public BridgeMaker(BridgeNumberGenerator bridgeNumberGenerator) {
        this.bridgeNumberGenerator = bridgeNumberGenerator;
    }

    /**
     * @param size 다리의 길이
     * @return 입력받은 길이에 해당하는 다리 모양. 위 칸이면 "U", 아래 칸이면 "D"로 표현해야 한다.
     */
    public List<String> makeBridge(int size) {
        if (size < MINIMUM_BRIDGE_SIZE || size > MAXIMUM_BRIDGE_SIZE) {
            throw new IllegalArgumentException(String.format(
                "[ERROR] 다리 길이는 %d 이상, %d 이하여야 합니다.", MINIMUM_BRIDGE_SIZE, MAXIMUM_BRIDGE_SIZE
            ));
        }
        List<String> bridgeRaw = new ArrayList<>();
        IntStream.range(0, size)
            .forEach(number -> bridgeRaw.add(Moving.getCommandByNumber(bridgeNumberGenerator.generate())));
        return bridgeRaw;
    }
}
