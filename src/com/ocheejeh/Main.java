package com.ocheejeh;

import com.ocheejeh.datastructures.CustomArray;
import com.ocheejeh.datastructures.SinglyLinkedList;
import com.ocheejeh.datastructures.Stack;

public class Main {

    public static void main(String[] args) {
        //System.out.println("Hello World!");
        Stack demoStack = new Stack();
        demoStack.push(50);
        demoStack.push(30);
        System.out.println("top element = " + demoStack.peek());
        System.out.println("I just removed the top = " + demoStack.pop());
        System.out.println("top element is now = " + demoStack.peek());
        CustomArray number = new CustomArray(3);
        number.insert(1);
        number.insert(2);
        number.insert(3);
        number.insert(4);
        number.insert(5);
        number.print();
        number.removeAtV2(0);
        number.print();
        number.removeAtV2(3);
        number.print();
        number.insert(10);
        number.print();
        SinglyLinkedList linkedList = new SinglyLinkedList();
        linkedList.addLast(10);
        linkedList.addLast(20);
        linkedList.addFirst(5);
        linkedList.addFirst(10);
        linkedList.addLast(20);

        linkedList.deleteFirst();
        linkedList.addLast(30);
        linkedList.addLast(50);
        linkedList.deleteLast();
    }
}
