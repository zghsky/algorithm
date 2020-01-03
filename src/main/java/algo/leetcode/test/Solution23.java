package algo.leetcode.test;

import java.util.PriorityQueue;

/**
 * 合并 k 个排序链表，返回合并后的排序链表。请分析和描述算法的复杂度。
 * 示例:
 * 输入:
 * [ 
 *   1->4->5, 
 *   1->3->4,
 *   2->6
 * ]
 * 输出: 1->1->2->3->4->4->5->6
 */
public class Solution23 {
    public static void main(String[] args) {

        ListNode list1 = new ListNode(1);
        ListNode p1 = list1;
        p1.next = new ListNode(4);
        p1 = p1.next;
        p1.next = new ListNode(5);

        ListNode list2 = new ListNode(1);
        p1 = list2;
        p1.next = new ListNode(3);
        p1 = p1.next;
        p1.next = new ListNode(4);

        ListNode list3 = new ListNode(2);
        p1 = list3;
        p1.next = new ListNode(6);

        ListNode[] listNodes = { list1, list2, list3 };
        printList(listNodes[0]);
        printList(listNodes[1]);
        printList(listNodes[2]);

        ListNode result = margeKLists2(listNodes);
        printList(result);


        ListNode list4 = new ListNode(1);
        ListNode list5 = new ListNode(0);
        ListNode[] listNodes2 = { list4, list5 };
        ListNode marge = margeKLists2(listNodes2);
        printList(marge);

        ListNode list6 = new ListNode(-1);
        p1 = list6;
        p1.next = new ListNode(-1);
        p1 = p1.next;
        p1.next = new ListNode(-1);

        ListNode list7 = new ListNode(-2);
        p1 = list7;
        p1.next = new ListNode(-2);
        p1 = p1.next;
        p1.next = new ListNode(-1);

        ListNode[] listNodes3 = { list6, list7 };
        ListNode marge2 = margeKLists2(listNodes3);
        printList(marge2);
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */

    // 分治法
    public static ListNode margeKLists(ListNode[] lists) {

        if (lists == null || lists.length == 0) return null;
        return marge(lists, 0, lists.length - 1);
    }

    private static ListNode marge(ListNode[] lists, int left, int right) {
        if (left == right) return lists[left];
        int mid = left + (right - left) / 2;
        ListNode list1 = marge(lists, left, mid);
        ListNode list2 = marge(lists, mid + 1, right);
        return margeTwoLists(list1, list2);
    }

    private static ListNode margeTwoLists(ListNode list1, ListNode list2) {
        if (list1 == null) return list2;
        if (list2 == null) return list1;
        if (list1.val < list2.val) {
            list1.next = margeTwoLists(list1.next, list2);
            return list1;
        } else {
            list2.next = margeTwoLists(list1, list2.next);
            return list2;
        }
    }

    public static void printList(ListNode list) {
        while (list != null) {
            System.out.print(list.val + " ");
            list = list.next;
        }
        System.out.println();
    }

    // 优先队列法
    public static ListNode margeKLists2(ListNode[] lists) {
        if (lists == null || lists.length == 0) return null;
        PriorityQueue<ListNode> queue = new PriorityQueue<>(lists.length, (o1, o2) -> {
            if (o1.val < o2.val) return -1;
            else if (o1.val == o2.val) return 0;
            else return 1;
        });
        ListNode dummy = new ListNode(0);
        ListNode p = dummy;
        for (ListNode node : lists) {
            if (node != null) queue.add(node);
        }
        while (!queue.isEmpty()) {
            p.next = queue.poll();
            p = p.next;
            if (p.next != null) {
                queue.add(p.next);
            }
        }
        return dummy.next;
    }
}

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
