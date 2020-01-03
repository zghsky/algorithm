package algo.leetcode.test2;

/**
 * 给定一个链表和一个特定值 x，对链表进行分隔，使得所有小于 x 的节点都在大于或等于 x 的节点之前。
 * 你应当保留两个分区中每个节点的初始相对位置。
 *
 * 示例:
 * 输入: head = 1->4->3->2->5->2, x = 3
 * 输出: 1->2->2->4->3->5
 */
public class Solution86 {

    public static ListNode partition(ListNode head, int x) {
        if (head == null) return head;
        ListNode before = new ListNode(0);
        ListNode after = new ListNode(0);
        ListNode p = before;
        ListNode q = after;
        while (head !=  null) {
            if (head.val < x) {
                p.next = head;
                p = p.next;
            } else {
                q.next = head;
                q = q.next;
            }
            head = head.next;
        }
        q.next = null;
        p.next = after.next;
        return before.next;
    }
}
