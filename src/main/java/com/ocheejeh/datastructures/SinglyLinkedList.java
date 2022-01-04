package com.ocheejeh.datastructures;

import java.util.NoSuchElementException;

public class SinglyLinkedList {
    private Node first;
    private Node last;

    private class Node {
        int data;
        Node next;

        public Node(int data) {
            this.data = data;
            this.next =  null;
        }
    }

    public void addLast(int item) {
        Node node = new Node(item);
        if(first == null) {
            first = last = node;
        } else {
            last.next = node;
            last = node;
        }
    }

    public void addFirst(int item){
        var node = new Node(item);
        if(first == null){
            first = last = node;
        } else {
            node.next  = first;
            first = node;
        }
    }

    public int indexOf(int item){ //this operation is in the order, O(n)
        int index = 0;
        Node startFromFirstNode = first;
        while (startFromFirstNode != null){
            if(startFromFirstNode.data == item){
                return index;
            }
            startFromFirstNode = startFromFirstNode.next;
            index++;
        }
        return -1;
    }

    public boolean contains(int item){
        return indexOf(item) != -1;
    }

    public void deleteFirst(){
        if(first == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        var second = first.next;
        first.next = null;
        first = second;
    }

    public void deleteLast(){
        if(first == null) throw new NoSuchElementException();
        if(first == last){
            first = last = null;
            return;
        }
        Node previous = first;
        while (previous  != null) {
            if(previous.next == last){
                last = previous;
                last.next = null;
            }
            previous  = previous.next;
        }
    }
}
