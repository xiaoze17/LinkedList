package com.xiaoze17;

public class LinkedList<E> {
    private class Node{
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }
        public Node(){
            this(null, null);
        }

        @Override
        public String toString() {
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList() {
        head = new Node();
        size = 0;
    }
    public int getSize() {
        return size;
    }

    public boolean isEmpty() {
        return size == 0;
    }

    public void add(int index, E e) {
        //head = new Node();
        Node prev = head;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        prev.next = new Node(e, prev.next);
        size++;
    }

    //递归实现链表插入操作
    //未完成，不会做，现在
    public void recurAdd(int index, E e) {
        return;

    }

    private void recurAdd(int index, E e, int l) {

    }

    public void addFirst(E e) {
        add(0, e);
    }

    public void addLast(E e) {
        add(size, e);
    }

    public E remove(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Remove failed, Illegal index");
        }
        Node pre = head;
        for (int i = 0; i < index; i++) {
            pre = pre.next;
        }
        Node reNode = pre.next;
        pre.next = reNode.next;
        reNode.next = null;
        size--;
        return reNode.e;
    }

    public E removeFirst() {
        return remove(0);
    }

    public E removeLast() {
        return remove(size - 1);
    }

    public E get(int index) {
        if(index < 0 || index >= size){
            throw new IllegalArgumentException("Get failed, Illegal index");
        }

        Node cur = head;
        for (int i = 0; i < index+1; i++) {
            cur = cur.next;
        }
        return cur.e;
    }
    public String toString() {
        StringBuilder res = new StringBuilder();
        Node temp = head.next;
        res.append("LinkedList: top [");
        for (int i = 0; i < size; i++) {
            res.append(temp.e);
            if (i != size - 1) {
                res.append("->");

            }
            temp = temp.next;
        }
        res.append("]");
        return res.toString();
    }

    public static void main(String[] args) {
        LinkedList<Integer> ll = new LinkedList<>();
        ll.addLast(1);
        ll.addLast(2);
        ll.addLast(3);
        ll.addFirst(-1);
        ll.addFirst(-2);
        ll.add(2, 0);
        System.out.println(ll);
        ll.removeLast();
        ll.removeFirst();
        System.out.println(ll);


    }
}
