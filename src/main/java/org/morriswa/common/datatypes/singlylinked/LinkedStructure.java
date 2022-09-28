package org.morriswa.common.datatypes.singlylinked;

public class LinkedStructure<T> {
    // ATTR
    private SinglyLinkedNode<T> front;


    // INIT
    public LinkedStructure() {
        this.front = null;
    }

    public LinkedStructure(T entry) {
        this.front = new SinglyLinkedNode<>(entry);
    }


    // IDEMPOTENT METHODS
    public boolean isEmpty() {
        return this.front == null;
    }

    public int length() {
        if (this.isEmpty()) {
            return 0;
        }

        SinglyLinkedNode<T> jumper = this.front; // deref the first pointer on the list

        int i; // define an index tracker
        for (i = 0; !jumper.pointsBlank(); i++) {
            jumper = jumper.next;
        }
        return i + 1;

//        i = 0
//        jumper = self._head  # and
//
//        while not (jumper.points_blank() or jumper is None):  # while the node is not pointing to None,
//                jumper = jumper.next  # jump to that node
//        i += 1  # and increase the index tracker by 1
//        return i + 1
    }

    protected SinglyLinkedNode<T> getNodeAt(int index) { // return the node at a specified index, +/- permitted
        Integer adjustedIndex = null;
        if (index == 0) { // return the front if index is 0
            return this.front;
        }
        else if (index < 0) { // adjust the index in wraparound fashion index(-len()) == index(0)
            adjustedIndex = index + this.length();
        }
        else {
            adjustedIndex = index;
        }

        if (adjustedIndex >= this.length() || adjustedIndex < 0) { // check if the adjusted index actually points to anything
            throw new RuntimeException(
                    String.format("Cannot retrieve node at index %d, no such index exists!",index));
        }

        SinglyLinkedNode<T> jumper = this.front; // define a jumper at the head of the list
        for (int i = 0; i < adjustedIndex; i++) { // skip ahead until arrived at correct index
            jumper = jumper.next;
        }
        return jumper; // return the requested node
    }

    protected SinglyLinkedNode<T> getNodeAt(int index, int offset) {
        return this.getNodeAt(index + offset);
    }


    // METHODS
    public void clear() {
        this.front = null;
    }

    protected void insertNodeAtHead(SinglyLinkedNode<T> node) { // insert a node at the head of the list
        if (!this.isEmpty()) {
            node.next = this.front; // point the node to the old head
        }
        this.front = node; // assign the node at the head.
    }

    protected void insertNodeAtTail(SinglyLinkedNode<T> node) { // insert a node at the end of the list
        if (this.isEmpty()) {
            this.insertNodeAtHead(node); // assign the node at the head.
        } else { // if the list is not empty
            SinglyLinkedNode<T> tail = this.getNodeAt(-1); // get the node at the end of the list
            tail.next = node; // point it to the new node
        }
    }

    protected void insertNodeAtIndex(SinglyLinkedNode<T> node, int index) { // insert a node at a specified index
        if (this.isEmpty() || index == 0 || index == (-this.length())) {
            this.insertNodeAtHead(node);
        } else {
            SinglyLinkedNode<T> jumper = this.getNodeAt(index,-1); //  if the index is in-bound and defined,
            // jump to -1 it's current corresponding position
            node.next = jumper.next; // point the new node to the old node at desired insert index
            jumper.next = node; // insert the new node at the specified index, thus moving all other entries up 1
        }
    }

    protected SinglyLinkedNode<T> popNodeAtHead() { // delete the node at the head of the list
        if (this.length() > 1) { // if the list has more than 1 entries, delete the head
            SinglyLinkedNode<T> copyNode = this.front;
            this.front = this.front.next; // and reassign it to the next node
            return copyNode; // and return the deleted node
        } else if (this.length() == 1) { // if the list has 1 entry, clear the list and return the deleted node
            SinglyLinkedNode<T> copyNode = this.getNodeAt(0);
            this.clear();
            return copyNode;
        } else { // if the list has no entries throw an error
            throw new RuntimeException("Cannot perform operation on empty structure...");
        }
    }

    protected SinglyLinkedNode<T> popNodeAtTail() { // delete the node at the end of the list
        if (this.length() > 1) { // if the list has more than one entry
            SinglyLinkedNode<T> copyNode = this.getNodeAt(-1);
            SinglyLinkedNode<T> newTail = this.getNodeAt(-2); // get the entry before the tail index(-2) and
            newTail.next = null; // point it to null
            return copyNode; // return old tail
        } else {
            return this.popNodeAtHead();
        }
    }

    protected SinglyLinkedNode<T> popNodeAtIndex(int index) { // delete a node at a specified index
        if (this.length() > 1) {
            SinglyLinkedNode<T> delNode = this.getNodeAt(index);
            SinglyLinkedNode<T> beforeDelNode = this.getNodeAt(index, -1);

            if (delNode.pointsBlank()) {
                beforeDelNode.next = null;
            } else {
                beforeDelNode.next = this.getNodeAt(index, 1);
            }
            return delNode;
        } else {
            return this.popNodeAtHead();
        }
    }
}
