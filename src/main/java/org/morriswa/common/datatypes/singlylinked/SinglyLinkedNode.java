package org.morriswa.common.datatypes.singlylinked;

public class SinglyLinkedNode<T> {
    public T entry;
    public SinglyLinkedNode<T> next;

    public SinglyLinkedNode(T entry) {
        this.entry = entry;
        this.next = null;
    }

    public SinglyLinkedNode(T entry, SinglyLinkedNode<T> next) {
        this.entry = entry;
        this.next = next;
    }

    public boolean pointsBlank() {
        return this.next == null;
    }
}
