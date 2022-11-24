package org.zwq.command;

import org.zwq.entity.CalculationRecord;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public abstract class NumberCommand extends Command {


    public NumberCommand(Double first, Double second, String shopExp) {
        super(first, second, shopExp);
    }

    @Override
    public CalculationRecord exec() {
        Double result = this.execForNumber();
        CalculationRecord record = new CalculationRecord(result, super.fullExpression());
        return record;
    }

    protected abstract Double execForNumber();
}
