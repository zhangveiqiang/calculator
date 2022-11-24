package org.zwq.command;

import java.math.BigDecimal;
import java.math.RoundingMode;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class DivideCommand extends NumberCommand {

    public DivideCommand(Double first, Double second, String shopExp) {
        super(first, second, shopExp);
    }

    @Override
    protected Double execForNumber() {
        return BigDecimal.valueOf(this.getFirst())
                .divide(BigDecimal.valueOf(this.getSecond()), 14, RoundingMode.HALF_UP).doubleValue();
    }
}
