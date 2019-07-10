package com.xiaoze17;


public class DelNum {

    public static ListNode removeElements(ListNode head, int val) {

        ListNode dummyhead = new ListNode(-1);
        dummyhead.next = head;

        ListNode prev = dummyhead;
        while (prev.next != null) {
            if (prev.next.val == val) {
                ListNode delNode = prev.next;
                prev.next = delNode.next;
                delNode.next = null;
            }else{
                prev = prev.next;
            }
        }
        return dummyhead.next;
    }

    public static void main(String[] args) {
        int[] arr = {};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);
        ListNode ll1 = removeElements(listNode, 6);
        System.out.println(ll1);
    }


}
