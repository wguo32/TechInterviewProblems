/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */
 // use Priority Queue
class Solution {
    private Comparator<ListNode> listComparator = new Comparator<ListNode>(){
        public int compare(ListNode a, ListNode b) {
            return a.val - b.val;
        }
    };
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, listComparator);
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;
        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            cur.next = node;
            cur = cur.next;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}


// use divide and conquer
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return helper(lists, 0, lists.length - 1);
    }

    private ListNode helper(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }
        int mid = start + (end - start) / 2;
        ListNode first = helper(lists, start, mid);
        ListNode second = helper(lists, mid + 1, end);
        return mergeTwoLists(first, second);
    }

    private ListNode mergeTwoLists(ListNode head1, ListNode head2) {
        ListNode dummy = new ListNode(0);
        ListNode cur = dummy;

        while (head1 != null && head2 != null) {
            if (head1.val < head2.val) {
                cur.next = head1;
                head1 = head1.next;
            } else {
                cur.next = head2;
                head2 = head2.next;
            }
            cur = cur.next;
        }

        if (head1 != null) {
            cur.next = head1;
        }
        if (head2 != null) {
            cur.next = head2;
        }
        return dummy.next;
    }
}
