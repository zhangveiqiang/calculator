package org.zwq.command;

import org.zwq.entity.CalculationRecord;
import org.zwq.enums.Expression;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public abstract class Command {

    private final Double first;

    private final Double second;

    private final String shopExp;

    public Command(Double first, Double second, String shopExp) {
        this.first = first;
        this.second = second;
        this.shopExp = shopExp;
    }

    public abstract CalculationRecord exec();

    public Double getFirst() {
        return first;
    }

    public Double getSecond() {
        return second;
    }

    protected String fullExpression() {
        return this.first + " " + this.shopExp + " " + this.second;
    }

}
