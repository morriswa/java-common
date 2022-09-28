package org.morriswa.common.datatypes.singlylinked;

import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class LinkedListTest {

    @Test
    void at() {
        LinkedList<String> ll = new LinkedList<>();
        ll.push("0:hello");
        ll.push("1:world");
        ll.push("2:hru");
        ll.push("3:iam");
        ll.push("4:who");
        assertEquals("0:hello",ll.at(0));
        assertEquals("0:hello",ll.at(-ll.length()));

        assertEquals("2:hru",ll.at(2));
        assertEquals("2:hru",ll.at(-3));

        assertEquals("4:who",ll.at(4));
        assertEquals("4:who",ll.at(-1));

    }

    @Test
    void push() {
    }

    @Test
    void pushAt() {
    }

    @Test
    void pop() {
    }

    @Test
    void replace() {
    }
}