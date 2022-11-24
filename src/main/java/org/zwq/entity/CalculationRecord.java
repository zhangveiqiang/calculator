package org.zwq.entity;

/**
 * 可以使用 builder 的方式创建，目的就是对象属性只读。
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class CalculationRecord {

    private final Double result;

    private final String fullExp;

    public CalculationRecord(Double result, String fullExp) {
        this.result = result;
        this.fullExp = fullExp;
    }

    public Double getResult() {
        return result;
    }

    public String getFullExp() {
        return fullExp;
    }
}
