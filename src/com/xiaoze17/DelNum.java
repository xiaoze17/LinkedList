package com.xiaoze17;


public class DelNum {
    //非递归实现
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

    //递归实现链表删除
    public static ListNode recurDeleEle(ListNode head, int val,int depth) {

        String depthString = generateDepthString(depth);
        System.out.print(depthString);
        System.out.println("Call: remove "+val+" in " + head);

        if (head == null) {
            System.out.print(depthString);
            System.out.println("Return: "+head);
            return null;
        }

        ListNode res = recurDeleEle(head.next,val,depth+1);
        System.out.print(depthString);
        System.out.println("After remove "+val+": "+res);

        ListNode ret;
        if (head.val == val) {
            ret = res;
        }else{
            //就是这句话不会写
            head.next = res;
            //好难上面这句话
            ret = head;
        }
        System.out.print(depthString);
        System.out.println("Return: "+ret);
        return ret;
        //更装逼的写法，我就看看
        //head.next = recurDeleEle(head.next, val);
        //return head.val == val ? head.next : head;
    }

//    public static ListNode recurDeleEle(ListNode head, int val){
//        if (head == null) {
//            return null;
//        }
//        ListNode res = recurDeleEle(head.next, val);
//        if(head.val == val){
//            return res;
//        }else{
//            head.next = res;
//            return head;
//        }
//
//    }

    private static String generateDepthString(int depth) {
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++) {
            res.append("--");
        }
        return res.toString();
    }


    public static void main(String[] args) {
        int[] arr = {1,2,3,4,5,6,7,6,6,6};
        ListNode listNode = new ListNode(arr);
        System.out.println(listNode);

//        ListNode ll1 = removeElements(listNode, 6);
//        System.out.println(ll1);

        ListNode lN2 = recurDeleEle(listNode, 6, 0);
        System.out.println(lN2);
    }
}
