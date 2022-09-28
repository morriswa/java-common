package org.morriswa.common.datatypes.singlylinked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedStructureTest {


    @Test
    void testisEmpty() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        assertTrue(newStruct.isEmpty());
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("hello"));
        assertFalse(newStruct.isEmpty());
    }

    @Test
    void testlength() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        assertEquals(0,newStruct.length());
        for (int i = 0; i < 70; i++) {
            newStruct.insertNodeAtTail(new SinglyLinkedNode<>("hello"));
        }
        assertEquals(70,newStruct.length());
    }

    @Test
    void testInsertAtFrontOnEmptyStruct() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        SinglyLinkedNode<String> newNode = new SinglyLinkedNode<>("hello");
        newStruct.insertNodeAtHead(newNode);

        assertEquals("hello",newStruct.getNodeAt(-1).entry);
        assertEquals("hello",newStruct.getNodeAt(0).entry);

    }

    @Test
    void testInsertAtFrontOnStruct() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));

        newStruct.insertNodeAtHead(new SinglyLinkedNode<>("0N:New hello"));

        assertEquals("0N:New hello",newStruct.getNodeAt(0).entry);
        assertEquals("0:hello",newStruct.getNodeAt(1).entry);
        assertEquals(4,newStruct.length());
    }

    @Test
    void popNodeAtIndexTest() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));

        assertEquals("0:hello",newStruct.popNodeAtIndex(0).entry);

        newStruct.clear();
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));
        assertEquals("1:world",newStruct.popNodeAtIndex(1).entry);
        assertEquals("2:hru",newStruct.popNodeAtIndex(1).entry);
    }

    @Test
    void insertNoteAtIndexTest() {
        LinkedStructure<String> newStruct = new LinkedStructure<>();
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("0:hello"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("1:world"));
        newStruct.insertNodeAtTail(new SinglyLinkedNode<>("2:hru"));
        assertEquals(9, newStruct.length());

        newStruct.insertNodeAtIndex(new SinglyLinkedNode<>("0N:hello"),0);
        assertEquals(10, newStruct.length());

        newStruct.insertNodeAtIndex(new SinglyLinkedNode<>("1N:world"),1);
        assertEquals(11, newStruct.length());

        assertEquals("0:hello",newStruct.getNodeAt(2).entry);
        assertEquals("1:world",newStruct.getNodeAt(3).entry);

        newStruct.insertNodeAtIndex(new SinglyLinkedNode<>("I want this at index 9"),9);
        assertEquals(12, newStruct.length());
        assertEquals("I want this at index 9",newStruct.getNodeAt(9).entry);
    }


}