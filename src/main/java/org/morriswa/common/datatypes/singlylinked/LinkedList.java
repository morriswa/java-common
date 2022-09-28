package org.morriswa.common.datatypes.singlylinked;

public class LinkedList<T> extends LinkedStructure<T> {
    // init
    public LinkedList() {
        super();
    }


    // idempotent methods
    public T at(int index) {
        return this.getNodeAt(index).entry;
    }


    // methods
    public void push(T entry) {
        this.insertNodeAtTail(new SinglyLinkedNode<>(entry));
    }

    public void pushAt(T entry,int index) {
        this.insertNodeAtIndex(new SinglyLinkedNode<>(entry),index);
    }

    public T pop() {
        return this.popNodeAtTail().entry;
    }

    public T replace(T entry, int index) {
        SinglyLinkedNode<T> replacingDataIn = this.getNodeAt(index);
        T dataCopy = replacingDataIn.entry;
        replacingDataIn.entry = entry;
        return dataCopy;
    }
}
