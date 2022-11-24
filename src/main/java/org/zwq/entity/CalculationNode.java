package org.zwq.entity;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class CalculationNode {

    private CalculationRecord record;

    private CalculationNode prev;

    private CalculationNode next;

    public CalculationRecord getRecord() {
        return record;
    }

    public void setRecord(CalculationRecord record) {
        this.record = record;
    }

    public CalculationNode getPrev() {
        return prev;
    }

    public void setPrev(CalculationNode prev) {
        this.prev = prev;
    }

    public CalculationNode getNext() {
        return next;
    }

    public void setNext(CalculationNode next) {
        this.next = next;
    }
}
