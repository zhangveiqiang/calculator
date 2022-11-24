package org.zwq.command;

import java.math.BigDecimal;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class PlusCommand extends NumberCommand {

    public PlusCommand(Double first, Double second, String shopExp) {
        super(first, second, shopExp);
    }

    @Override
    protected Double execForNumber() {
        return BigDecimal.valueOf(this.getFirst()).add(BigDecimal.valueOf(this.getSecond())).doubleValue();
    }
}
