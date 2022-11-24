package org.zwq.entity;

/**
 * @author zhangweiqiang
 * @date 2022/11/24
 **/
public class CalculationNodes {

    private CalculationNode head;

    private CalculationNode tail;

    public void add(CalculationRecord record) {
        CalculationNode node = new CalculationNode();
        node.setRecord(record);
        if (this.head == null) {
            this.head = node;
        } else {
            if (this.tail.getNext() != null) {
                this.tail.getNext().setPrev(null);
            }
            this.tail.setNext(node);
            node.setPrev(this.tail);
        }
        this.tail = node;
    }

    public CalculationRecord undo() {
        if (this.tail != null && this.tail.getPrev() != null) {
            this.tail = this.tail.getPrev();
        }
        return this.tail == null ? null : this.tail.getRecord();
    }

    public CalculationRecord redo() {
        if (this.tail != null && this.tail.getNext() != null) {
            this.tail = this.tail.getNext();
        }
        return this.tail == null ? null : this.tail.getRecord();
    }

    public void clear() {
        this.head = null;
        this.tail = null;
    }

    public CalculationRecord getLatest() {
        return this.tail == null ? null : this.tail.getRecord();
    }

}
