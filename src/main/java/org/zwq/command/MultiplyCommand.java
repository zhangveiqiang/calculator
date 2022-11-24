package org.zwq.command;

import java.math.BigDecimal;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class MultiplyCommand extends NumberCommand {

    public MultiplyCommand(Double first, Double second, String shopExp) {
        super(first, second, shopExp);
    }

    @Override
    protected Double execForNumber() {
        return BigDecimal.valueOf(this.getFirst()).multiply(BigDecimal.valueOf(this.getSecond())).doubleValue();
    }
}
