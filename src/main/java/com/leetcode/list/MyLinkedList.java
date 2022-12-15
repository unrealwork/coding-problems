package com.leetcode.list;

final class MyLinkedList {
    private Node head;
    private Node tail;
    private int size = 0;

    MyLinkedList() {
        this.head = null;
        this.tail = null;
    }

    int get(int index) {
        if (index > -1 && index < size) {
            Node it = head;
            int i = 0;
            while (it != null) {
                if (i == index) {
                    return it.val;
                }
                i++;
                it = it.next;
            }
        }
        return -1;
    }

    public void addAtHead(int val) {
        Node newNode = new Node(val);
        if (head == null) {
            head = newNode;
            tail = head;
        } else {
            newNode.next = head;
            head = newNode;
        }
        size++;
    }

    public void addAtTail(int val) {
        Node newNode = new Node(val);
        if (tail == null) {
            tail = newNode;
            head = tail;
        } else {
            tail.next = newNode;
            tail = newNode;
        }
        size++;
    }

    public void addAtIndex(int index, int val) {
        if (index > 0 && index < size) {
            Node newNode = new Node(val);
            int i = 0;
            Node it = head;
            while (i < index) {
                if (i + 1 == index) {
                    newNode.next = it.next;
                    it.next = newNode;
                    size++;
                    break;
                }
                i++;
                it = it.next;
            }
        }
        if (index == 0) {
            addAtHead(val);
        }
        if (index == size) {
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        if (index > 0 && index < size) {
            int i = 0;
            Node it = head;
            while (i < index) {
                if (i + 1 == index) {
                    Node next = it.next;
                    it.next = next.next;
                    if (next == tail) {
                        tail = it;
                    }
                    size--;
                    break;
                }
                i++;
                it = it.next;
            }
        }
        if (index == 0 && size > 0) {
            removeHead();
        }
    }

    private void removeHead() {
        if (head == tail) {
            head = null;
            tail = null;
        } else {
            head = head.next;
        }
        size--;
    }


    private static final class Node {
        private final int val;
        private Node next;

        private Node(int val) {
            this.val = val;
        }
    }
}
