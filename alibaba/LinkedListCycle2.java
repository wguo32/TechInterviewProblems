/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode detectCycle(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode intersec = getIntersec(head);
        if (intersec == null) {
            return intersec;
        }
        ListNode start = head;
        while (start != intersec) {
            start = start.next;
            intersec = intersec.next;
        }
        return intersec;
    }

    // get the intersection node in the list
    ListNode getIntersec(ListNode head) {
        if (head == null || head.next == null) {
            return null;
        }
        ListNode slow = head;
        ListNode fast = head;
        while (fast != null || fast.next != null) {
            if (fast == slow) {
                return fast;
            }
            fast = fast.next.next;
            slow = slow.next;
        }
        return null;
    }
}
