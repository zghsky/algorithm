package algo.leetcode.test;

// 给定 1->2->3->4, 你应该返回 2->1->4->3.
public class Solution24 {
    public static void main(String[] args) {

        ListNode list = new ListNode(1);
        ListNode p = list;
        p.next = new ListNode(2);
        p = p.next;
        p.next = new ListNode(3);
        p = p.next;
        p.next = new ListNode(4);

        Solution23.printList(list);
        list = swapPairs2(list);
        Solution23.printList(list);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode swapPairs(ListNode head) {

        if (head == null || head.next == null)
            return head;
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        ListNode p1 = head;
        ListNode p2 = head.next;
        while (p2 != null && p1 != null) {
            p1.next = p2.next;
            p2.next = p1;
            p.next = p2;
            p = p.next.next;
            p1 = p1.next;
            if (p1 != null)
                p2 = p1.next;
        }
        return dummy.next;
    }

    //  迭代
    public static ListNode swapPairs1(ListNode head) {
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        while (head != null) {
            if (head != null && head.next != null) {
                ListNode tmp = head.next;
                p.next = tmp;
                head.next = head.next.next;
                tmp.next = head;
                head = head.next;
                p = p.next.next;
            } else {
                p.next = head;
                head = head.next;
            }
        }
        return dummy.next;
    }

    //  递归
    public static ListNode swapPairs2(ListNode head) {
        if (head == null || head.next == null) return head;
        ListNode tmp = head.next;
        head.next = swapPairs2(head.next.next);
        tmp.next = head;
        return tmp;
    }
}
