package algo.leetcode.test;

/**
 * 给定一个链表，旋转链表，将链表每个节点向右移动 k 个位置，其中 k 是非负数。
 *
 * 示例 1:
 * 输入: 1->2->3->4->5->NULL, k = 2
 * 输出: 4->5->1->2->3->NULL
 * 解释:
 * 向右旋转 1 步: 5->1->2->3->4->NULL
 * 向右旋转 2 步: 4->5->1->2->3->NULL
 *
 * 示例 2:
 * 输入: 0->1->2->NULL, k = 4
 * 输出: 2->0->1->NULL
 * 解释:
 * 向右旋转 1 步: 2->0->1->NULL
 * 向右旋转 2 步: 1->2->0->NULL
 * 向右旋转 3 步: 0->1->2->NULL
 * 向右旋转 4 步: 2->0->1->NULL
 */
public class Solution61 {
    public static void main(String[] args) {
        ListNode list = new ListNode(0);
        ListNode p = list;
        p.next = new ListNode(1);
        p = p.next;
        p.next = new ListNode(2);

        ListNode listNode = rotateRight(list, 3);
        Solution23.printList(listNode);
        System.out.println(countListNode(list));
    }

    /**
     * Definition for singly-linked list.
     * public class ListNode {
     *     int val;
     *     ListNode next;
     *     ListNode(int x) { val = x; }
     * }
     */
    public static ListNode rotateRight(ListNode head, int k) {
        if (head == null) return null;

        int count = countListNode(head);
        k %= count;

        ListNode p1 = head;
        ListNode p2 = head;
        while (k-- > 0) {
            p1 = p1.next;
            if (p1 == null)
                p1 = head;
        }
        if (p1 == head) return head;
        while (p1.next != null) {
            p1 = p1.next;
            p2 = p2.next;
        }
        ListNode tmp = p2.next;
        p2.next = null;
        p1.next = head;
        return tmp;
    }

    private static int countListNode(ListNode head) {
        int count = 0;
        while (head != null) {
            head = head.next;
            count++;
        }
        return count;
    }
}
