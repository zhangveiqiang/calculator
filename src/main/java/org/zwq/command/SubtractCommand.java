package org.zwq.command;

import java.math.BigDecimal;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class SubtractCommand extends NumberCommand {

    public SubtractCommand(Double first, Double second, String shopExp) {
        super(first, second, shopExp);
    }

    @Override
    protected Double execForNumber() {
        return BigDecimal.valueOf(this.getFirst()).subtract(BigDecimal.valueOf(this.getSecond())).doubleValue();
    }
}
