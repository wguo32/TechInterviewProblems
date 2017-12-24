/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) { val = x; }
 * }
 */

 /**
 divide and conquer approach
 space complexity preferred approach
 */
 class Solution {
     public ListNode mergeKLists(ListNode[] lists) {
         if (lists == null || lists.length == 0) {
             return null;
         }
         List<ListNode> result = new ArrayList<>();
         return helper(lists, 0, lists.length - 1);
     }

     public ListNode helper(ListNode[] lists, int start, int end) {
         if (start >= end) {
             return lists[start];
         }

         int mid = start + (end - start) / 2;
         ListNode left = helper(lists, start, mid);
         ListNode right = helper(lists, mid + 1, end);
         return mergeTwoLists(left, right);
     }

     public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
         if (list1 == null) {
             return list2;
         }
         if (list2 == null) {
             return list1;
         }

         ListNode dummy = new ListNode(-1);
         ListNode head = dummy;

         while (list1 != null && list2 != null) {
             if (list1.val <= list2.val) {
                 head.next = list1;
                 list1 = list1.next;
             } else {
                 head.next = list2;
                 list2 = list2.next;
             }
             head = head.next;
         }

         if (list1 != null) {
             head.next = list1;
         } else {
             head.next = list2;
         }
         return dummy.next;
     }
 }


 /**
 time complexity preferred approach with priority queue
priority queue approach
 */
class Solution {
    private Comparator<ListNode> listComparator = new Comparator<ListNode>() {
        public int compare(ListNode node1, ListNode node2) {
            return node1.val - node2.val;
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

        ListNode dummy = new ListNode(-1);
        ListNode head = dummy;

        while (!queue.isEmpty()) {
            ListNode node = queue.poll();
            head.next = node;
            head = node;
            if (node.next != null) {
                queue.offer(node.next);
            }
        }
        return dummy.next;
    }
}
