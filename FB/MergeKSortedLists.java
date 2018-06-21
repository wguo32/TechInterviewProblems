/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 // divide and conquer with O(1) space complexity and O(Nlogk) time complexity
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        return divideConq(lists, 0, lists.length - 1);
    }

    private ListNode divideConq(ListNode[] lists, int start, int end) {
        if (start >= end) {
            return lists[start];
        }

        int mid = start + (end - start) / 2;
        ListNode first = divideConq(lists, start, mid);
        ListNode second = divideConq(lists, mid + 1, end);
        return mergeTwoLists(first, second);
    }

    private ListNode mergeTwoLists(ListNode first, ListNode second) {
        if (first == null) {
            return second;
        }
        if (second == null) {
            return first;
        }
        ListNode pre = new ListNode(0);
        ListNode dummy = pre;
        while (first != null && second != null) {
            if (first.val < second.val) {
                pre.next = first;
                first = first.next;
            } else {
                pre.next = second;
                second = second.next;
            }
            pre = pre.next;
        }
        if (first == null) {
            pre.next = second;
        }
        if (second == null) {
            pre.next = first;
        }
        return dummy.next;
    }
}

// use priority queue, O(k) space complexity and O(Nlogk) time complexity
class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        if (lists == null || lists.length == 0) {
            return null;
        }

        Comparator<ListNode> listComp = new Comparator<ListNode> (){
            public int compare(ListNode a, ListNode b) {
                return a.val - b.val;
            }
        };

        Queue<ListNode> queue = new PriorityQueue<>(lists.length, listComp);
        for (ListNode head : lists) {
            if (head != null) {
                queue.offer(head);
            }
        }

        ListNode dummy = new ListNode(0);
        ListNode pre = dummy;

        while (!queue.isEmpty()) {
            ListNode smallest = queue.poll();
            pre.next = smallest;
            pre = smallest;

            if (smallest.next != null) {
                queue.offer(smallest.next);
            }
        }
        return dummy.next;
    }
}
